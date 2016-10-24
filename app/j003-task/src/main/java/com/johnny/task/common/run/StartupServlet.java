package com.johnny.task.common.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.johnny.common.util.DateUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.business.service.TaskService;
import com.johnny.task.common.data.SysDataDictionary;
import com.johnny.task.model.TaskBO;
/**
 * 类 编 号：
 * 类 名 称：StartupServlet.java
 * 内容摘要：服务器启动类
 * 1、 线程的控制
 * 完成日期：2016-3-23
 * 编码作者：JohnnyHuang
 */
public class StartupServlet  extends HttpServlet{
	/**
	 * 名 称：
	 * 编码作者：JohnnyHuang
	 */
	private static final long serialVersionUID = 1L;
	protected Log log = LogFactory.getLog(getClass());
	private static List<TaskBO> schedulers;
//	private static Vector<SchedulerObject> schedulers = null;
	private TaskService taskService;
	@Override
	public void init()  throws ServletException{
		taskService = (TaskService) getBean("taskServiceImpl");
		log.debug(this.getClass().getName() + "服务器启动=========init()");
		// 从 web.xml 中决定调度线程是否处于挂起状态
		boolean bSuspend = false;
		String strSuspend = getServletConfig().getInitParameter("suspend");
		log.debug("=================服务器线程挂起状态为："+strSuspend);
		if (strSuspend != null)
		{
			if (strSuspend.trim().equalsIgnoreCase("true"))
				bSuspend = true;
		}
		if(!bSuspend)//挂起 状态代表服务器不执行定时任务
		{
			inithread();
		}
	}
	
	public void inithread() throws ServletException{
		// 检验是否重入（不应该出现重入）
		if (schedulers != null)
		{
			String msg = "!!!!!!!! re-enter StartupServlet !!!!!!!!";
			log.info(this.getClass().getName() + msg);
			throw new ServletException(msg);
		}
		schedulers = new ArrayList<TaskBO>();
		//载入排队、活动、挂起的线程
		List<TaskVO> threadVOs = taskService.get(queryString, params);
		for (int i = 0; i < threadVOs.size(); i++) {
			
		}
		
		// 从 web.xml 中决定调度线程是否处于挂起状态
		boolean bSuspend = false;
		String strSuspend = getServletConfig().getInitParameter("suspend");
		if (strSuspend != null)
		{
			if (strSuspend.trim().equalsIgnoreCase("true"))
				bSuspend = true;
		}

		// 加载所有需要的调度线程
		for (int i = 0; i < threadVOs.size(); i++)
		{
			TaskVO so = threadVOs.get(i);
			TaskBO baseBO = new TaskBO();
			baseBO.setThreadVO(so);
			log.debug(so.toString());
			try
			{
				Class threadClass = Class.forName(so.getClassName());
				BaseTask bst = (BaseTask) threadClass.newInstance();
				baseBO.setThread(bst);
				schedulers.add(baseBO);
				bst.setSchedule(Integer.parseInt(so.getRptInterval()), 0, DateUtil.dateToString(so.getSchedStartDt()));
				bst.setSchedule(so.getRowId(), so.getMethod());
				if (bSuspend || so.getStatus().equals(SysDataDictionary.THREAD_STATUS_PENDING))
					bst.suspendSchedule();
				//定时工作开始，修改 排队中的状态为 活动；活动中的不用修改
				bst.start();
			}
			catch (ClassNotFoundException e)
			{
				log.error(this.getClass().getName() + " can not found class [" + so.getClassName() + "]");
			}
			catch (Exception e)
			{
				log.error(this.getClass().getName() + " " + e.getMessage());
				throw new ServletException(e);
			}

			log.info(this.getClass().getName() + so.toString());
		}
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		log.info("=========service=========");
		
	}

	@Override
	public void destroy() {
		log.info("服务器停止=========destroy=========");
		log.info(this.getClass().getName() + ".destroy()");

		for (int i = 0; i < schedulers.size(); i++)
		{
			TaskBO so = schedulers.get(i);
			BaseTask bst = so.getThread();
			if (bst != null)
				bst.notifyStop();
			so.setThread(null);
			//未完成的线程，修改状态为 错误 -服务器停止引发的错误
		}
	}
	
	/**
	 * 
	 * @Description: TODO 根据名称获取线程对象
	 * @param @param name
	 * @param @return   
	 * @return SchedulerObject  
	 * @throws
	 * @author JohnnyHuang
	 * @date 2016-3-23
	 */
	public static TaskBO getSchdulerObject(Long rowId)
	{
		for (int i = 0; i < schedulers.size(); i++)
		{
			TaskBO so = schedulers.get(i);
			if (so.getThreadVO().getRowId()==rowId)
				return so;
		}
		return null;
	}

	public static List<TaskBO> getSchedulers() {
		return schedulers;
	}
	
    /**
     * 获取bean实例
     * 业务描述：XXX 
     * 作          者：JohnnyHuang 黄福强
     * 完成日期：2015-7-24
     * @param beanId
     * @return
     */
    protected Object getBean(String beanId)
    {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
		return wac.getBean(beanId);
    }
}
