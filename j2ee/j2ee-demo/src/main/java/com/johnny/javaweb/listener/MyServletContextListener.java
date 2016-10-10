package com.johnny.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 类 编 号：
 * 类 名 称：MyServletContextListener
 * 内容摘要：MyServletContextListener类实现了ServletContextListener接口
 *        因此可以对ServletContext对象的创建和销毁这两个动作进行监听
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象销毁");
	}
}