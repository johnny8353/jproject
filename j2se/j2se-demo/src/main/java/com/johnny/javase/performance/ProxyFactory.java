package com.johnny.javase.performance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.johnny.javase.performance.collection.TestListPerformance;

public class ProxyFactory {

	/**
	 * 类 编 号：
	 * 类 名 称：ProxyFactory
	 * 内容摘要：<说明该类的目前已经实现的主要功能>
	 * 完成日期：2016年8月4日
	 * 编码作者：JohnnyHuang 黄福强
	 */
	// 动态的创建一个代理类的对象
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler2 handler = new MyInvocationHandler2();
		handler.setObject(obj);

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), handler);
	}
}

class MyInvocationHandler2 implements InvocationHandler {
	Object obj;// 被代理类对象的声明

	public void setObject(Object obj) {
		this.obj = obj;
	}

	// 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {// 10000次插入 ，修改，删除
		StringBuffer printMsg = new StringBuffer();
		long begin = System.currentTimeMillis();
		Object returnVal = method.invoke(obj, args);
		long end = System.currentTimeMillis();
		PerformanceBase collectionPerformance = (PerformanceBase) obj;
		PerformanceVO vo = collectionPerformance.getPerformanceVO();
		// printMsg.append("名称\t方法\t次数\t时间\t类\n");
		printMsg.append(vo.getName() + "\t" + method.getName() + "\t"
				+ vo.getCount() + "\t" + (end - begin) + "\t" + vo.getObject()
				+ "");
		System.out.println(printMsg.toString());
		return returnVal;
	}
}
