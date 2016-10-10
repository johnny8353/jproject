package com.johnny.javase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Human {
	void info();

	void fly();
}

// 被代理类
class SuperMan implements Human {
	public void info() {
		System.out.println("我是超人！我怕谁！");
	}

	public void fly() {
		System.out.println("I believe I can fly!");
	}
}

class HumanUtil {
	public void method1() {
		System.out.println("=======方法一=======");
	}

	public void method2() {
		System.out.println("=======方法二=======");
	}
}

/**
 * 使用Proxy生成一个动态代理时，往往并不会凭空产生一个动态代理，这样没有太大的意义。通常都是为指定的目标对象生成动态代理
 * 这种动态代理在AOP中被称为AOP代理，AOP代理可代替目标对象，AOP代理包含了目标对象的全部方法。
 * 但AOP代理中的方法与目标对象的方法存在差异：AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理
 */
class MyInvocationHandler2 implements InvocationHandler {
	Object obj;// 被代理类对象的声明

	public void setObject(Object obj) {
		this.obj = obj;
	}
	// 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		HumanUtil h = new HumanUtil();
		h.method1();

		Object returnVal = method.invoke(obj, args);

		h.method2();
		return returnVal;
	}
}

class MyProxy {
	// 动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler2 handler = new MyInvocationHandler2();
		handler.setObject(obj);

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), handler);
	}
}

public class TestAOP {
	public static void main(String[] args) {
		/**
		 * 输出
		 =======方法一=======
		我是超人！我怕谁！
		=======方法二=======
		
		=======方法一=======
		I believe I can fly!
		=======方法二=======
		=======方法一=======
		Nike工厂生产一批衣服
		=======方法二=======
		 */
		SuperMan man = new SuperMan();//创建一个被代理类的对象
		Object obj = MyProxy.getProxyInstance(man);//返回一个代理类的对象
		Human hu = (Human)obj;
		hu.info();//通过代理类的对象调用重写的抽象方法
		
		System.out.println();
		
		hu.fly();
		
		//*********
		NikeClothFactory nike = new NikeClothFactory();
		Object obj1 = MyProxy.getProxyInstance(nike);
		ClothFactory cloth = (ClothFactory)obj1;
		cloth.productCloth();
	}
}
