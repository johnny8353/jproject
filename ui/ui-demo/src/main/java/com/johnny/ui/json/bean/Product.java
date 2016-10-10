package com.johnny.ui.json.bean;

/**
 * 类 编 号：
 * 类 名 称：Product
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class Product {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
