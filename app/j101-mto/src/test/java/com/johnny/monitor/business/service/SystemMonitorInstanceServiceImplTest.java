package com.johnny.monitor.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.monitor.access.vo.SystemMonitorInstanceVO;

public class SystemMonitorInstanceServiceImplTest {
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	SystemMonitorInstanceService instanceService = null;

	@Before
	public void init() {
		instanceService = (SystemMonitorInstanceService) ctx
				.getBean("systemMonitorInstanceServiceImpl");
		begin2 = System.currentTimeMillis();
	}

	@After
	public void destroy() {
		end2 = System.currentTimeMillis();
		System.out.println("本次花费的时间-方法：" + (end2 - begin2));
	}

	@Test
	public void test() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("batchNum", "20161027170000222");
		List<SystemMonitorInstanceVO> list = instanceService
				.findErrorInsList(params);
		System.out.println(list);
	}
	
	@Test
	public void testfindErrorCountGroupByType() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("batchNum", "20161027170000222");
		params.put("sysCode", "MSM");
		instanceService.findErrorCountGroupByType(params);
	}

}
