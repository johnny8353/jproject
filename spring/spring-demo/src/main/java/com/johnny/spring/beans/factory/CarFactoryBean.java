package com.johnny.spring.beans.factory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car>{
	private String brand;
	public CarFactoryBean(String brand){
		this.brand = brand;
	}
	@Override
	public Car getObject() throws Exception {
		return new Car(brand);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
}
