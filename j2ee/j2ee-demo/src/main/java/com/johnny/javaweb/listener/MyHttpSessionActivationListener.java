package com.johnny.javaweb.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 类 编 号：
 * 类 名 称：MyHttpSessionActivationListener
 * 内容摘要：实现了HttpSessionActivationListener接口的 JavaBean 对象可以感知自己被活化和钝化的事件
	    活化:javabean对象和Session一起被反序列化(活化)到内存中。
	    钝化:javabean对象存在Session中，当服务器把session序列化到硬盘上时，如果Session中的javabean对象实现了Serializable接口
	    那么服务器会把session中的javabean对象一起序列化到硬盘上，javabean对象和Session一起被序列化到硬盘中的这个操作称之为钝化
	    如果Session中的javabean对象没有实现Serializable接口，那么服务器会先把Session中没有实现Serializable接口的javabean对象移除
	    然后再把Session序列化(钝化)到硬盘中
	    当绑定到 HttpSession对象中的javabean对象将要随 HttpSession对象被钝化之前，
	    web服务器调用该javabean对象对象的 void sessionWillPassivate(HttpSessionEvent event)方法
	    这样javabean对象就可以知道自己将要和 HttpSession对象一起被序列化(钝化)到硬盘中
	    当绑定到HttpSession对象中的javabean对象将要随 HttpSession对象被活化之后，
	    web服务器调用该javabean对象的 void sessionDidActive(HttpSessionEvent event)方法
	    这样javabean对象就可以知道自己将要和 HttpSession对象一起被反序列化(活化)回到内存中
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class MyHttpSessionActivationListener implements
		HttpSessionActivationListener, Serializable {

	private static final long serialVersionUID = 7589841135210272124L;
	private String name;

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {

		System.out.println(name + "和session一起被序列化(钝化)到硬盘了，session的id是："
				+ se.getSession().getId());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println(name + "和session一起从硬盘反序列化(活化)回到内存了，session的id是："
				+ se.getSession().getId());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyHttpSessionActivationListener(String name) {
		this.name = name;
	}
}
