package com.johnny.task.business.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.common.util.DateUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.business.service.TaskService;
import com.johnny.task.common.data.SysDataDictionary;
// 
public class TaskServiceImplTest {
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	TaskService taskService = null;
	@Before
	public void setUp() throws Exception {
		begin2 = System.currentTimeMillis();
		taskService = (TaskService) ctx.getBean("taskServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		end2 = System.currentTimeMillis();
		System.out.println("本次花费的时间-方法："+(end2-begin2));
	}

	@Test
	public void testSaveObject() {
		TaskVO taskVO = new TaskVO();
//		taskVO.setClassName("com.johnny.monitor.common.run.TestTask");
		taskVO.setClassName("testTask");
		taskVO.setRptFlag("Y");
		taskVO.setRptUom("S");
		taskVO.setRptInterval("300");
		taskVO.setStatus(SysDataDictionary.THREAD_STATUS_ACTIVE);
		taskVO.setDescText("测试任务------");
		taskVO.setSchedStartDt(DateUtil.stringToDate("2016-10-25 10:10:10"));
		taskVO.setLastUpdDate(new Date());
		taskVO.setCreateDate(new Date());
		taskService.saveEntity(taskVO);
	}
	
	@Test
	public void testSaveMTOObject() {
		TaskVO taskVO = new TaskVO();
//		taskVO.setClassName("com.johnny.monitor.common.run.TestTask");
		taskVO.setClassName("systemMonitorTask");
		taskVO.setRptFlag("Y");
		taskVO.setRptUom("S");
		taskVO.setRptInterval("600");
		taskVO.setStatus(SysDataDictionary.THREAD_STATUS_ACTIVE);
		taskVO.setDescText("服务器监控定时任务------");
		taskVO.setSchedStartDt(DateUtil.stringToDate("2016-10-25 10:10:10"));
		taskVO.setLastUpdDate(new Date());
		taskVO.setCreateDate(new Date());
		taskService.saveEntity(taskVO);
	}
	
	@Test
	public void getStartupRpdTask(){
		List<TaskVO> tasks = new ArrayList<>();
		tasks = taskService.getStartupRpdTask();
		System.out.println(tasks);
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharSequenceMapOfStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindListCharSequenceMapOfStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPaginationCharSequenceMapOfStringObjectIntInt() {
		fail("Not yet implemented");
	}

}
