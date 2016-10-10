package com.johnny.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware,ApplicationAware{
	private String username;
	public String execute() {
		session.put("username", username);
		Integer count = (Integer) application.get("count");
		if(count==null) {
			count = 0;
		}
		count ++;
		application.put("count", count);
		return "login-success";
	}
	
	public String logout() {
		Integer count = (Integer) application.get("count");
		if(count>0) {
			count--;
		}
		application.put("count", count);
		if(session instanceof SessionMap){
			SessionMap sm = (SessionMap) session;
			sm.invalidate();
			System.out.println("session 失效了. ");
		}
		return "login-success";
	}
	
	private Map<String, Object> session;
	private Map<String, Object> application;
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
		
	}
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
