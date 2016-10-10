package com.johnny.struts2.action;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * ServletRequestAware,ServletResponseAware,ServletContextAware
 * 接口里只有对应的set方法
 */
public class TestServletAwareAction implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	public void setServletContext(ServletContext context) {
		System.out.println(context);
	}

	public void setServletResponse(HttpServletResponse response) {
		System.out.println(response);
		
	}

	public void setServletRequest(HttpServletRequest request) {
		System.out.println(request);
		// TODO Auto-generated method stub
		
	}
}
