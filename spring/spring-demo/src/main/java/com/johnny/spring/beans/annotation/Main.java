package com.johnny.spring.beans.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.spring.beans.annotation.controller.UserController;
import com.johnny.spring.beans.annotation.repository.UserRepository;
import com.johnny.spring.beans.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {
		//需要引入spring-aop-4.0.0.RELEASE.jar
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		TestObject testObject = (TestObject) ctx.getBean("testObject");
		System.out.println(testObject);
		
		UserRepository repository = (UserRepository) ctx.getBean("userRepositoryImpl");
		System.out.println(repository);
		
		UserService userService = (UserService) ctx.getBean("userService");
		System.out.println(userService);
			
		UserController userController = (UserController) ctx.getBean("userController");
		userController.execute();
				
		
		
	}
}
