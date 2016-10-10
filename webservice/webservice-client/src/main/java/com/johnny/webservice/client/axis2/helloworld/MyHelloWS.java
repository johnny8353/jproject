
/**
 * MyHelloWS.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.7.2
 * Built on : May 02, 2016 (05:55:18 BST)
 */

package com.johnny.webservice.client.axis2.helloworld;

/*
 * MyHelloWS java interface
 */

public interface MyHelloWS {

	/**
	  * Auto generated method signature
	  * 
	            * @param sayHello0
	        
	 */

	public com.johnny.webservice.client.axis2.helloworld.SayHelloResponse sayHello(

	com.johnny.webservice.client.axis2.helloworld.SayHello sayHello0)
			throws java.rmi.RemoteException;

	/**
	   * Auto generated method signature for Asynchronous Invocations
	   * 
	       * @param sayHello0
	   
	 */
	public void startsayHello(

			com.johnny.webservice.client.axis2.helloworld.SayHello sayHello0,

			final com.johnny.webservice.client.axis2.helloworld.MyHelloWSCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
