package com.johnny.spring.beans.scope;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.spring.beans.helloworld.Car;

public class Main {
	static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		// 1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
	}

	@Test
	public void test6() {
		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		System.out.println(car==car2);
	}
}
