package com.zte.html5.frame.util;

import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zte.html5.frame.common.ServiceData;

/**
 * Http访问工具类
 * @author 10081683
 * @version 1.0
 * 创建时间: 2016-11-7 
 */
@SuppressWarnings("deprecation")
public class HttpClientUtil {		
		//是否令牌验证的HTTP头
		private static final String HTTP_HEADER_X_ORG_ID = "X-Org-Id";
		//存放令牌数据验证的HTTP头
		private static final String HTTP_HEADER_X_AUTH_VALUE = "X-Auth-Value";
		 //存放多语言ID的HTTP头
		private static final String HTTP_HEADER_X_LANG_ID = "X-Lang-Id";
		
		/**
		 * 封装的HttpPost请求方法，支持传token头文件
		 * @param request 请求类
		 * @param url 请求服务地址
		 * @param parameters 请求参数
		 * @return ServiceData 请求返回对象
		 */
		public static  ServiceData httpPostUrl(HttpServletRequest request, String url, String parameters) {
			ServiceData serviceData = new ServiceData();
			
			if (url != null && !url.equals("")){
				@SuppressWarnings("resource")
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				try {
					// 建立一个NameValuePair数组，用于存储欲传送的参数  
					httpPost.addHeader("Content-type","application/json; charset=utf-8");  
					httpPost.setHeader("Accept", "application/json");
					httpPost.setHeader(HTTP_HEADER_X_AUTH_VALUE, request.getHeader(HTTP_HEADER_X_AUTH_VALUE));
					httpPost.setHeader(HTTP_HEADER_X_ORG_ID, request.getHeader(HTTP_HEADER_X_ORG_ID));	
					httpPost.setHeader(HTTP_HEADER_X_LANG_ID, request.getHeader(HTTP_HEADER_X_LANG_ID));
					
					if (parameters != null && !parameters.equals("")){
						httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8"))); 
					}
					
					HttpResponse response = httpClient.execute(httpPost);
					int statusCode = response.getStatusLine().getStatusCode();  
					
					if (statusCode != HttpStatus.SC_OK) {
						serviceData.setCode(request, ServiceData.RetCode.ServerError);
					} else {
						serviceData.setCode(request, ServiceData.RetCode.Success);
						String body = EntityUtils.toString(response.getEntity());
						ObjectMapper objectMapper = new ObjectMapper();
						JsonNode rootNode = objectMapper.readTree(body);
						String  reCode = rootNode.path("code").get("msgId").textValue().replace("RetCode.", "");
						JsonNode boNode = rootNode.path("bo");
						JsonNode otherNode = rootNode.path("other");
						
						serviceData.setCode(request, Enum.valueOf(ServiceData.RetCode.class, reCode));				
						
						// 业务对象通过JSON字符串形式返回
						if (boNode != null) {
							serviceData.setBo(boNode.toString());
						}
						
						if (otherNode != null && !otherNode.toString().equals("")) {
							serviceData.setOther(objectMapper.readValue(otherNode.toString(), HashMap.class));
						}											
					}				
				} catch (Exception ex) {
					serviceData.setCode(request, ServiceData.RetCode.ServerError);
				} finally {
					httpPost.abort();
				}
			}
			
			return serviceData;
		}
		
		/*
		 httpPostUrl使用说明：
		 建议在Controller层中调用，如果需要token校验，请确保token在界面ajax请求时有值。
		 以下是通过用户ID调用服务获取用户对象的例子：
		 ObjectMapper objectMapper = new ObjectMapper();
		 ServiceData ret = new ServiceData();
		 User user = new User();
		 user.setId(110l);
	     String userString = objectMapper.writeValueAsString(user);
	     String url = "http://localhost:8080/newframe/sysman/User/get.serv";
	     if (ret.getCode() == ServiceData.RetCode.Success){
		     String reJsonString  = ret.getBo().toString();
		     user = objectMapper.readValue(reJsonString, User.class);
	     }
	     String reJsonString  = ret.getBo().toString();
	     user = objectMapper.readValue(reJsonString, User.class);
		 */
}
