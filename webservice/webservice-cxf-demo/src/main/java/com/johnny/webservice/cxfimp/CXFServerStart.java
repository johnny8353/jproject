package com.johnny.webservice.cxfimp;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 类 编 号：
 * 类 名 称：ServerStart
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月5日
 * 编码作者：JohnnyHuang 黄福强	
 */
public class CXFServerStart {
	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(HelloWS.class);

		factory.setAddress("http://localhost:8998/johnny/webservice/hellows");
		factory.create();

		System.out.println("Server start...");
	}

}
