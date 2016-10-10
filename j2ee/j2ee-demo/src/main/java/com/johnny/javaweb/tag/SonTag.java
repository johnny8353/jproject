package com.johnny.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		//1. 得到父标签的引用
		JspTag parent = getParent();
		
		//2. 获取父标签的 name 属性
		ParentTag parentTag = (ParentTag) parent;
		String name = parentTag.getName();
		
		//3. 把 name 值打印到 JSP 页面上.
		getJspContext().getOut().print("子标签输出name: " + name);
	}
	
}
