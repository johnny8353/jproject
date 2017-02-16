package com.zte.html5.frame.service.filter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//为修复安全漏洞,把structs升级到2.3.4
//但是2.3.4处理Locale的方式和早期的版本不同,structs过滤器及标签,直接取Request中的Locale
//所以将请求对象再做一个包装,重写了getLocale方法,以session中的值优先 .
public class SOCHttpServletRequestWrapper extends HttpServletRequestWrapper{
	
	HttpServletRequest request = null;
	
	public SOCHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		
		this.request = request;
	}
	
	public Locale getLocale(){
		//先从SESSION中去Locale,没有才取request对象中的Locale
		Locale locale = null;
		
		try{
			Object obj = this.getSession().getAttribute("WW_TRANS_I18N_LOCALE");
	        if(obj != null){
	        	locale = (Locale)obj;
	        }
	        else{
	        	locale = request.getLocale();
	        }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return locale;
	}

}
