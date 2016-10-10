package com.johnny.webservice.client.axis2.helloworld2.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.junit.Test;

import com.johnny.webservice.client.axis2.helloworld2.MyHelloWSStub;

/**
 * 类 编 号：
 * 类 名 称：TestAxis2Client
 * 内容摘要：测试 使用axis2 wsdl2java 生成的客户端代码，服务端为axis2 war
 * 使用axis2 wsdl2java 命令生成客户端代码
 * 生成的包名是服务器端工程的包名，目前有很多错误，需要手动修改，较为麻烦
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestAxis2Client {

	@Test
	public void Test() throws RemoteException{
		MyHelloWSStub helloWSStub = new MyHelloWSStub();
		MyHelloWSStub.SayHello hello = new MyHelloWSStub.SayHello();
		hello.setArgs0("johnny");
		
		MyHelloWSStub.SayHelloResponse helloResponse =  helloWSStub.sayHello(hello);
		
		System.out.println(helloResponse.get_return());
		
	}
	/*
	 * 测试 修改接口地址
	 */
	@Test
	public void Test2() throws RemoteException{
		MyHelloWSStub helloWSStub = new MyHelloWSStub("http://localhost:8082/axis2/services/MyHelloWS");
		MyHelloWSStub.SayHello hello = new MyHelloWSStub.SayHello();
		hello.setArgs0("johnny2");
		
		MyHelloWSStub.SayHelloResponse helloResponse =  helloWSStub.sayHello(hello);
		
		System.out.println(helloResponse.get_return());
		
	}
	
	
	/**
	 * 业务描述：测试集成的  接口	
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016年9月18日
	 * @param @throws RemoteException
	 * @return void
	 * @throws RemoteException 
	 */
	@Test
	public void Test3() throws RemoteException{
		
		MyHelloWSStub helloWSStub = new MyHelloWSStub("http://localhost:8077/johnny/services/HelloWorld");
		MyHelloWSStub.SayHello hello = new MyHelloWSStub.SayHello();
		hello.setArgs0("johnny21");
		
		MyHelloWSStub.SayHelloResponse helloResponse =  helloWSStub.sayHello(hello);
		
		System.out.println(helloResponse.get_return());
		
	}
	
}
