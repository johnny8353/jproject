package com.johnny.spring.beans.autowire;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	static ClassPathXmlApplicationContext ctx ;
	@BeforeClass
	public static void beforeClass(){
		ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
		
	}
	@Test
	public void Test1(){
		Action action = ctx.getBean(Action.class);
		action.execute();
	}
	
}
