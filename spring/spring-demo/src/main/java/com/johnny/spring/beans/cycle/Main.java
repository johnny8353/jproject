package com.johnny.spring.beans.cycle;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
public class Main {
	static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
	}

	/**
	 * Spring IOC 容器可以管理 Bean 的生命周期, Spring 允许在 Bean 生命周期的特定点执行定制的任务. 
		Spring IOC 容器对 Bean 的生命周期进行管理的过程:
			通过构造器或工厂方法创建 Bean 实例
			为 Bean 的属性设置值和对其他 Bean 的引用
			调用 Bean 的初始化方法
			Bean 可以使用了
			当容器关闭时, 调用 Bean 的销毁方法
		在 Bean 的声明里设置 init-method 和 destroy-method 属性, 为 Bean 指定初始化和销毁方法.
	
		加入后置处理器
			Spring IOC 容器对 Bean 的生命周期进行管理的过程:
			通过构造器或工厂方法创建 Bean 实例
			为 Bean 的属性设置值和对其他 Bean 的引用
			将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法
			调用 Bean 的初始化方法
			将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法
			Bean 可以使用了
			当容器关闭时, 调用 Bean 的销毁方法
	 */
	@Test
	public void test6() {
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		ctx.destroy();
	}
}
