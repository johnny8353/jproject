package com.johnny.ui.json.bean;

import java.util.Date;
import java.util.List;

/**
 * 类 编 号：
 * 类 名 称：OrderBO
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class OrderBO {
	private String orderNum;
	private double orderPrice;
	private Date submitDate;
	private Date createTime;
	private Date lastupdTime;
	private List<OrderLine> orderline;
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastupdTime() {
		return lastupdTime;
	}
	public void setLastupdTime(Date lastupdTime) {
		this.lastupdTime = lastupdTime;
	}
	public List<OrderLine> getOrderline() {
		return orderline;
	}
	public void setOrderline(List<OrderLine> orderline) {
		this.orderline = orderline;
	}
	@Override
	public String toString() {
		return "OrderBO [orderNum=" + orderNum + ", orderPrice=" + orderPrice
				+ ", submitDate=" + submitDate + ", createTime=" + createTime
				+ ", lastupdTime=" + lastupdTime + ", orderline=" + orderline
				+ "]";
	}
	public OrderBO(String orderNum, double orderPrice, Date submitDate,
			Date createTime, Date lastupdTime, List<OrderLine> orderline) {
		super();
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.submitDate = submitDate;
		this.createTime = createTime;
		this.lastupdTime = lastupdTime;
		this.orderline = orderline;
	}
	public OrderBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
