package com.johnny.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * http://localhost:8090/johnny/login.do?user=johnny&password=123456&interesting=sing&interesting=play
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("请求来了...");
		System.out.println(request); //org.apache.catalina.connector.RequestFacade@3e1bc8
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		System.out.println(user + ", " + password); //johnny, 123456
		
		String interesting = request.getParameter("interesting");
		System.out.println(interesting); //sing

		String [] interestings = request.getParameterValues("interesting");
		for(String interest: interestings){
//			-->sing
//			-->play
			System.out.println("-->" + interest);
		}
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String val = request.getParameter(name);
			/*
			 ^^user: johnny
			^^password: 123456
			^^interesting: sing
			 */
			System.out.println("^^" + name + ": " + val);
		}
		
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()){
			/*
			 * *user:[johnny] *password:[123456] *interesting:[sing, play]
			 */
			System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));  
		}
		
		System.out.println("---获取网络连接信息 --");
		//
		System.out.println(request.getRemoteAddr());//方法返回发出请求的客户机的IP地址，其格式为“192.168.0.3”这种形式的字符文本。 （*） 
		System.out.println(request.getRemoteHost());//方法返回发出请求的客户机的完整主机名，即“pc1.johnny.com”这种格式。
		System.out.println(request.getRemotePort());//方法返回发出请求的客户机所使用的网络接口的端口号。
		System.out.println(request.getLocalAddr());//方法返回WEB服务器上接收当前请求的网络接口的IP地址。
		System.out.println(request.getLocalName());//方法返回WEB服务器上接收当前请求的网络接口的IP地址所对应的主机名。
		System.out.println(request.getLocalPort());//方法返回WEB服务器上接收当前请求的网络接口的端口号。//8090
		System.out.println(request.getServerName());//方法返回当前请求所指向的主机名。 //localhost
		System.out.println(request.getServerPort());//方法返回当前请求所连接的服务器端口号。//8090
		System.out.println(request.getScheme());//方法返回请求的协议名，例如http、https或ftp。//http
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);///johnny/login.do
		
		String method = httpServletRequest.getMethod();
		System.out.println(method); //GET
		
		String queryString = httpServletRequest.getQueryString();//Post获取到的是null
		System.out.println(queryString); //user=johnny&password=123456&interesting=sing&interesting=play
		
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath); ///login.do
		

		
		response.setContentType("application/msword");

		PrintWriter out = response.getWriter();
		out.println("helloworld...");
		
	}

	

}
