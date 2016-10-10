package com.johnny.webservice.client.axis2.helloworld.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.junit.Test;

import com.johnny.webservice.client.axis2.helloworld.MyHelloWS;
import com.johnny.webservice.client.axis2.helloworld.MyHelloWSStub;
import com.johnny.webservice.client.axis2.helloworld.SayHello;
import com.johnny.webservice.client.axis2.helloworld.SayHelloResponse;

/**
 * 类 编 号：
 * 类 名 称：TestAxis2Client
 * 内容摘要：测试使用Axis2 Code Generator生成客户端代码 ，服务端为axis2 war
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAxis2Client {

	@Test
	public void TestHelloWorld() throws RemoteException{
		MyHelloWS helloWS = new MyHelloWSStub();
		SayHello sayHello0 = new SayHello();
		sayHello0.setArgs0("--fff");
		SayHelloResponse helloResponse = helloWS.sayHello(sayHello0);
		System.out.println(helloResponse.get_return());
	}
	
	@Test
	public void TestHelloWorld2() throws RemoteException{
		MyHelloWS helloWS = new MyHelloWSStub("http://localhost:8082/axis2/services/MyHelloWS");
		SayHello sayHello0 = new SayHello();
		sayHello0.setArgs0("--fff2");
		SayHelloResponse helloResponse = helloWS.sayHello(sayHello0);
		System.out.println(helloResponse.get_return());
	}
	
}
