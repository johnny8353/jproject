package com.johnny.ehcache.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestService testService = (TestService) context.getBean("testService");
        for (int i = 0; i < 5; i++) {
        	long begin = System.currentTimeMillis();
            testService.getUserName("mango");
            System.out.println(System.currentTimeMillis()-begin);
        }
    }
}
