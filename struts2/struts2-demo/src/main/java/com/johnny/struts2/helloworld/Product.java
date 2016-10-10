package com.johnny.struts2.helloworld;

public class Product {
	
	private Integer productId;
	private String productName;
	private String productDesc;
	
	private double productPrice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Product(Integer productId, String productName, String productDesc,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
		System.out.println("product constuct...");
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + "]";
	}
	public String save(){
		System.out.println("save: " + this);
		return "details";
	}
	
	public String test(){
		System.out.println("test");
		return "success";
	}
	
	
}
