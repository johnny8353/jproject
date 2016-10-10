package com.johnny.javase.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;
/**
 * Superclass、Interface、Annotation
 */
public class TestOthers {
	//6.获取注解
	@Test
	public void test6(){
		Class clazz = Person.class;
		Annotation[] anns = clazz.getAnnotations();
		for(Annotation a : anns){
			System.out.println(a);//@com.johnny.javase.reflect.MyAnnotation(value=hh)
		}
	}
	
	//5.获取所在的包
	@Test
	public void test5(){
		Class clazz = Person.class;
		Package pack = clazz.getPackage();
		System.out.println(pack);//package com.johnny.javase.reflect
	}
	
	//4.获取实现的接口
	@Test
	public void test4(){
		Class clazz = Person.class;
		Class[] interfaces = clazz.getInterfaces();
		for(Class i : interfaces){
//			interface java.lang.Comparable
//			interface com.johnny.javase.reflect.MyInterface
			System.out.println(i);
		}
	}
	
	//3*.获取父类的泛型
	@Test
	public void test3(){
		Class clazz = Person.class;
		Type type1 = clazz.getGenericSuperclass();
		
		ParameterizedType param = (ParameterizedType)type1;
		Type[] ars = param.getActualTypeArguments();
		
		System.out.println(((Class)ars[0]).getName());//java.lang.String
		System.out.println(param.getOwnerType());
		System.out.println(param.getRawType());//class com.johnny.javase.reflect.Creature
		System.out.println(param.getClass());//class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
	}
	
	//2.获取带泛型的父类
	@Test
	public void test2(){
		Class clazz = Person.class;
		//com.johnny.javase.reflect.Creature<java.lang.String>
		Type type1 = clazz.getGenericSuperclass();
		System.out.println(type1);
	}
	
	//1.获取运行时类的父类
	@Test
	public void test1(){
		Class clazz = Person.class;
		Class superClass = clazz.getSuperclass();
		System.out.println(superClass);//class com.johnny.javase.reflect.Creature
	}
}
