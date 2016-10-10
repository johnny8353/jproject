package com.johnny.struts2.helloworld;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
public class FilterDispatcher implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		//1. 获取 servletPath
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		
		String path = null;
		
		//2. 判断 servletPath, 若其等于 "/product-input.action", 则转发到
		///WEB-INF/pages/helloworld/input.jsp
		if("/product-input.do".equals(servletPath)){
			path = "/WEB-INF/pages/helloworld/input.jsp";
		}
		
		//3. 若其等于 "/product-save.action", 则
		if("/product-save.do".equals(servletPath)){
			//1). 获取请求参数
			String productName = request.getParameter("productName");
			String productDesc = request.getParameter("productDesc");
			String productPrice = request.getParameter("productPrice");
			
			//2). 把请求信息封装为一个 Product 对象
			Product product = new Product(null, productName, productDesc, Double.parseDouble(productPrice));
			
			//3). 执行保存操作
			System.out.println("Save Product: " + product);
			product.setProductId(1001);
			
			//4). 把 Product 对象保存到 request 中. ${param.productName} -> ${requestScope.product.productName}
			request.setAttribute("product", product);
			
			path = "/WEB-INF/pages/helloworld/details.jsp";
		}
		
		if(path != null){
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
