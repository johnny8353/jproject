package com.johnny.spring.beans.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car = (Car) ctx.getBean("car1");
		System.out.println(car);
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		Car car3 = (Car) ctx.getBean("car3");
		System.out.println(car3);
		
		ctx.close();
	}

}
