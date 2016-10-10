package com.johnny.javase.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {

	//创建对应的运行时类的对象
	@Test
	public void test1() throws Exception{
		String className = "com.johnny.javase.reflect.Person";
		Class clazz = Class.forName(className);
		//创建对应的运行时类的对象。使用newInstance()，实际上就是调用了运行时类的空参的构造器。
		//要想能够创建成功：①要求对应的运行时类要有空参的构造器。②构造器的权限修饰符的权限要足够。
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
	}
	
	//获取所有构造函数
	@Test
	public void test2() throws ClassNotFoundException{
		String className = "com.johnny.javase.reflect.Person";
		Class clazz = Class.forName(className);
		//获取所有构造函数
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c : cons){
			System.out.println(c);
		}
	}
	
	//调用指定的构造器,创建运行时类的对象
	@Test
	public void test3() throws Exception{
		String className = "com.johnny.javase.reflect.Person";
		Class clazz = Class.forName(className);
		//调用私有构造函数
		Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		Person p = (Person)cons.newInstance("罗伟",20);
		System.out.println(p);
	}
}
