package com.johnny.javase.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	//1.获取运行时类的方法
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getMethods():获取运行时类及其父类中所有的声明为public的方法
		/**
		 * 输出
			public int com.johnny.javase.reflect.Person.getAge()
			public void com.johnny.javase.reflect.Person.setId(int)
			public void com.johnny.javase.reflect.Person.setAge(int)
			public java.lang.String com.johnny.javase.reflect.Person.toString()
			public java.lang.String com.johnny.javase.reflect.Person.getName()
			public int com.johnny.javase.reflect.Person.compareTo(java.lang.Object)
			public int com.johnny.javase.reflect.Person.getId()
			public void com.johnny.javase.reflect.Person.setName(java.lang.String)
			public void com.johnny.javase.reflect.Person.show()
			public static void com.johnny.javase.reflect.Person.info()
			public void com.johnny.javase.reflect.Creature.breath()
			public final native java.lang.Class java.lang.Object.getClass()
			public native int java.lang.Object.hashCode()
			public boolean java.lang.Object.equals(java.lang.Object)
			public final native void java.lang.Object.notify()
			public final native void java.lang.Object.notifyAll()
			public final void java.lang.Object.wait() throws java.lang.InterruptedException
			public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
			public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
		 */
		Method[] m1 = clazz.getMethods();
		for(Method m : m1){
			System.out.println(m);
		}
		System.out.println();
		
		//2.getDeclaredMethods():获取运行时类本身声明的所有的方法
		/**
		 * 输出
			private java.lang.Integer com.johnny.javase.reflect.Person.display(java.lang.String,java.lang.Integer) throws java.lang.Exception
			private void com.johnny.javase.reflect.Person.display(java.lang.String) throws java.lang.Exception
			public int com.johnny.javase.reflect.Person.getAge()
			public void com.johnny.javase.reflect.Person.setId(int)
			public void com.johnny.javase.reflect.Person.setAge(int)
			public java.lang.String com.johnny.javase.reflect.Person.toString()
			public java.lang.String com.johnny.javase.reflect.Person.getName()
			public int com.johnny.javase.reflect.Person.compareTo(java.lang.Object)
			public int com.johnny.javase.reflect.Person.getId()
			public void com.johnny.javase.reflect.Person.setName(java.lang.String)
			public void com.johnny.javase.reflect.Person.show()
			public static void com.johnny.javase.reflect.Person.info()
		 */
		Method[] m2 = clazz.getDeclaredMethods();
		for(Method m : m2){
			System.out.println(m);
		}
	}
	/**
	 * 	注解 权限修饰符 返回值类型 方法名 形参列表 异常
	 * 	输出
		private java.lang.Integer display (java.lang.String args-0 java.lang.Integer args-1 )throws java.lang.Exception 
		private void display (java.lang.String args-0 )throws java.lang.Exception 
		public int getAge ()
		public void setId (int args-0 )
		public void setAge (int args-0 )
		public java.lang.String toString ()
		public java.lang.String getName ()
		public int compareTo (java.lang.Object args-0 )
		public int getId ()
		public void setName (java.lang.String args-0 )
		@com.johnny.javase.reflect.MyAnnotation(value=abc123)
		public void show ()
		public static void info ()
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		
		Method[] m2 = clazz.getDeclaredMethods();
		for(Method m : m2){
			//1.注解
			Annotation[] ann = m.getAnnotations();
			for(Annotation a : ann){
				System.out.println(a);
			}
			
			//2.权限修饰符
			String str = Modifier.toString(m.getModifiers());
			System.out.print(str + " ");
			//3.返回值类型
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName() + " ");
			//4.方法名
			System.out.print(m.getName() + " ");
			
			//5.形参列表
			System.out.print("(");
			Class[] params = m.getParameterTypes();
			for(int i = 0;i < params.length;i++){
				System.out.print(params[i].getName() + " args-" + i + " ");
			}
			System.out.print(")");
			
			//6.异常类型
			Class[] exps = m.getExceptionTypes();
			if(exps.length != 0){
				System.out.print("throws ");
			}
			for(int i = 0;i < exps.length;i++){
				System.out.print(exps[i].getName() + " ");
			}
			System.out.println();
		}
	}
	//调用运行时类中指定的方法
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//getMethod(String methodName,Class ... params):获取运行时类中声明为public的指定的方法
		Method m1 = clazz.getMethod("show");
		Person p = (Person)clazz.newInstance();
		//调用指定的方法：Object invoke(Object obj,Object ... obj)
		Object returnVal = m1.invoke(p);//我是一个人
		System.out.println(returnVal);//null
		
		Method m2 = clazz.getMethod("toString");
		Object returnVal1 = m2.invoke(p);
		System.out.println(returnVal1);//Person [name=null, age=0]
		//对于运行时类中静态方法的调用
		Method m3 = clazz.getMethod("info");
		m3.invoke(Person.class);
		
		//getDeclaredMethod(String methodName,Class ... params):获取运行时类中声明了的指定的方法
		Method m4 = clazz.getDeclaredMethod("display",String.class,Integer.class);
		m4.setAccessible(true);
		Object value = m4.invoke(p,"CHN",10);//我的国籍是：CHN
		System.out.println(value);//10
	}
}
