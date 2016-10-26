package com.johnny.monitor.common.run;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SystemMonitorThreadTest {
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
//		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
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
		SystemMonitorTask systemMonitorThread = new SystemMonitorTask();
		systemMonitorThread.monitorSystem("");
	}
	@Test
	public void testEmailNotify() {
		SystemMonitorTask systemMonitorThread = new SystemMonitorTask();
		systemMonitorThread.emailNotify("20161026123058604");
	}

	@Test
	public void testGenerateReport() throws IOException{
		SystemMonitorTask systemMonitorThread = new SystemMonitorTask();
		systemMonitorThread.generateReport("20161026123058604");
	}
	
	@Test
	public void testDir(){
		System.out.println(System.getProperty("user.dir"));
		System.out.println(this.getClass().getResource("").getPath());
		System.out.println(this.getClass().getResource("/").getPath());
	}
	
}
