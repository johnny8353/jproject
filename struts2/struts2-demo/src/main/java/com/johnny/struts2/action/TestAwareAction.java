package com.johnny.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware, SessionAware, RequestAware,
	ParameterAware{
	//选用的建议: 若一个 Action 类中有多个 action 方法, 且多个方法都需要使用域对象的 Map 或 parameters, 则建议使用Aware 接口的方式
	public String execute(){
		
		//1. 向 application 中加入一个属性: applicationKey2 - applicationValue2
		application.put("applicationKey2", "applicationValue2");
		
		//2. 从 application 中读取一个属性 date, 并打印. 
		System.out.println(application.get("date"));
		
		return "success";
	}
	
	public String save(){
		
		return null;
	}

	private Map<String, Object> application;
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setParameters(Map<String, String[]> parameters) {
		
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	
}
