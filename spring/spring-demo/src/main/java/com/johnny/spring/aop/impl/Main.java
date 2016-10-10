package com.johnny.spring.aop.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	@Test
	public void testaop() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
//		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);
		
		//配置了面向切换，返回的是一个代理类，继承自ArithmeticCalculator，所以通过ArithmeticCalculatorImpl.class获取不到，会报错
//		ArithmeticCalculator arithmeticCalculator2 = (ArithmeticCalculator) ctx.getBean(ArithmeticCalculatorImpl.class);
//		System.out.println(arithmeticCalculator2);
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 0);
		System.out.println("result:" + result);
	}
	
}
