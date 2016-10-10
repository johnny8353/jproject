package com.johnny.spring.beans.helloworld;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@BeforeClass
	public static void classBegin(){
		
	}
	
	@Test
	public void test() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setUser("Tom");
		helloWorld.hello(); 
	}
	@Test
	public void test1() {
		
		//1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. 从 IOC 容器中获取 bean 的实例
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		//根据类型来获取 bean 的实例: 要求在  IOC 容器中只有一个与之类型匹配的 bean, 若有多个则会抛出异常. 
		//一般情况下, 该方法可用, 因为一般情况下, 在一个 IOC 容器中一个类型对应的 bean 也只有一个. 
		//不需要强转
//		HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);
		
		//3. 使用 bean
		helloWorld.hello();
	}
	//依赖注入的方式：属性注入；构造器注入
	@Test
	public void test2() {
		//1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println("car2:"+car2);
		
	}
	
	//引用其它 Bean..
	@Test
	public void test3() {
		//1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2);
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3);
	}
	
	@Test
	public void testRelation(){
		//1. 创建 Spring 的 IOC 容器 , 加载 配置文件，创建配置文件下的bean，包括对property赋值
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person5 = (Person) ctx.getBean("person5");
		System.out.println(person5);
		Person person7 = (Person) ctx.getBean("person7");
		System.out.println(person7);
	}
}
