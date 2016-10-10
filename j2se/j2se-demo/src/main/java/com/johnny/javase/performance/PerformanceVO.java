package com.johnny.javase.performance;

/**
 * 类 编 号：
 * 类 名 称：PerformanceVO
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class PerformanceVO {
	private int count;
	private String name;
	private String object;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "PerformanceVO [count=" + count + ", name=" + name + ", object="
				+ object + "]";
	}
	public PerformanceVO(int count, String name, String object) {
		super();
		this.count = count;
		this.name = name;
		this.object = object;
	}
	public PerformanceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
