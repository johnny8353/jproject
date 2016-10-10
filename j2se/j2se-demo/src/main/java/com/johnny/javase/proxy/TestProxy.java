package com.johnny.javase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象。
 */
//动态代理的使用，体会反射是动态语言的关键
interface Subject {
	void action();
}

// 被代理类
class RealSubject implements Subject {
	public void action() {
		System.out.println("我是被代理类，记得要执行我哦！么么~~");
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;// 实现了接口的被代理类的对象的声明

	// ①给被代理的对象实例化②返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}
	//当通过代理类的对象发起对被重写的方法的调用时，都会转换为对如下的invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("动态代理 begin....");
		//method方法的返回值时returnVal
		Object returnVal = method.invoke(obj, args);
		System.out.println("动态代理 end....");
		System.out.println(returnVal);
		return returnVal;
	}

}

public class TestProxy {
	public static void main(String[] args) {
		//1.被代理类的对象
		RealSubject real = new RealSubject();
		//2.创建一个实现了InvacationHandler接口的类的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		//3.调用blind()方法，动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象。
		Object obj = handler.blind(real);
		Subject sub = (Subject)obj;//此时sub就是代理类的对象
		
		sub.action();//转到对InvacationHandler接口的实现类的invoke()方法的调用
		
		//再举一例
		NikeClothFactory nike = new NikeClothFactory();
		ClothFactory proxyCloth = (ClothFactory)handler.blind(nike);//proxyCloth即为代理类的对象
		proxyCloth.productCloth();
		
		
		
	}
}
