package com.johnny.spring.beans.helloworld;

public class HelloWorld {

	private String user;
	
	//通过 反射注入需要有一个public的无参构造器
	public HelloWorld() {
		System.out.println("HelloWorld's constructor...");
	}
	
	public void setUser(String user) {
		System.out.println("setUser:" + user);
		this.user = user;
	}
	
	public HelloWorld(String user) {
		this.user = user;
	}

	public void hello(){
		System.out.println("Hello: " + user);
	}
	
}
