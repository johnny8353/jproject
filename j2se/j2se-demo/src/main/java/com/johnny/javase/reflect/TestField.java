package com.johnny.javase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	/**
	 * 获取对应的运行时类的属性
	 * 输出
	 * public java.lang.String com.johnny.javase.reflect.Person.name
		public double com.johnny.javase.reflect.Creature.weight
		name
		age
		id
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getFields():只能获取到运行时类中及其父类中声明为public的属性
		Field[] fields = clazz.getFields();
		for(int i = 0;i < fields.length;i++){
			System.out.println(fields[i]);
		}
		System.out.println();
		//2.getDeclaredFields():获取运行时类本身声明的所有的属性
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			System.out.println(f.getName());
		}
	}

	/** 
	 * 权限修饰符  变量类型 变量名
	 * 获取属性的各个部分的内容
	 * 输出
	 * public java.lang.String name
		private int age
		 int id
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields1 = clazz.getDeclaredFields();

		for(Field f : fields1){
			//1.获取每个属性的权限修饰符
			int i = f.getModifiers();
			String str1 = Modifier.toString(i);
			System.out.print(str1 + " ");
			//2.获取属性的类型
			Class type = f.getType();
			System.out.print(type.getName() + " ");
			//3.获取属性名
			System.out.print(f.getName());
			
			System.out.println();
		}
	}
	
	//调用运行时类中指定的属性
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//1.获取指定的属性
		//getField(String fieldName):获取运行时类中声明为public的指定属性名为fieldName的属性
		Field name = clazz.getField("name");
		//2.创建运行时类的对象 
		Person p = (Person)clazz.newInstance();
		System.out.println(p);//Person [name=null, age=0]
		//3.将运行时类的指定的属性赋值
		name.set(p,"Jerry");
		System.out.println(p);//Person [name=Jerry, age=0]
		System.out.println("%"+name.get(p));//%Jerry
		
		System.out.println();
		//getDeclaredField(String fieldName):获取运行时类中指定的名为fieldName的属性
		Field age = clazz.getDeclaredField("age");
		//由于属性权限修饰符的限制，为了保证可以给属性赋值，需要在操作前使得此属性可被操作。
		age.setAccessible(true);
		age.set(p,10);
		System.out.println(p);//Person [name=Jerry, age=10]
		
//		Field id = clazz.getField("id");
		
	}
	
}
