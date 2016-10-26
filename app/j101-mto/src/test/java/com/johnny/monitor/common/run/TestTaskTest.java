package com.johnny.monitor.common.run;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.common.run.BaseTask;

public class TestTaskTest {
	private ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoTaskWakeUp() {
		BaseTask baseTask = (BaseTask) ctx.getBean("testTask");
		TaskVO taskVO= new TaskVO();
		taskVO.setClassName("aa");
		baseTask.doTaskWakeUp(taskVO);
	}

}
