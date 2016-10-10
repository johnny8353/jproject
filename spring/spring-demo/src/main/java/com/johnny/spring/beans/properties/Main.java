package com.johnny.spring.beans.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		// 1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
	}

	@Test
	public void test6() {
		//测试使用外部属性文件 引入c3p0-0.9.1.2.jar和 数据库 驱动包mysql-connector-java-5.1.7-bin.jar
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
