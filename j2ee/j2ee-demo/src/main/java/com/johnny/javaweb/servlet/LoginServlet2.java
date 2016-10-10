package com.johnny.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		// 获取请求方式是 GET 还是 POST
		String method = request.getMethod();
		System.out.println(method);

		// 1. 获取请求参数: username, password
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2. 获取当前 WEB 应用的初始化参数: user, password.
		// 需要使用 ServletContext 对象.
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");

		PrintWriter out = response.getWriter();

		// 3. 比对
		// 4. 打印响应字符串.
		if (initUser.equals(username) && initPassword.equals(password)) {
			out.print("Hello: " + username);
		} else {
			out.print("Sorry: " + username);
		}

	}

}
