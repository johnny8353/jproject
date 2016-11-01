/**
  * 作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
  */
package com.johnny.task.common.run;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.johnny.common.util.DateUtil;
import com.johnny.common.util.StringUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.business.service.TaskService;
import com.johnny.task.common.data.SysDataDictionary;

/**
 * 类 编 号：
 * 类 名 称：BaseSchedulerThread.java 
 * 内容摘要：作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
 * 周期1分钟，任务需要执行两分钟  的执行情况：
 * 
 * 完成日期：2016-3-23
 * 编码作者：JohnnyHuang 黄福强
 */
public abstract class BaseTaskImpl extends Thread implements BaseTask
{
	protected Log log = LogFactory.getLog(getClass());
	private Object semaphore = null;// = new byte[0]; // 特殊的instance变量 锁控制

    protected volatile boolean needStop = false;//终止控制

    protected volatile boolean bSchedule = true;//挂起控制

    protected volatile boolean bWakeupOnce = false;//单次唤醒控制
    
    protected TaskVO sTaskvo;//子Task
    protected TaskVO pTaskvo;//父task

    protected long timeoffset = 0L;

    protected String param = null;
    

    public String getParam()
    {
        return this.param;
    }

    public void clearParam()
    {
        this.param = null;
         
    }
    
    private String configPath = "";

    public BaseTaskImpl()
    {
    	
        this(15, 0);
    }
	
    @Override
	public void run() 
    {
    	//schedStartDate 必输字段
    	if(pTaskvo.getSchedStartDt() == null){//普通任务
    		CommonRun();
    	}else{//定时任务
    		ScheduleRun();
    	}
    }
    private void CommonRun(){
//    	doWakeUp(ptid,method);
    }
    public void setSemaphore(Object semaphore){
    	this.semaphore = semaphore;
    }
    private void ScheduleRun(){
    	TaskService taskService  = (TaskService) getBean("taskServiceImpl");
    	log.info(pTaskvo.getDescText()+pTaskvo.getClassName()+" entering " + getClass().getName());
    	//新建重复线程记录，活动状态
        long t0 = 0L;
        String nextExeTimeStr = "";
        Long rptInterval = Integer.parseInt(pTaskvo.getRptInterval()) *1000L;//执行间隔，单位秒
        int waittime = 1;//默认一次，如果执行过需要等待一次
        int  i = 0;

        while (!needStop) {
            t0 = System.currentTimeMillis();
            // 睡眠
            try {
                if (bSchedule || bWakeupOnce) 
                {
                    i++;
                    // 调度发送
                    if ((bSchedule || bWakeupOnce) && (i>waittime) )  
                    {
                        synchronized (semaphore) 
                        {
                            interrupted();
                            //保存一条执行记录
                            sTaskvo = getSonActiveTaskVO(pTaskvo);
                            sTaskvo.setActlStartDt(new Date());
                        	taskService.save(sTaskvo);
                        	//aop
                        	BaseTask bst = (BaseTask)getBean(pTaskvo.getClassName());
                        	bst.doTaskWakeUp(sTaskvo);
                        }
                    }
                    bWakeupOnce = false;
                    
                    if (i ==1)
                    {
                    	/**旧逻辑 ：有问题，服务器一启动就会执行
                    	 * 今天2016-03-23 16:20:00
                    	 * 指定时间在当前时间之后	睡眠到指定时间
                    	 * 指定时间在当前时间之前	修改时间为今天 如2015-03-23 16:50:00修改2016-03-23 16:50:00
                    	 * 		修改后：指定时间在当前时间之后	
                    	 * 		判断
                    	 * 					当前时间与指定时间间隔t 如果 >执行间隔 不睡眠
                    	 * 					当前时间与指定时间间隔t 如果<执行间隔  睡眠t时间
                    	 * 		修改后：指定时间在当前时间之前 不睡眠	
                    	 * 
                    	 * 新逻辑：
                    	 * 指定时间在当前时间之后	睡眠到指定时间
                    	 * 指定时间在当前时间之前	判断
                    	 * 		如果 在一个执行间隔内执行过一次，则要睡眠到下一个执行点，否则不睡眠
                    	 * 		
                    	 */
                    	//获取指定时间
                    	Date dNow = new Date();
                    	Date dSched = pTaskvo.getSchedStartDt();
                    	long between = dSched.getTime() - dNow.getTime();// 得到两者的毫秒数
                    	String sNow = DateUtil.dateToString(dNow, "yyyy-MM-dd HH:mm:ss");
                    	String schedStartDate = DateUtil.dateToString(dSched);
                    	log.info(sNow+"---"+schedStartDate+"----between:"+between);
                    	log.info(sNow+"---"+schedStartDate+"----between:"+getDateStr(between));
                    	if(between>0){
                    		log.info("----指定时间在当前时间之后	睡眠到指定时间:"+between);
                    		nextExeTimeStr = "下一次："+StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(between);
                    		//在头上写如下一次执行时间
                            pTaskvo.setCompletionText(nextExeTimeStr);
                            taskService.saveOrUpdate(pTaskvo);
                    		sleep(between);
                    	}else{
                    		int count = taskService.GetCountInOnePeriod(pTaskvo.getRowId());
                    		if(count>0){
                    			waittime++;
                    		}else{
                    			log.info("----周期内未执行，执行一次");
                    		}
                    	}
                        
                    }
                    else
                    {
                    	long t = (System.currentTimeMillis() - timeoffset) % rptInterval;
                        
                        log.info(this.getClass().getName() + "(" + rptInterval + "," + timeoffset + "): " + t0+ " + " + (System.currentTimeMillis() - t0) + " - " + t);

                        long t1 = rptInterval - t + 100;
                        log.info("sleep time:" + getTimeDescByLong(t1));
                        log.info("下一个次执行时间 time:" + StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(t1));
                        nextExeTimeStr = "下一次："+StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(t1);
                        //在头上写如下一次执行时间
                        pTaskvo.setCompletionText(nextExeTimeStr);
                        taskService.saveOrUpdate(pTaskvo);
                        
                        if (t1 > 0 )
                        {
                            sleep(t1);
                        }
                        else
                        {
                            sleep(rptInterval);
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

            log.info(this.getClass().getName()+"wake up - " + StringUtil.getDateWithFormat("HH:mm:ss"));
        }     
    }
    
    private TaskVO getSonActiveTaskVO(TaskVO pTaskVO){
    	String host_ip_thread = "";
    	try {
			String ip= InetAddress.getLocalHost().getHostAddress();
			String host= InetAddress.getLocalHost().getCanonicalHostName();
			String thread = Thread.currentThread().getName();
			host_ip_thread = host+"_"+ip+"_"+thread;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	TaskVO taskVO = new TaskVO();
    	taskVO.setCreatedBy("JohnnyHuang 黄福强");
    	taskVO.setLastUpdBy("JohnnyHuang 黄福强");
    	taskVO.setCreateDate(new Date());
    	taskVO.setLastUpdDate(new Date());
    	taskVO.setModificationNum(0L);
    	taskVO.setClassName(pTaskVO.getClassName());
		taskVO.setMethod(pTaskVO.getMethod());
		taskVO.setExecSrvrName(host_ip_thread);
    	taskVO.setSubmitDate(new Date());
    	taskVO.setSchedStartDt(new Date());
    	taskVO.setParRowId(pTaskVO.getRowId());
    	taskVO.setStatus(SysDataDictionary.THREAD_STATUS_NEW);
    	return taskVO;
    }
    
    public static String getTimeDescByLong(long dt) {
		DecimalFormat df = new DecimalFormat("0.00");
		String desc = "";
		double mytime = dt / 1000 / 60.0;
		desc = df.format(mytime) + "分";
		if (mytime > 60) {
			mytime = mytime / 60.0;
			desc = df.format(mytime) + "小时";
		}
		if (mytime > 24) {
			mytime = mytime / 24.0;
			desc = df.format(mytime) + "天";
		}
		return desc;
	}
    
    private static String getDateStr(long millis) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTimeInMillis(millis);
    	Formatter ft=new Formatter(Locale.CHINA);
    	return ft.format("%1$tY年%1$tm月%1$td日%1$tA，%1$tT %1$tp", cal).toString();
    }
    
    /** 指定唤醒周期。进程将根据指定的周期在整点被唤醒。 */
    public BaseTaskImpl(int periodSec)
    {
        this(periodSec, 0);
    }

    /** 指定唤醒周期和唤醒时间偏移。 */
    public BaseTaskImpl(int periodSec, int offsetSec)
    {
        this(periodSec, offsetSec, new StringBuffer());
    }

    public BaseTaskImpl(int rptInterval, int offsetSec, Object semaphore)
    {
//        if (rptInterval < 15)
//            rptInterval = 15;
//        if (offsetSec < 0)
//            offsetSec = 0;
//        offsetSec = offsetSec % rptInterval;
//        this.rptInterval = rptInterval * 1000L;
//        this.timeoffset = offsetSec * 1000L;
//        this.semaphore = semaphore;
    }

    /**
     * 设置唤醒周期及其相对于整点的偏移量。
     * <p>
     * 唤醒周期以秒为单位，最小有效值为 15。<br>
     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
     */
    public void setSchedule(int rptInterval, String rptUom , int offsetSec,String startDate)
    {
//        if (rptInterval < 15)
//            rptInterval = 15;
//        if (offsetSec < 0)
//            offsetSec = 0;
//        offsetSec = offsetSec % rptInterval;
//        this.rptInterval = rptInterval * 1000L;
//        this.timeoffset = offsetSec * 1000L;
//        this.schedStartDate = startDate;
        
    }
    /**
     * 设置唤醒周期及其相对于整点的偏移量。
     * <p>
     * 唤醒周期以秒为单位，最小有效值为 15。<br>
     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
     */
    public void setSchedule(Long ptid,String methodName)
    {
//        this.ptid = ptid;
//        this.method = methodName;
    }
    
    /* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#suspendSchedule()
	 */
	public void suspendSchedule()
    {
            bSchedule = false;
            interrupt();
    }

    /* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#resumeSchedule()
	 */
	public void resumeSchedule()
    {
            bSchedule = true;
            interrupt();
    }

    /* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#notifyStop()
	 */
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

//	public void doTaskWakeUp(TaskVO taskVO){}

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


	/* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#getsTaskvo()
	 */
	public TaskVO getsTaskvo() {
		return sTaskvo;
	}

	/* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#setsTaskvo(com.johnny.task.access.vo.TaskVO)
	 */
	public void setsTaskvo(TaskVO sTaskvo) {
		this.sTaskvo = sTaskvo;
	}

	/* (non-Javadoc)
	 * @see com.johnny.task.common.run.BaseTask2#getpTaskvo()
	 */
	public TaskVO getpTaskvo() {
		return pTaskvo;
	}

	public void setpTaskvo(TaskVO pTaskvo) {
		this.pTaskvo = pTaskvo;
	}
	
}
