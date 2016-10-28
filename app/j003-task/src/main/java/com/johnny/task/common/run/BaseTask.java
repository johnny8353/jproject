package com.johnny.task.common.run;

import com.johnny.task.access.vo.TaskVO;

public interface BaseTask {
	/** 通知线程挂起。 */
	public abstract void suspendSchedule();

	/** 通知线程恢复。 */
	public abstract void resumeSchedule();

	/** 通知线程终止。 */
	public abstract void notifyStop();
	/** 开始 */
	public abstract void start();

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
	public abstract void doTaskWakeUp(TaskVO taskVO);

	public abstract TaskVO getsTaskvo();

	public abstract void setsTaskvo(TaskVO sTaskvo);

	public abstract TaskVO getpTaskvo();

	public abstract void setpTaskvo(TaskVO pTaskvo);
	public abstract void setSemaphore(Object semaphore);
}
