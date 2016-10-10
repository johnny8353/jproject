package com.johnny.spring.beans.cycle;

public class Car {
	private String model;
	public Car(){
		System.out.println("car construct");
	}
	
	public void init(){
		System.out.println("car init");
	}
	public void destory(){
		System.out.println("car destory");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		System.out.println("set model...");
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}
	
	

}
