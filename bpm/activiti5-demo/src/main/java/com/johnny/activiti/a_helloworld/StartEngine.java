package com.johnny.activiti.a_helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：StartEngine
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月26日
 * 编码作者：JohnnyHuang 黄福强
 */
public class StartEngine {

	// 使用代码创建工作流所需的23张表
	@Test
	public void createTable() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();
		// 连接数据库的配置
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration
				.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&amp;characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("1230");
		/** 
		public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在 
		public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表 
		public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
		 */
		processEngineConfiguration
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		ProcessEngine processEngine = processEngineConfiguration
				.buildProcessEngine();
		System.out.println(processEngine);
	}

	// 使用配置文件创建工作流所需的23张表
	@Test
	public void createTable2() {
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"activiti.cfg.xml").buildProcessEngine();
		System.out.println(processEngine);
	}

	//
	public static void main(String[] args) {
		// activiti.cfg.xml配置号数据库信息，引擎启动会自动创建表
		// 默认获取 resources = classLoader.getResources("activiti.cfg.xml");
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine);
	}

}
