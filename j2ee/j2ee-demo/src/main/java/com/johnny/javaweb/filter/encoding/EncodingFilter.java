package com.johnny.javaweb.filter.encoding;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnny.javaweb.filter.HttpFilter;
import com.johnny.javaweb.tag.Util;

/**
 * 内容摘要：此过滤器用来解决全站中文乱码问题 完成日期：
 * 2016年7月25日 
 * 编码作者："JohnnyHuang 黄福强"
 */
public class EncodingFilter extends HttpFilter {

	private String encoding;

	@Override
	protected void init() {
		// 默认的字符编码
		encoding = getFilterConfig().getServletContext().getInitParameter(
				"encoding");
	}

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String charset = getFilterConfig().getInitParameter("charset");
		if(charset == null) {
			charset = encoding;
		}
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);

		CharacterEncodingRequest requestWrapper = new CharacterEncodingRequest(
				request);
		filterChain.doFilter(requestWrapper, response);
	}

}
