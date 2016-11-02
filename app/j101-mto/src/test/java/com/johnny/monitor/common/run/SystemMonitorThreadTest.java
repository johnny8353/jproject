package com.johnny.monitor.common.run;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.common.observer.CacheSubject;
import com.johnny.common.util.CommonUtil;
import com.johnny.data.common.observer.SysPrefCacheObserver;
import com.johnny.monitor.common.util.ZMailUtil;

public class SystemMonitorThreadTest {
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysPrefCacheObserver observer = (SysPrefCacheObserver) CommonUtil.getBean("sysPrefCacheObserver");
		CacheSubject.CACHE_SUBJECT.addObserver(observer);
		CacheSubject.CACHE_SUBJECT.change();
		CacheSubject.CACHE_SUBJECT.notifyObservers(observer);
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
		SystemMonitorTask systemMonitorThread = (SystemMonitorTask) ctx.getBean("systemMonitorTask");//new SystemMonitorTask();
//		systemMonitorThread.emailNotify("20161027170000222");
	}

	@Test
	public void testGenerateReport() throws IOException, SQLException{
		SystemMonitorTask systemMonitorThread = new SystemMonitorTask();
		systemMonitorThread.generateReport("20161026123058604");
	}
	
	@Test
	public void testMail(){
	}
	
}
