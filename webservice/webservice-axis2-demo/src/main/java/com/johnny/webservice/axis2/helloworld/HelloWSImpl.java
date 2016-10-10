package com.johnny.webservice.axis2.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/*
 * SEI的实现
 */
@WebService
public class HelloWSImpl implements HelloWS {

	// 通过WebMethod 等参数 指定wsdl文件对应的名称，不指定的话会有一些不想要的名称出现    
	@WebMethod(operationName = "doHello")
	@WebResult(name = "jResult")
	public String sayHello(@WebParam(name = "jName") String name) {
		System.out.println("server sayHello2()" + name);
		return "Hello AXIS2--！ " + name;
	}

	public String saySorry(String name) {
		return "Hello, Sorry AXIS2！" + name + ".";
	}

	public String getWorld() {
		return "Hello, AXIS2 world!";
	}
}
