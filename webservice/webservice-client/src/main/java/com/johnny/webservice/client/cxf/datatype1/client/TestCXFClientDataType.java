package com.johnny.webservice.client.cxf.datatype1.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.johnny.webservice.client.cxf.datatype1.DataTypeWS;
import com.johnny.webservice.client.cxf.datatype1.GetAllStudentsMapResponse;
import com.johnny.webservice.client.cxf.datatype1.GetAllStudentsMapResponse.Result;
import com.johnny.webservice.client.cxf.datatype1.Student;

/**
 * 类 编 号：
 * 类 名 称：TestClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月5日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestCXFClientDataType {
	/*
	 * wsdl2java.bat -p com.johnny.webservice.client.cxfimpl2 -d
	 * E:\share\JAVA\010
	 * 未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice\webservice-client
	 * \src\main\java\
	 * E:\share\JAVA\010未分类-分类在笔记本汇总\johnnyp\JohnnyMaven\webservice
	 * \webservice-client
	 * \src\main\java\com\johnny\webservice\client\cxfimpl2\datatypews.wsdl
	 */
	@Test
	public void testCXFImp() {
		// 第一种实现方式：通过JaxWsProxyFactoryBean代理类来设定服务处理类和服务地址，无须额外的客户端配置。
		// 注意：此种方式比较方便，无须配置比较灵活，大部分情况下都会采用这种方式调用服务程序。
		// 运行客户端程序，调用成功并能正常反馈，说明客户端与服务端的一次交互成功！
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(DataTypeWS.class);
		factory.setAddress("http://localhost:8077/johnny/webservice/dataTypeWS?wsdl");
		DataTypeWS client = (DataTypeWS) factory.create();
		Student response = client.getStudentById(2);
		System.out.println("Response:" + response);

		Result allStudentsMap = client.getAllStudentsMap();
		for (GetAllStudentsMapResponse.Result.Entry iterable_element : allStudentsMap
				.getEntry()) {
			System.out.println(iterable_element.getKey());
			System.out.println(iterable_element.getValue());
		}
	}

}
