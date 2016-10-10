package com.johnny.webservice.axis2.pojo;

/**
 * 类 编 号：
 * 类 名 称：SimpleService
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月14日
 * 编码作者：JohnnyHuang 黄福强
 */
public class PojoService {

	public String getGreeting(String name) {
		return "你好 " + name;
	}

	public int getPrice() {
		return new java.util.Random().nextInt(1000);
	}

}
