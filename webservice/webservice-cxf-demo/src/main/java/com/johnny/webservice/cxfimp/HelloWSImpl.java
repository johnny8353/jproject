package com.johnny.webservice.cxfimp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/*
 * SEI的实现
 */
@WebService
public class HelloWSImpl implements HelloWS {

		//通过WebMethod 等参数 指定wsdl文件对应的名称，不指定的话会有一些不想要的名称出现
		@WebMethod(operationName = "doHello")
		@WebResult(name = "jResult")
		public String sayHello(@WebParam(name="jName") String name) {
			System.out.println("server sayHello()"+name);
			return "Hello CXF！ " +name;
		}

}
