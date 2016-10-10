package com.johnny.webservice.client.axis2.helloworld3.client;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

import com.johnny.webservice.client.axis2.helloworld3.HelloWS1Locator;
import com.johnny.webservice.client.axis2.helloworld3.HelloWS1PortType;
import com.johnny.webservice.client.axis2.helloworld3.HelloWS1Soap11BindingStub;



/**
 * 类 编 号：
 * 类 名 称：TestAxis2Client
 * 内容摘要：测试使用Eclipse Web Service Client生成客户端代码 ，服务端为jetty 
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAxis2Client {
	private String namespaceUri = "http://localhost:8077/johnny/services/HelloWS1";
	private String wsdlUrl = namespaceUri + "?wsdl";

	@Test
	public void Test() throws RemoteException, ServiceException {
		HelloWS1Locator locator = new HelloWS1Locator();
		HelloWS1PortType helloWorld = locator.getHelloWS1HttpSoap11Endpoint();
		locator.setEndpointAddress("HelloWS1HttpSoap11Endpoint", namespaceUri);
		String result = helloWorld.sayHello("johnny");
		String result2 = helloWorld.getWorld();
		
		System.out.println(result);
		System.out.println(result2);
	}
	
	@Test
	public void Test2() throws ServiceException, IOException {
		HelloWS1Locator locator = new HelloWS1Locator();
		HelloWS1PortType helloWorld = locator.getHelloWS1HttpSoap11Endpoint();
		locator.setEndpointAddress("HelloWS1HttpSoap11Endpoint", namespaceUri);
		String result = helloWorld.sayHello("johnny");
		String result2 = helloWorld.getWorld();
		
		
		System.out.println(result);
		System.out.println(result2);
		System.in.read();
	}
}
