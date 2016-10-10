package com.johnny.javaweb.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 类 编 号：
 * 类 名 称：MyHttpSessionListener
 * 内容摘要：MyHttpSessionListener类实现了HttpSessionListener接口，
 *         因此可以对HttpSession对象的创建和销毁这两个动作进行监听。
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(se.getSession() + "创建了！！");
		System.out.println("创建好的JSESSIONID是"+se.getSession().getId());
	}

	/*
	 * HttpSession的销毁时机需要在web.xml中进行配置，如下： <session-config>
	 * <session-timeout>1</session-timeout> </session-config>
	 * 这样配置就表示session在1分钟之后就被销毁
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁了！！");
	}
}