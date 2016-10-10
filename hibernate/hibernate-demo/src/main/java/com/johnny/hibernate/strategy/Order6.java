package com.johnny.hibernate.strategy;

public class Order6 {
	
	private Integer orderId;
	private String orderName;
	
	private Customer6 customer;

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

	public Customer6 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer6 customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order6 other = (Order6) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	public Order6() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order6(Integer orderId, String orderName, Customer6 customer) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.customer = customer;
	}
	
	
	
}
