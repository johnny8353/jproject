package com.johnny.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAttr
 */
public class TestAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//1. 在 Servlet 中无法得到 pageContext 对象
		
		//2. request
		Object requestAttr = request.getAttribute("requestAttr");
		out.print("requestAttr: " + requestAttr);
		out.print("<br><br>");
		
		//3. session
		Object sessionAttr = request.getSession().getAttribute("sessionAttr");
		out.print("sessionAttr: " + sessionAttr);
		out.print("<br><br>");
		
		//4. application
		Object applicationAttr = getServletContext().getAttribute("applicationAttr");
		out.print("applicationAttr: " + applicationAttr);
		out.print("<br><br>");
				
	}

}
