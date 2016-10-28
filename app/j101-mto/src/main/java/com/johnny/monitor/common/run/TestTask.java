package com.johnny.monitor.common.run;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.johnny.common.util.DateUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.run.BaseTask;
import com.johnny.task.common.run.BaseTaskImpl;
@Component("testTask")
@Scope(value="prototype")
public class TestTask extends BaseTaskImpl implements BaseTask{
	private Log log = LogFactory.getLog(getClass());
	private static int i = 0;
	
	public TestTask(){
		log.info("TestTask construct....");
	}
	
	public void doTaskWakeUp(TaskVO taskvo) {
//		System.out.println(taskvo.getClassName()+taskvo.getActlStartDt());
		log.info("TestTask执行_"+(i++)+"__"+DateUtil.getNowDateTimeMMM());
	}

}
