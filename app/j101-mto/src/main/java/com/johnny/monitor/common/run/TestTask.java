package com.johnny.monitor.common.run;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.DateUtil;
import com.johnny.task.common.run.BaseTask;

public class TestTask extends BaseTask{
	private Log log = LogFactory.getLog(getClass());
	private static int i = 0;
	@Override
	protected void doWakeUp(Long rowId, String method) {
		log.error("执行"+(i++)+DateUtil.getNowDateTimeMMM());
	}
	
	

}
