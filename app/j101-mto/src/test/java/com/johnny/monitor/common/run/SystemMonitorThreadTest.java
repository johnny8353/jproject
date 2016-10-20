package com.johnny.monitor.common.run;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.monitor.business.service.SystemGroupService;

public class SystemMonitorThreadTest {
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before
	public void init() {
		begin2 = System.currentTimeMillis();
	}

	@After
	public void destroy() {
		end2 = System.currentTimeMillis();
		System.out.println("本次花费的时间-方法：" + (end2 - begin2));
	}

	@Test
	public void test() {
		SystemMonitorThread systemMonitorThread = (SystemMonitorThread) ctx.getBean("systemMonitorThread");
		systemMonitorThread.MonitorSystem("");
	}

}
