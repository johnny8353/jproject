package com.johnny.hibernate.relation.n2one.both;

import java.util.HashSet;
import java.util.Set;

public class Customer2 {

	private Integer customerId;
	private String customerName;
	
	/*
	 * 1. 声明集合类型时, 需使用接口类型, 因为 hibernate 在获取
	 * 集合类型时, 返回的是 Hibernate 内置的集合类型, 而不是 JavaSE 一个标准的
	 * 集合实现. 
	 * 2. 需要把集合进行初始化, 可以防止发生空指针异常
	 */
	private Set<Order2> orders = new HashSet<>();

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

	public Set<Order2> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order2> orders) {
		this.orders = orders;
	}
	
	

}
