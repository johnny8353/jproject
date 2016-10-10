package com.johnny.javaweb.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 类 编 号：
 * 类 名 称：MyServletRequestListener类实现了ServletRequestListener接口，
 *       因此可以对ServletRequest对象的创建和销毁这两个动作进行监听。
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest() + "销毁了！！");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest() + "创建了！！");
	}
}