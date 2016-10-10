package com.johnny.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport {
	
	private String name = "www.johnny.com";
	
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签的标签处理器类 name: " + name);
		getJspBody().invoke(null);
	}
	
}
