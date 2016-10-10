package com.johnny.hibernate.relation.n2one.both;

public class Order2 {
	
	private Integer orderId;
	private String orderName;
	
	private Customer2 customer;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Customer2 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}
	
	
	
}
