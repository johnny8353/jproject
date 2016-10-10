package com.johnny.javaweb.filter.login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnny.javaweb.filter.HttpFilter;

public class LoginFilter extends HttpFilter{

	//1. 从 web.xml 文件中获取 sessionKey, redirectUrl, uncheckedUrls
	private String sessionKey;
	private String redirectUrl;
	private String unchekcedUrls;
	
	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("rediretPage");
		///login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp
		unchekcedUrls = servletContext.getInitParameter("uncheckedUrls");
	}
	
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//1. 获取请求的 servletPath
		// /login/b.jsp
		String servletPath = request.getServletPath();
		
		//2. 检查 1 获取的 servletPath 是否为不需要检查的 URL 中的一个, 若是, 则直接放行. 方法结束
		List<String> urls = Arrays.asList(unchekcedUrls.split(","));
		if(urls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		
		//3. 从 session 中获取 sessionKey 对应的值, 若值不存在, 则重定向到 redirectUrl
		Object user = request.getSession().getAttribute(sessionKey);
		System.out.println("user=="+user);
		if(user == null){
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return;
		}
		
		//4. 若存在, 则放行, 允许访问. 
		filterChain.doFilter(request, response);
	}

}
