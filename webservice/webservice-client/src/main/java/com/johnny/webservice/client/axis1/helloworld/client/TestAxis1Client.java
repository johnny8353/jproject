package com.johnny.webservice.client.axis1.helloworld.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

import com.johnny.webservice.client.axis1.helloworld.HelloWSImpl;
import com.johnny.webservice.client.axis1.helloworld.HelloWSImplService;
import com.johnny.webservice.client.axis1.helloworld.HelloWSImplServiceLocator;

/**
 * 类 编 号：
 * 类 名 称：TestAxis2Client
 * 内容摘要：测试使用Eclipse Web Service Client生成客户端代码 ，服务端为jetty 
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAxis1Client {
	private String namespaceUri = "http://localhost:8077/johnny/services/HelloWS1";
	private String wsdlUrl = namespaceUri + "?wsdl";

	@Test
	public void TestHelloWorld2() throws RemoteException, ServiceException,
			MalformedURLException {
		// 创建调用对象
		Service service = new Service();
		Call call = (Call) service.createCall();
		// 调用 远程方法
		call.setOperationName(new QName(namespaceUri, "sayHello"));
		// 设置URL
		call.setTargetEndpointAddress(new URL(wsdlUrl));
		// 执行远程调用，同时获得返回值
		String result = (String) call.invoke(new Object[] { "johnny" });
		System.out.println(result);
	}
	
	@Test
	public void TestStub() throws ServiceException, RemoteException{
		HelloWSImplServiceLocator locator = new HelloWSImplServiceLocator();
		HelloWSImpl helloWSImpl = locator.getHelloWS1();
		String address = "http://localhost:8077/johnny/services/HelloWS1";
		locator.setEndpointAddress("HelloWS1", address);
		String result = helloWSImpl.sayHello("jjj");
		String result2 = helloWSImpl.saySorry("ddd");
		System.out.println(result);
		System.out.println(result2);
	}
	
	

}
