package com.johnny.monitor.business.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.basic.TestCaseBase;
import com.johnny.basic.TestCaseSeq;
import com.johnny.common.access.dao.Pagination;
import com.johnny.monitor.access.vo.SystemGroupVO;
import com.johnny.monitor.model.SystemListBO;

public class SystemGroupServiceImplTest extends TestCaseBase{
	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	SystemGroupService groupServiceImpl = null;

	@Before
	public void init() {
		groupServiceImpl = (SystemGroupService) ctx
				.getBean("systemGroupServiceImpl");
		begin2 = System.currentTimeMillis();
	}

	@After
	public void destroy() {
		end2 = System.currentTimeMillis();
		System.out.println("本次花费的时间-方法："+(end2-begin2));
	}

	@Test
	public void testDelete() {
		groupServiceImpl.delete(9L);
		// System.out.println(groupServiceImpl.get(SystemGroupVO.class,9L).getSysCode());
	}

	@Test
	public void testDeleteEntity() {
		SystemGroupVO group = groupServiceImpl.get(SystemGroupVO.class, 10L);
		groupServiceImpl.delete(group);
		System.out.println(group);
	}

	@Test
	public void testSaveOrUpdateSystemGroupVO() {
		SystemGroupVO groupVO = new SystemGroupVO();
		groupVO.setSysCode("HHHHH");
		groupVO.setSysName("Siebel应用");
		groupServiceImpl.saveOrUpdate(groupVO);
		System.out.println(groupVO.getRowId());
	}

	@Test
	public void testGetLong() {
		Serializable id = 9L;
		System.out.println(groupServiceImpl.get(SystemGroupVO.class, id)
				.getSysCode());
	}

	@Test
	public void testQuery1() {
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("sysType", "DataBase");
		List<SystemGroupVO> groups = groupServiceImpl.findList(
				"from SystemGroupVO where sysType=:sysType", params);
		System.out.println(Arrays.asList(groups));
	}

	@Test
	public void testQueryPage() {
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("sysType", "DataBase");
		String queryString = "from SystemGroupVO where sysType=:sysType";
		Pagination<SystemGroupVO> groups = groupServiceImpl.findPagination(
				queryString, params, 2, 2);
		System.out.println(Arrays.asList(groups.getItems()));
		System.out.println(groups.getPagesCount());
		System.out.println(groups.getRowsCount());

	}

	@Test
	public void testFindSystemListBO(){
		SystemListBO systemListBO = new SystemListBO();
		systemListBO = groupServiceImpl.findSystemListBO();
		System.out.println(systemListBO);
		
	}
}
