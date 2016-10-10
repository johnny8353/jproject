package com.johnny.spring.beans.collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.spring.beans.helloworld.DataSource;
import com.johnny.spring.beans.helloworld.PersonList;
import com.johnny.spring.beans.helloworld.PersonMap;

public class Main {
	static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		// 1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ctx = new ClassPathXmlApplicationContext("beans-collection.xml");
	}

	// List
	@Test
	public void test4() {
		PersonList user = (PersonList) ctx.getBean("personList");
		System.out.println(user);
		PersonList personList2 = (PersonList) ctx.getBean("personList2");
		System.out.println(personList2);
	}

	// Map
	@Test
	public void test5() {
		PersonMap personMap = (PersonMap) ctx.getBean("personMap");
		System.out.println(personMap);
	}

	// Properties
	@Test
	public void test6() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getProperties());
	}
}
