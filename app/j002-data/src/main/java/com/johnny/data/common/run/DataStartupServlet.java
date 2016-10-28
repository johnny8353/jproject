package com.johnny.data.common.run;

import java.io.IOException;
import java.util.Map;

import javax.persistence.Cache;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnny.common.observer.CacheSubject;
import com.johnny.common.util.CommonUtil;
import com.johnny.data.access.vo.SystemPreferenceVO;
import com.johnny.data.business.service.SystemPreferenceService;
import com.johnny.data.common.data.SysDataDictionary;
import com.johnny.data.common.observer.SysPrefCacheObserver;

/**
 * 
 * 类 编 号：
 * 类 名 称：DataStartupServlet
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月27日
 * 编码作者：JohnnyHuang 黄福强
 */
public class DataStartupServlet  extends HttpServlet{
	/**
	 * 名 称： 编码作者：JohnnyHuang
	 */
	private static final long serialVersionUID = 1L;
	protected Log log = LogFactory.getLog(getClass());
	
	@Override
	public void init() throws ServletException {
		log.debug(this.getClass().getName() + "=====DataStartupServlet====start data init()");
		SysPrefCacheObserver observer = (SysPrefCacheObserver) CommonUtil.getBean("sysPrefCacheObserver");
		CacheSubject.CACHE_SUBJECT.addObserver(observer);
		CacheSubject.CACHE_SUBJECT.change();
		CacheSubject.CACHE_SUBJECT.notifyObservers(observer);
		log.debug(this.getClass().getName() + "=====DataStartupServlet====finish data init()");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		log.debug("=====DataStartupServlet====service()");
	}
	@Override
	public void destroy() {
		log.debug("=====DataStartupServlet====destroy()");
	}
	

}
