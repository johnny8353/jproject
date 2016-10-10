package com.johnny.spring.beans.factory;

public class Car {
	private String model;
	public Car(){
		System.out.println("car construct");
	}
	

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}


	public Car(String model) {
		super();
		this.model = model;
	}
	
	

}
