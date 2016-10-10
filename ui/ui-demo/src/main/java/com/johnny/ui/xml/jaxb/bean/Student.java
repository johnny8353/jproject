package com.johnny.ui.xml.jaxb.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 类 编 号：
 * 类 名 称：Student
 * 内容摘要：
	比较常用的几个：
       @XmlRootElement：根节点
       @XmlAttribute：该属性作为xml的attribute
       @XmlElement：该属性作为xml的element，且可以增加属性(name="NewElementName")，那么生成的xml串的elment的标签是NewElementName
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */

@XmlRootElement
public class Student {
	private String name;
	private String width;
	private String height;
	private int age;

	public Student(String name, String width, String height, int age) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		super();
	}

}
