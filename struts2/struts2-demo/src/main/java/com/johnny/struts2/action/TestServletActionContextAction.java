package com.johnny.struts2.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {
	//和 Servlet API 耦合的方式: 可以访问更多的 Servlet API 对象, 且可以调用其原生的方法.  
	public void execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = request.getSession();
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		
		System.out.println("execute....");
	}
}
