package com.johnny.webservice.client.httpclient;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestHttpClient
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月9日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestHttpClient {
	@Test
	public void testPost(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample/postData";
		
		Map<String, String> maps = new HashMap<String, String>();
		
		String result = HttpClientUtil.getInstance().sendHttpPost(httpUrl, maps);
		
		System.out.println(result);
		
	}
	
	@Test
	public void testGet(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample";
		
		String result = HttpClientUtil.getInstance().sendHttpGet(httpUrl);
		
		System.out.println(result);
	}
	@Test
	public void testGet2(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample/request/234234";
		
		String result = HttpClientUtil.getInstance().sendHttpGet(httpUrl);
		
		System.out.println(result);
	}
	@Test
	public void testGet3(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample/bean/22";
		
		String result = HttpClientUtil.getInstance().sendHttpGet(httpUrl);
		
		System.out.println(result);
	}
	@Test
	public void testGet4(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample/list";
		
		String result = HttpClientUtil.getInstance().sendHttpGet(httpUrl);
		
		System.out.println(result);
	}
	@Test
	public void testGet5(){
		String httpUrl = "http://localhost:8077/cxf/webservice/rest/sample/map";
		
		String result = HttpClientUtil.getInstance().sendHttpGet(httpUrl);
		
		System.out.println(result);
	}
}
