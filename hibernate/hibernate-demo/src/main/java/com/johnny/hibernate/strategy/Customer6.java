package com.johnny.hibernate.strategy;

import java.util.HashSet;
import java.util.Set;

public class Customer6 {

	private Integer customerId;
	private String customerName;
	
	private Set<Order6> orders = new HashSet<>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Order6> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order6> orders) {
		this.orders = orders;
	}

	public Customer6() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
