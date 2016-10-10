package com.johnny.webservice.cxfimp;

import javax.xml.ws.Endpoint;

/*
 * 使用EndPoint 发布Web Service
 */
public class EndPointServerStart {
	
	//http://localhost:8081/webservice-cxf-demo/services
	public static void main(String[] args) {
		// 使用ip发布
		String address = "http://localhost:8998/johnny/hellows";
		Endpoint.publish(address, new HelloWSImpl());
		System.out.println("发布webservice成功!");
	}
}
