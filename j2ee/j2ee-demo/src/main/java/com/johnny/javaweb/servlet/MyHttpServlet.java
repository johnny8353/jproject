package com.johnny.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 针对于 HTTP 协议定义的一个 Servlet 基类
 */
public class MyHttpServlet extends MyGenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		if(arg0 instanceof HttpServletRequest){
			HttpServletRequest request = (HttpServletRequest)arg0;
			
			if(arg1 instanceof HttpServletResponse){
				HttpServletResponse response = (HttpServletResponse)arg1;
				
				service(request, response);
			}
		}
		
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 获取请求方式.
		String method = request.getMethod();
		
		//2. 根据请求方式再调用对应的处理方法
		if("GET".equalsIgnoreCase(method)){
			doGet(request, response);
		}else if("POST".equalsIgnoreCase(method)){
			doPost(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


}
