/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zte.html5.frame.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.log4j.Logger;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.test.student.StudentController;

import cn.com.zte.crypto.encdec.impl.CryptoAes;

/**
 * 请求加解密处理过滤器,根据HTTP头中的标志,自动处理传输数据的加解密.
 * @author Administrator
 *
 */
public class HttpCryptoFilter implements Filter {

	//日志对象
	private static final Logger log = Logger.getLogger(HttpCryptoFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		response.setHeader("Access-Control-Allow-Origin", "*");	
		response.setHeader("Access-Control-Allow-Headers", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified,X-Crypto-Flag,X-Crypto-Flag,X-Crypto-Algo,X-Crypto-Channel-Hash,X-Auth-Flag,X-Auth-Value,X-Lang-Id,X-Org-Id");	
		response.setHeader("Access-Control-Expose-Headers", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified,X-Crypto-Flag,X-Crypto-Flag,X-Crypto-Algo,X-Crypto-Channel-Hash,X-Auth-Flag,X-Auth-Value,X-Lang-Id,X-Org-Id");
		
		response.setCharacterEncoding("UTF-8");
		
		//检查请求对象中,是否是加密的JSON数据
		//if(isJsonContentType(request) && "true".equalsIgnoreCase(request.getHeader("encryptdata"))){
		//if(isJsonContentType(request) && "Y".equalsIgnoreCase(request.getHeader("X-Crypto-Flag"))){
		if("Y".equalsIgnoreCase(request.getHeader("X-Crypto-Flag"))){
			//设置返回对象的头
			//response.setHeader("Access-Control-Allow-Origin", "*");	
			//response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");	
			//response.setHeader("Access-Control-Allow-Headers", "x-requested-with");	
			//response.setHeader("Access-Control-Expose-Headers", "x-requested-with");
			response.addHeader("X-Crypto-Flag", "Y");
			response.addHeader("X-Crypto-Algo", "aes");
			//response.setContentType("text/html");
			
			//取出请求数据
			InputStream inputStream = request.getInputStream();
			String reqdata = StreamUtils.copyToString(inputStream, Charset.forName("utf-8"));
			inputStream.close();
			log.info("HttpContentFilter获取到请求数据:"+reqdata);
			
			//解密数据
			CryptoAes crypto = new CryptoAes();
			reqdata = crypto.decrypt(reqdata, "#16xjpxfy9k8cj^*");
			log.info("解密后的请求数据:"+reqdata);
			//reqdata = "{\"id\":\"111\",\"name\":\"222\"}";
			//包装为新的请求对象
			HttpServletRequest requestWrapper = new HttpContentRequestWrapper(request, reqdata);
			
			
			//创建新的response包装对象
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			HttpServletResponse responseWrapper = new HttpContentResponseWrapper(response, byteArrayOutputStream);
			
			//将包装对象提交结结后续处理链
			filterChain.doFilter(requestWrapper, responseWrapper);
			
			//重新设置返回的消息类型和消息头,SPRING mvc设置为JSON类型,
			//内容修改为加密字符串后,类型也要修改为text/html,防止angularjs自动根据类型转换数据
			response.setContentType("text/plain");
			//response.setCharacterEncoding("UTF-8");
			
			//处理完成,获取response包装对象中的JSON数据,根据需要加密
			String resdata = byteArrayOutputStream.toString("utf-8");
			byteArrayOutputStream.close();
			log.info("HttpContentFilter获取到返回数据:"+resdata);
			
			//加密数据
			resdata = crypto.encrypt(resdata, "#16xjpxfy9k8cj^*");
			//resdata = "{\"encrypt\":\""+resdata.replaceAll("\"", "\\\"")+"\"}";
			//加密内容有换行等特殊符号,需要做下编码再传输
			//resdata = java.net.URLEncoder.encode(resdata, "utf-8");
			//如果是SUN BASE64工具类做的BASE64编码,则替换掉回车换行符号
			//resdata = resdata.replaceAll("\r\n", "");
			log.info("HttpContentFilter加密后的返回数据:"+resdata);
			
			
			//将加密数据写到原始的response对象中,返回客户端
			OutputStream outputStream = response.getOutputStream();
			StreamUtils.copy(resdata, Charset.forName("utf-8"), outputStream);
			//StreamUtils.copy(resdata, Charset.forName("US-ASCII"), outputStream);
			outputStream.close();
			
		}
		else{
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	private boolean isJsonContentType(HttpServletRequest request) {
		String contentType = request.getContentType();
		if (contentType != null) {
			try {
				MediaType mediaType = MediaType.parseMediaType(contentType);
				return (MediaType.APPLICATION_JSON.includes(mediaType));
			}
			catch (IllegalArgumentException ex) {
				return false;
			}
		}
		else {
			return false;
		}
	}

	private static class HttpContentRequestWrapper extends HttpServletRequestWrapper {

		private String data;

		public HttpContentRequestWrapper(HttpServletRequest request, String data) {
			super(request);
			this.data = data;
		}

		@Override
		public ServletInputStream getInputStream() {
			
			ServletInputStream servletInputStream = null;
			
			try{
				servletInputStream = new DelegatingServletInputStream(new ByteArrayInputStream(data.getBytes("UTF-8")));
			}
			catch(Exception ex){
				ex.printStackTrace();
			}

			return servletInputStream;
		}

	}
	
	private static class HttpContentResponseWrapper extends HttpServletResponseWrapper {

		private ByteArrayOutputStream outputStream;

		public HttpContentResponseWrapper(HttpServletResponse response, ByteArrayOutputStream outputStream) {
			super(response);
			this.outputStream = outputStream;
		}

		@Override
		public ServletOutputStream getOutputStream() {
			
			ServletOutputStream servletOutputStream = null;
			
			try{
				servletOutputStream = new DelegatingServletOutputStream(outputStream);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}

			return servletOutputStream;
		}

	}
	
	private static class DelegatingServletInputStream extends ServletInputStream {

	    private final InputStream sourceStream;


	    /**
	     * Create a DelegatingServletInputStream for the given source stream.
	     * @param sourceStream the source stream (never <code>null</code>)
	     */
	    public DelegatingServletInputStream(InputStream sourceStream) {
	        this.sourceStream = sourceStream;
	    }

	    /**
	     * Return the underlying source stream (never <code>null</code>).
	     */
	    public final InputStream getSourceStream() {
	        return this.sourceStream;
	    }


	    public int read() throws IOException {
	        return this.sourceStream.read();
	    }

	    public void close() throws IOException {
	        super.close();
	        this.sourceStream.close();
	    }

		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setReadListener(ReadListener arg0) {
			// TODO Auto-generated method stub
			
		}

		

	}
	
	private static class DelegatingServletOutputStream extends ServletOutputStream {

	    private final OutputStream sourceStream;

	    /**
	     * Create a DelegatingServletInputStream for the given source stream.
	     * @param sourceStream the source stream (never <code>null</code>)
	     */
	    public DelegatingServletOutputStream(OutputStream sourceStream) {
	        this.sourceStream = sourceStream;
	    }

	    /**
	     * Return the underlying source stream (never <code>null</code>).
	     */
	    public final OutputStream getSourceStream() {
	        return this.sourceStream;
	    }

		@Override
		public void write(int b) throws IOException {
			// TODO Auto-generated method stub
			this.sourceStream.write(b);
		}

	    public void close() throws IOException {
	        super.close();
	        this.sourceStream.close();
	    }

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}
