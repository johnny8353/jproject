/**
  * 作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
  */
package com.johnny.task.common.run;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.johnny.common.util.StringUtil;
import com.johnny.task.business.service.TaskService;

/**
 * 类 编 号：
 * 类 名 称：BaseSchedulerThread.java 
 * 内容摘要：作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
 * 完成日期：2016-3-23
 * 编码作者：JohnnyHuang 黄福强
 */
public abstract class BaseTask extends Thread
{
	protected Log log = LogFactory.getLog(getClass());
	
    protected Object semaphore = null;//锁控制

    protected volatile boolean needStop = false;//终止控制

    protected volatile boolean bSchedule = true;//挂起控制

    protected volatile boolean bWakeupOnce = false;//单次唤醒控制

    protected long timeslice = 15 * 1000;

    protected long timeoffset = 0L;

    private String param = null;
    
    private Long ptid;//父 Id
    
    private String tid;
    
    private String method;
    
    private String schedStartDate = "";//预计开始时间

    public String getParam()
    {
        return this.param;
    }

    public void clearParam()
    {
        this.param = null;
         
    }
    
    // 此属性为SyncOCUThread类而增加，从HttpServlet传递配置路径至OcuUtil
    private String configPath = "";

    public BaseTask()
    {
    	
        this(15, 0);
    }
	
    @Override
	public void run() 
    {
    	//schedStartDate 必输字段
    	if(schedStartDate.equals("")){//普通任务
    		CommonRun();
    	}else{//定时任务
    		ScheduleRun();
    	}
    }
    private void CommonRun(){
    	doWakeUp(ptid,method);
    }
    
    private void ScheduleRun(){
    	TaskService taskService  = (TaskService) getBean("taskService");
    	log.info(this.getClass().getName()+" entering " + getClass().getName());
    	//新建重复线程记录，活动状态
    	Long sId = 0L;
        long t0 = 0L;
        
        int  i = 0;

        while (!needStop) {
            t0 = System.currentTimeMillis();
            // 睡眠
            try {
                if (bSchedule || bWakeupOnce) 
                {
                    i++;
                    // 调度发送
                    if ((bSchedule || bWakeupOnce) && (i>1) )  
                    {
                        synchronized (semaphore) 
                        {
                            interrupted();
//                        	sId = taskService.InitRpdSThread(ptid,"");
                            doWakeUp(sId,method);
                        }
                    }
                    bWakeupOnce = false;
                    
                    if (i ==1)
                    {
                    	/** 今天2016-03-23 16:20:00
                    	 * 指定时间在当前时间之后	睡眠到指定时间
                    	 * 指定时间在当前时间之前	修改时间为今天 如2015-03-23 16:50:00修改2016-03-23 16:50:00
                    	 * 		修改后：指定时间在当前时间之后	
                    	 * 		判断
                    	 * 					当前时间与指定时间间隔t 如果 >执行间隔 不睡眠
                    	 * 					当前时间与指定时间间隔t 如果<执行间隔  睡眠t时间
                    	 * 		修改后：指定时间在当前时间之前 不睡眠	
                    	 */
                    	//获取指定时间
                    	Date dNow = new Date();
                    	Date dSched = stringToDate(schedStartDate,"yyyy-MM-dd HH:mm:ss");
                    	long between = dSched.getTime() - dNow.getTime();// 得到两者的毫秒数
                    	String sNow = dateToString(dNow, "yyyy-MM-dd HH:mm:ss");
                    	log.info(sNow+"---"+schedStartDate+"----between:"+between);
                    	if(between>0){
                    		log.info("----指定时间在当前时间之后	睡眠到指定时间:"+between);
                    		sleep(between);
                    	}else{
                    		//修改时间为今天 如2015-03-23 16:50:00修改2016-03-23 16:50:00
                    		String sNow2 = dateToString(dNow, "yyyy-MM-dd");
                    		String sSched = dateToString(dSched, "HH:mm:ss");
                    		dSched = stringToDate(sNow2+" "+sSched,"yyyy-MM-dd HH:mm:ss");
                    		long between2 = dSched.getTime() - dNow.getTime();
                    		if(between2>0){
                    			if(timeslice>between2)//当前时间与指定时间间隔t 如果<执行间隔  睡眠t时间
	                    		{
	                    			log.info("----修改后：指定时间在当前时间之后：当前时间与指定时间间隔t 如果<执行间隔"+timeslice+"  睡眠t时间:"+between2);
	                    			sleep(between2);
	                    		}else{
	                    			log.info("----修改后：指定时间在当前时间之后：当前时间与指定时间间隔t 如果 >执行间隔"+timeslice+" 不睡眠:"+between2);
	                    		}
                        	}else{
                        		log.info("----修改后：指定时间在当前时间之前 不睡眠	");
                        	}
                    	}
                        
                    }
                    else
                    {
                    	// 8:10启动 30分钟一次
//                    	ZTE===========================TestCaseThread
//            			2016-03-23 16:06:00,594 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:110)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThread(30000,3000): 1458720360594 + 0 - 27594
//            			2016-03-23 16:06:00,594 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:114)
//            			DEBUG: sleep time:2506
//            			2016-03-23 16:06:03,102 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:144)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThreadwake up - 16:06:03
//            			2016-03-23 16:06:03,103 org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:245)
//            			ZTE===========================TestCaseThread
//            			2016-03-23 16:06:03,103 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:110)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThread(30000,3000): 1458720363103 + 0 - 103
//            			2016-03-23 16:06:03,103 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:114)
//            			DEBUG: sleep time:29997
//            			2016-03-23 16:06:33,100 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:144)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThreadwake up - 16:06:33
//            			2016-03-23 16:06:33,100 org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:245)
//            			ZTE===========================TestCaseThread
//            			2016-03-23 16:06:33,100 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:110)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThread(30000,3000): 1458720393100 + 0 - 100
//            			2016-03-23 16:06:33,100 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:114)
//            			DEBUG: sleep time:30000
//            			2016-03-23 16:07:03,101 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:144)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThreadwake up - 16:07:03
//            			2016-03-23 16:07:03,101 org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:245)
//            			ZTE===========================TestCaseThread
//            			2016-03-23 16:07:03,102 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:110)
//            			DEBUG: com.zte.mcrm.system.common.run.system.TestCaseThread(30000,3000): 1458720423101 + 1 - 102
//            			2016-03-23 16:07:03,102 com.zte.mcrm.framework.common.run.BaseSchedulerThread.run(BaseSchedulerThread.java:114)
//            			DEBUG: sleep time:29998

                        long t = (System.currentTimeMillis() - timeoffset) % timeslice;
    
                        log.debug(this.getClass().getName() + "(" + timeslice + "," + timeoffset + "): " + t0+ " + " + (System.currentTimeMillis() - t0) + " - " + t);

                        long t1 = timeslice - t + 100;
                        
                        log.debug("sleep time:" + t1);
                        
                        if (t1 > 0 )
                        {
                            sleep(t1);
                        }
                        else
                        {
                            sleep(timeslice);
                        }
                    }
                   
                } 
                else
                {
                    // 睡眠 forever
                    sleep( 0xffffffffL );
                }

            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            catch (Exception ex)
            {
            	ex.printStackTrace();
                log.error(ex);
            }

            log.debug(this.getClass().getName()+"wake up - " + StringUtil.getDateWithFormat("HH:mm:ss"));
        }     
    }
    
    /** 指定唤醒周期。进程将根据指定的周期在整点被唤醒。 */
    public BaseTask(int periodSec)
    {
        this(periodSec, 0);
    }

    /** 指定唤醒周期和唤醒时间偏移。 */
    public BaseTask(int periodSec, int offsetSec)
    {
        this(periodSec, offsetSec, new StringBuffer());
    }

    public BaseTask(int periodSec, int offsetSec, Object semaphore)
    {
        if (periodSec < 15)
            periodSec = 15;
        if (offsetSec < 0)
            offsetSec = 0;
        offsetSec = offsetSec % periodSec;
        this.timeslice = periodSec * 1000L;
        this.timeoffset = offsetSec * 1000L;
        this.semaphore = semaphore;
    }

    /**
     * 设置唤醒周期及其相对于整点的偏移量。
     * <p>
     * 唤醒周期以秒为单位，最小有效值为 15。<br>
     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
     */
    public void setSchedule(int periodSec, int offsetSec,String startDate)
    {
        if (periodSec < 15)
            periodSec = 15;
        if (offsetSec < 0)
            offsetSec = 0;
        offsetSec = offsetSec % periodSec;
        this.timeslice = periodSec * 1000L;
        this.timeoffset = offsetSec * 1000L;
        this.schedStartDate = startDate;
        
    }
    /**
     * 设置唤醒周期及其相对于整点的偏移量。
     * <p>
     * 唤醒周期以秒为单位，最小有效值为 15。<br>
     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
     */
    public void setSchedule(Long ptid,String methodName)
    {
        this.ptid = ptid;
        this.method = methodName;
    }
    
    /** 通知线程挂起。 */
    public void suspendSchedule()
    {
            bSchedule = false;
            interrupt();
    }

    /** 通知线程恢复。 */
    public void resumeSchedule()
    {
            bSchedule = true;
            interrupt();
    }

    /** 通知线程终止。 */
    public void notifyStop()
    {
            needStop = true;
            interrupt();
    }

    /** 通知线程唤醒一次，不影响原来的“挂起/恢复”状态。 */
    public void notifyWakeup()
    {
            bWakeupOnce = true;
            interrupt();
    }

    /** 用给定的参数，通知线程唤醒一次，不影响原来的“挂起/恢复”状态。 */
    public void notifyWakeup(String param)
    {
            bWakeupOnce = true;
            this.param = param;
            interrupt();
    }


    /**
     * 
     * @Description: 需在扩展类中定义的实际业务操作，每次线程被唤醒后将调用一次该方法。
     * @param @param tid
     * @param @param method   方法
     * @return void  
     * @throws
     * @author JohnnyHuang 黄福强
     * @date 2016-3-23
     */
    abstract protected void doWakeUp(Long tid,String method);

    /**
     * Gets the realPath
     * 
     * @return Returns a String
     */
    public String getConfigPath()
    {
        return configPath;
    }

    /**
     * Sets the realPath
     * 
     * @param realPath
     *            The realPath to set
     */
    public void setConfigPath(String configPath)
    {
        this.configPath = configPath;
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


	public Long getPtid() {
		return ptid;
	}

	public void setPtid(Long ptid) {
		this.ptid = ptid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSchedStartDate() {
		return schedStartDate;
	}

	public void setSchedStartDate(String schedStartDate) {
		this.schedStartDate = schedStartDate;
	}

	public String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			return new SimpleDateFormat(pattern).format(date);
		} catch (Exception e) {
		}
		return null;
	}
    
	public static Date stringToDate(String dateString, String dateFormat) {
		if (("".equals(dateString)) || (dateString == null)) {
			return null;
		}
		try {
			return new SimpleDateFormat(dateFormat).parse(dateString);
		} catch (Exception e) {
		}
		return null;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
