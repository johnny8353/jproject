package com.johnny.spring.aop.proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public void testLog(){
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
	}
	@Test
	public void testProxy(){
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
		arithmeticCalculator =
				new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
	}
}
