package com.johnny.javaweb.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 类 编 号：
 * 类 名 称： ServletContext域对象中属性的变更的事件监听器
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		String str = MessageFormat.format(
				"ServletContext域对象中添加了属性:{0}，属性值是:{1}", scab.getName(),
				scab.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		String str = MessageFormat.format(
				"ServletContext域对象中删除属性:{0}，属性值是:{1}", scab.getName(),
				scab.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		String str = MessageFormat.format("ServletContext域对象中替换了属性:{0}的值",
				scab.getName());
		System.out.println(str);
	}
}