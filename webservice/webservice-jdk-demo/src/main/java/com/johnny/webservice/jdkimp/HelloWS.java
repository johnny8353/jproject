package com.johnny.webservice.jdkimp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/*
 * SEI: 
 */
@WebService
public interface HelloWS {

	
	@WebMethod(operationName = "doHello")
	@WebResult(name = "jResult")
	public String sayHello(@WebParam(name = "jName")String name);
}
