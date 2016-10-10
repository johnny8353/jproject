package cn.itcast.ssh.utils;

import org.apache.struts2.ServletActionContext;

import cn.itcast.ssh.domain.Employee;

public class SessionContext {

	public static final String GLOBLE_USER_SESSION = "globle_user";
	
	public static void setUser(Employee user){
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute(GLOBLE_USER_SESSION, user);
		}else{
			ServletActionContext.getRequest().getSession().removeAttribute(GLOBLE_USER_SESSION);
		}
	}
	
	public static Employee get(){
		return (Employee) ServletActionContext.getRequest().getSession().getAttribute(GLOBLE_USER_SESSION);
	}
}
