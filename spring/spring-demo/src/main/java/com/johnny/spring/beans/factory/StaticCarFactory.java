package com.johnny.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
	private static Map<String,Car> cars = new HashMap<>();
	static{
		cars.put("ford", new Car("ford"));
		cars.put("bmw", new Car("bmw"));
	}

	public static Car getCar(String model){
		return cars.get(model);
	}
	
}
