package com.johnny.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class MyBeanPostProcessor implements BeanPostProcessor {

	//该方法在 init 方法之后被调用
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(beanName.equals("car")){
			System.out.println("postProcessAfterInitialization..." + bean + "," + beanName);
			
		}
		return bean;
	}

	//该方法在 init 方法之前被调用
	//可以工作返回的对象来决定最终返回给 getBean 方法的对象是哪一个, 属性值是什么
	/**
	 * @param bean: 实际要返回的对象
	 * @param beanName: bean 的 id 值
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(beanName.equals("car")){
			System.out.println("postProcessBeforeInitialization..." + bean + "," + beanName);
			//修改返回的car
			Car car = new Car();
			car.setModel("Ford");
			bean = car;
		}
		return bean;
	}

}
