package com.johnny.webservice.jdkimp;

import javax.xml.ws.Endpoint;

/*
 * jax-ws 发布Web Service
 */
public class ServerTest {

	public static void main(String[] args) {
		//使用ip发布
//		String address = "http://10.17.183.31:8989/johnny/hellows";
		String address = "http://localhost:8989/johnny/hellows";
		Endpoint.publish(address , new HelloWSImpl());
		System.out.println("发布webservice成功!");
	}
}
