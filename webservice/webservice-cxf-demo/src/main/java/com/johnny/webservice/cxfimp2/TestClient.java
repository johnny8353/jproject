package com.johnny.webservice.cxfimp2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {

	/**
	 * 类 编 号：
	 * 类 名 称：TestClient
	 * 内容摘要：<说明该类的目前已经实现的主要功能>
	 * 完成日期：2016年9月6日
	 * 编码作者：JohnnyHuang 黄福强
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cxf-service.xml");
		
		DataTypeWS bean = (DataTypeWS) ctx.getBean("dataTypeWS");
		
		System.out.println(bean.getStudentById(2));
		
	}

}
