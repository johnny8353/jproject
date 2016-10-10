package com.johnny.webservice.client.cxfimpl.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.johnny.webservice.client.cxfimpl.HelloWS;
import com.johnny.webservice.client.cxfimpl.HelloWSImplService;

/**
 * 类 编 号：
 * 类 名 称：TestClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月5日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestCXFClient {
	/*
	 D:\apache-cxf-2.7.6\bin>wsdl2java.bat -p
	 com.johnny.webservice.client.cxfimpl -d
	 E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client\src\main\java\
	 E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client\src\main\java\com\johnny\webservice\client\cxfimpl\hellows.wsdl
	*/
	@Test
	public void testCXFImp() {
		// 第一种实现方式：通过JaxWsProxyFactoryBean代理类来设定服务处理类和服务地址，无须额外的客户端配置。
		//注意：此种方式比较方便，无须配置比较灵活，大部分情况下都会采用这种方式调用服务程序。
		//运行客户端程序，调用成功并能正常反馈，说明客户端与服务端的一次交互成功！
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWS.class);
		factory.setAddress("http://localhost:8077/cxf/webservice/hellows?wsdl");
		HelloWS client = (HelloWS) factory.create();
		String response = client.doHello("johnny");
		System.out.println("Response:" + response);
		
	}
	
	//第二种实现方式：通过配置客户端来调用服务，方式比较麻烦需要额外对客户端进行配置，这里只需要了解下即可。
}
