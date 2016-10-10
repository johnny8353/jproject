package com.johnny.webservice.cxfimp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类 编 号：
 * 类 名 称：TestClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月6日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestClient {
	public static void main(String[] args) {
		//spring test
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cxf-service.xml");
		
		HelloWS bean = (HelloWS) ctx.getBean("helloWS");
		
		System.out.println(bean);
		
		String sayHello = bean.sayHello("hh");
		System.out.println(sayHello);
		
	}


}
