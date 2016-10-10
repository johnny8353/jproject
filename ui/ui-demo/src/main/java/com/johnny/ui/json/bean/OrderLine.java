package com.johnny.ui.json.bean;

/**
 * 类 编 号：
 * 类 名 称：OrderLine
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class OrderLine {
	private String seq;
	private String name;
	private Product product;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderLine [seq=" + seq + ", name=" + name + ", product="
				+ product + "]";
	}
	public OrderLine(String seq, String name, Product product) {
		super();
		this.seq = seq;
		this.name = name;
		this.product = product;
	}
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
