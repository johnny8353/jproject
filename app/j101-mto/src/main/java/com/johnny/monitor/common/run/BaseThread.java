///**
//  * 作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
//  */
//package com.johnny.monitor.common.run;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Formatter;
//import java.util.Locale;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.johnny.common.util.StringUtil;
///**
// * 类 编 号：
// * 类 名 称：BaseSchedulerThread.java
// * 内容摘要：作为 Scheduler Thread 的基类，提供基本的“睡眠/唤醒”支持，并通过统一的接口进行“挂起/恢复/终止”操作。 
// * 完成日期：2016-3-23
// * 编码作者：JohnnyHuang 黄福强
// */
//public abstract class BaseThread extends Thread
//{
//	protected Log log = LogFactory.getLog(getClass());
//	
//    protected Object semaphore = null;
//
//    protected volatile boolean needStop = false;
//
//    protected volatile boolean bSchedule = true;
//
//    protected volatile boolean bWakeupOnce = false;
//
//    protected long timeslice = 15 * 1000;
//
//    protected long timeoffset = 0L;
//
//    private String param = null;
//    
//    private String ptid;//父 Id
//    
//    private String tid;
//    
//    private String method;
//    
//    private String schedStartDate = "";//预计开始时间
//
//    public String getParam()
//    {
//        return this.param;
//    }
//
//    public void clearParam()
//    {
//        this.param = null;
//         
//    }
//
//    /**
//     * 获取异常详细信息
//     * @Description: TODO
//     * @param @param e
//     * @param @return   
//     * @return String  
//     * @throws
//     * @author JohnnyHuang 黄福强
//     * @date 2016-4-7
//     */
//	public String getExceptionMessage(Exception e){
//		String message = "";
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		e.printStackTrace(new PrintStream(baos));
//		message = baos.toString();
//		return message;
//	}
//    
//    // 此属性为SyncOCUThread类而增加，从HttpServlet传递配置路径至OcuUtil
//    private String configPath = "";
//
//    public BaseThread()
//    {
//    	
//        this(15, 0);
//    }
//	
//    @Override
//	public void run() 
//    {
//    	//schedStartDate 必输字段
//    	if(schedStartDate.equals("")){//普通任务
//    		CommonRun();
//    	}else{//定时任务
//    		ScheduleRun();
//    	}
//    }
//    private void CommonRun(){
//    	doWakeUp(ptid,method);
//    }
//    
//    private void ScheduleRun(){
//    	String nextExeTimeStr = "";
////    	IThreadService iThreadService  = (IThreadService) getBean("threadService");
//    	log.info(this.getClass().getName()+" entering " + getClass().getName());
//    	//新建重复线程记录，活动状态
//    	String sId = "";
//        long t0 = 0L;
//        int  i = 0;
//        int waittime = 1;//默认一次，如果执行过需要等待一次
//
//        while (!needStop) {
//            t0 = System.currentTimeMillis();
//            // 睡眠
//            try {
//                if (bSchedule) 
//                {
//                	i++;
//                    // 调度发送
//                    if ((bSchedule || bWakeupOnce) && (i>waittime) )  
//                    {
//                        synchronized (semaphore) 
//                        {
//                            interrupted();
//                        	sId = iThreadService.InitRpdSThread(ptid,"");
//                            doWakeUp(sId,method);
//                        }
//                    }
//                    bWakeupOnce = false;
//                    
//                    if (i ==1)
//                    {
//                    	/**旧逻辑 ：有问题，服务器一启动就会执行
//                    	 * 今天2016-03-23 16:20:00
//                    	 * 指定时间在当前时间之后	睡眠到指定时间
//                    	 * 指定时间在当前时间之前	修改时间为今天 如2015-03-23 16:50:00修改2016-03-23 16:50:00
//                    	 * 		修改后：指定时间在当前时间之后	
//                    	 * 		判断
//                    	 * 					当前时间与指定时间间隔t 如果 >执行间隔 不睡眠
//                    	 * 					当前时间与指定时间间隔t 如果<执行间隔  睡眠t时间
//                    	 * 		修改后：指定时间在当前时间之前 不睡眠	
//                    	 * 
//                    	 * 新逻辑：
//                    	 * 指定时间在当前时间之后	睡眠到指定时间
//                    	 * 指定时间在当前时间之前	判断
//                    	 * 		如果 在一个执行间隔内执行过一次，则要睡眠到下一个执行点，否则不睡眠
//                    	 * 		
//                    	 */
//                    	//获取指定时间
//                    	Date dNow = new Date();
//                    	Date dSched = stringToDate(schedStartDate,"yyyy-MM-dd HH:mm:ss");
//                    	long between = dSched.getTime() - dNow.getTime();// 得到两者的毫秒数
//                    	String sNow = dateToString(dNow, "yyyy-MM-dd HH:mm:ss");
//                    	log.info(sNow+"---"+schedStartDate+"----between:"+between);
//                    	log.info(sNow+"---"+schedStartDate+"----between:"+getDateStr(between));
//                    	if(between>0){
//                    		log.info("----指定时间在当前时间之后	睡眠到指定时间:"+between);
//                    		nextExeTimeStr = "下一次："+StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(between);
//                    		  //在头上写如下一次执行时间
//                            if(!nextExeTimeStr.equals("")){
//                            	iThreadService.ModifyThread(ptid,"",nextExeTimeStr,false,false);
//                            }
//                    		sleep(between);
//                    	}else{
//                    		int count = iThreadService.GetCountInOnePeriod(ptid);
//                    		if(count>0){
//                    			waittime++;
//                    		}else{
//                    			log.info("----周期内未执行，执行一次");
//                    		}
//                    	}
//                    }
//                    else
//                    {
//                        long t = (System.currentTimeMillis() - timeoffset) % timeslice;
//    
//                        log.debug(this.getClass().getName() + "(" + timeslice + "," + timeoffset + "): " + t0+ " + " + (System.currentTimeMillis() - t0) + " - " + t);
//
//                        long t1 = timeslice - t + 100;
//                        log.debug("sleep time:" + getTimeDescByLong(t1));
//                        log.debug("下一个次执行时间 time:" + StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(t1));
//                        nextExeTimeStr = "下一次："+StringUtil.getDateWithFormat("yyyy-MM-dd HH:mm:ss")+"+"+getTimeDescByLong(t1);
//                        //在头上写如下一次执行时间
//                        if(!nextExeTimeStr.equals("")){
//                        	iThreadService.ModifyThread(ptid,"",nextExeTimeStr,false,false);
//                        }
//                        if (t1 > 0 )
//                        {
//                            sleep(t1);
//                        }
//                        else
//                        {
//                            sleep(timeslice);
//                        }
//                    }
//                } 
//                else
//                {
//                    // 睡眠 forever
//                    sleep( 0xffffffffL );
//                }
//
//            }
//            catch (InterruptedException e)
//            {
//                Thread.currentThread().interrupt();
//            }
//            catch (Exception ex)
//            {
//            	ex.printStackTrace();
//                log.error(ex);
//            }
//
//            log.debug(this.getClass().getName()+"wake up - " + StringUtil.getDateWithFormat("HH:mm:ss"));
//        }     
//    }
//    
//    public static String getTimeDescByLong(long dt){
//    	 DecimalFormat df = new DecimalFormat("0.00");
//    	String desc = "";
//    	double mytime = dt/1000/60.0;
//    	desc = df.format(mytime) +"分";
//    	if(mytime>60){
//    		mytime = mytime/60.0;
//    		desc = df.format(mytime) +"小时";
//    	}
//    	if(mytime>24){
//    		mytime = mytime/24.0;
//    		desc = df.format(mytime) +"天";
//    	}
//    	return desc;
//    }
//    private static String getDateStr(long millis) {
//    	Calendar cal = Calendar.getInstance();
//    	cal.setTimeInMillis(millis);
//    	Formatter ft=new Formatter(Locale.CHINA);
//    	return ft.format("%1$tY年%1$tm月%1$td日%1$tA，%1$tT %1$tp", cal).toString();
//    }
//    
//    /** 指定唤醒周期。进程将根据指定的周期在整点被唤醒。 */
//    public BaseThread(int periodSec)
//    {
//        this(periodSec, 0);
//    }
//
//    /** 指定唤醒周期和唤醒时间偏移。 */
//    public BaseThread(int periodSec, int offsetSec)
//    {
//        this(periodSec, offsetSec, new StringBuffer());
//    }
//
//    public BaseThread(int periodSec, int offsetSec, Object semaphore)
//    {
//        if (periodSec < 15)
//            periodSec = 15;
//        if (offsetSec < 0)
//            offsetSec = 0;
//        offsetSec = offsetSec % periodSec;
//        this.timeslice = periodSec * 1000L;
//        this.timeoffset = offsetSec * 1000L;
//        this.semaphore = semaphore;
//    }
//
//    /**
//     * 设置唤醒周期及其相对于整点的偏移量。
//     * <p>
//     * 唤醒周期以秒为单位，最小有效值为 15。<br>
//     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
//     */
//    public void setSchedule(int periodSec, int offsetSec,String startDate)
//    {
//        if (periodSec < 15)
//            periodSec = 15;
//        if (offsetSec < 0)
//            offsetSec = 0;
//        offsetSec = offsetSec % periodSec;
//        this.timeslice = periodSec * 1000L;
//        this.timeoffset = offsetSec * 1000L;
//        this.schedStartDate = startDate;
//        
//    }
//
//    /**
//     * 设置唤醒周期及其相对于整点的偏移量。
//     * <p>
//     * 唤醒周期以秒为单位，最小有效值为 15。<br>
//     * 偏移量以秒为单位，最小有效值为0，最大有效值为唤醒周期。
//     */
//    public void setSchedule(String ptid,String methodName)
//    {
//        this.ptid = ptid;
//        this.method = methodName;
//    }
//    
//    /** 通知线程挂起。 */
//    public void suspendSchedule()
//    {
//            bSchedule = false;
//            interrupt();
//    }
//
//    /** 通知线程恢复。 */
//    public void resumeSchedule()
//    {
//            bSchedule = true;
//            interrupt();
//    }
//
//    /** 通知线程终止。 */
//    public void notifyStop()
//    {
//            needStop = true;
//            interrupt();
//    }
//
//    /** 通知线程唤醒一次，不影响原来的“挂起/恢复”状态。 */
//    public void notifyWakeup()
//    {
//            bWakeupOnce = true;
//            interrupt();
//    }
//
//    /** 用给定的参数，通知线程唤醒一次，不影响原来的“挂起/恢复”状态。 */
//    public void notifyWakeup(String param)
//    {
//            bWakeupOnce = true;
//            this.param = param;
//            interrupt();
//    }
//
//
//    /**
//     * 
//     * @Description: 需在扩展类中定义的实际业务操作，每次线程被唤醒后将调用一次该方法。
//     * @param @param tid
//     * @param @param method   方法
//     * @return void  
//     * @throws
//     * @author JohnnyHuang 黄福强
//     * @date 2016-3-23
//     */
//    abstract protected void doWakeUp(String tid,String method);
//
//    /**
//     * Gets the realPath
//     * 
//     * @return Returns a String
//     */
//    public String getConfigPath()
//    {
//        return configPath;
//    }
//
//    /**
//     * Sets the realPath
//     * 
//     * @param realPath
//     *            The realPath to set
//     */
//    public void setConfigPath(String configPath)
//    {
//        this.configPath = configPath;
//    }
//
//    /**
//     * 获取bean实例
//     * 业务描述：XXX 
//     * 作          者：JohnnyHuang 黄福强
//     * 完成日期：2015-7-24
//     * @param beanId
//     * @return
//     */
//    protected Object getBean(String beanId)
//    {
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
//		return wac.getBean(beanId);
//    }
//
//	public String getPtid() {
//		return ptid;
//	}
//
//	public void setPtid(String ptid) {
//		this.ptid = ptid;
//	}
//
//	public String getTid() {
//		return tid;
//	}
//
//	public void setTid(String tid) {
//		this.tid = tid;
//	}
//
//	public String getSchedStartDate() {
//		return schedStartDate;
//	}
//
//	public void setSchedStartDate(String schedStartDate) {
//		this.schedStartDate = schedStartDate;
//	}
//
//	public String dateToString(Date date, String pattern) {
//		if (date == null) {
//			return null;
//		}
//		try {
//			return new SimpleDateFormat(pattern).format(date);
//		} catch (Exception e) {
//		}
//		return null;
//	}
//    
//	public static Date stringToDate(String dateString, String dateFormat) {
//		if (("".equals(dateString)) || (dateString == null)) {
//			return null;
//		}
//		try {
//			return new SimpleDateFormat(dateFormat).parse(dateString);
//		} catch (Exception e) {
//		}
//		return null;
//	}
//
//	public String getMethod() {
//		return method;
//	}
//
//	public void setMethod(String method) {
//		this.method = method;
//	}
//	
//	
//}
