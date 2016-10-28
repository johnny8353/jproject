package com.johnny.data.business.service;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.data.access.vo.SystemPreferenceVO;
import com.johnny.data.common.data.SysDataDictionary;

public class SystemPreferenceServiceImplTest {

	private ApplicationContext ctx = null;
	long begin2 = 1L;
	long end2 = 1L;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	SystemPreferenceService systemPreferenceService = null;
	@Before
	public void setUp() throws Exception {
		begin2 = System.currentTimeMillis();
		systemPreferenceService = (SystemPreferenceService) ctx.getBean("systemPreferenceServiceImpl");
	}

	@After
	public void tearDown() throws Exception {
		end2 = System.currentTimeMillis();
		System.out.println("本次花费的时间-方法："+(end2-begin2));
	}


	@Test
	public void testSaveObject() {
		SystemPreferenceVO entity = new SystemPreferenceVO();
		entity.setName("JT_SERVER_REQ_URL");
		entity.setVal("http://localhost:8077/johnny");
		entity.setComments("系统请求地址");
		entity.setType(SysDataDictionary.SYS_PREF_TYPE_SERINIT);
		systemPreferenceService.save(entity);
	}
	@Test
	public void testSaveObject1() {
		SystemPreferenceVO entity = new SystemPreferenceVO();
		entity.setName("JT_SERVER_REQ_URL2");
		entity.setVal("http://10.5.6.119:8080/j101-mto");
		entity.setComments("系统请求地址");
		entity.setType(SysDataDictionary.SYS_PREF_TYPE_SERINIT);
		systemPreferenceService.save(entity);
	}
	@Test
	public void testSaveObject2() {
		SystemPreferenceVO entity = new SystemPreferenceVO();
		entity.setName("JT_FILE_PATH");
		entity.setVal("D:/apache-tomcat-mto/webapps/mtofs");
		entity.setComments("附件存储地址");
		entity.setType(SysDataDictionary.SYS_PREF_TYPE_SERINIT);
		systemPreferenceService.save(entity);
	}
	@Test
	public void testSaveObject3() {
		SystemPreferenceVO entity = new SystemPreferenceVO();
		entity.setName("JT_FILE_URL");
		entity.setVal("http://localhost:8096/mtofs");
		entity.setComments("附件请求地址");
		entity.setType(SysDataDictionary.SYS_PREF_TYPE_SERINIT);
		systemPreferenceService.save(entity);
	}

	@Test
	public void testUpdateObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCharSequenceMapOfStringObject() {
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "SERVER_URL2");
		SystemPreferenceVO entity =  systemPreferenceService.get(params );
		System.out.println(entity.getVal());
	}

	@Test
	public void testFindListCharSequenceMapOfStringObject() {
		Map<String,Object> params = new HashMap<String, Object>();
		List<SystemPreferenceVO> list = systemPreferenceService.findList(params);
		System.out.println(list);
	}

}
