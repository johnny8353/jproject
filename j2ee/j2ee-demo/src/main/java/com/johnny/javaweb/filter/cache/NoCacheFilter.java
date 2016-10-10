package com.johnny.javaweb.filter.cache;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnny.javaweb.filter.HttpFilter;

/**
 * 内容摘要：禁止浏览器缓存所有动态页面
 * 完成日期：2016年7月25日
 * 编码作者："JohnnyHuang 黄福强"
 */
public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("cacheFilter's doFilter..");
		
		response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		
		filterChain.doFilter(request, response);
	}

    

}
