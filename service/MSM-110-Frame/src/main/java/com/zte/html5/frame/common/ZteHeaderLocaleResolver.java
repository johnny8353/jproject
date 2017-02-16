package com.zte.html5.frame.common;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


public class ZteHeaderLocaleResolver implements LocaleResolver {
	
	//日志对象
	private static final Logger log = Logger.getLogger(ZteHeaderLocaleResolver.class);
		
    private Locale locale = null;

    public Locale resolveLocale(HttpServletRequest request) {
		String langId = request.getHeader("X-Lang-Id");
		if("en".equalsIgnoreCase(langId) || "1033".equalsIgnoreCase(langId)){
			this.locale = new Locale("en","US");
		}
		else{
			//缺省设置为中文
			this.locale = new Locale("zh","CN");
		}
    	
    	//log.info("ZteHeaderLocaleResolver 获取LOCALE:" + this.locale.toString());
    	
        return this.locale;
    } 

    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    	this.locale = locale;
    }
  
}
