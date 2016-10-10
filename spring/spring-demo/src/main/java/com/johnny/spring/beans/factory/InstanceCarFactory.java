package com.johnny.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法：先实例化一个工厂bean ， 在调用工厂的示例方法来返回bean的实例
 * @author Administrator
 *
 */
public class InstanceCarFactory {
	private  Map<String,Car> cars = new HashMap<>();
	public InstanceCarFactory(){
		cars.put("ford", new Car("ford"));
		cars.put("bmw", new Car("bmw"));
	}

	public Car getCar(String model){
		return cars.get(model);
	}
}
