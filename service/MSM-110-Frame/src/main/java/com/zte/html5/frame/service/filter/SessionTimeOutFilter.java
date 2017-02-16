package com.zte.html5.frame.service.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.opensymphony.xwork2.ActionContext;

/**
 * 判断用户是否未登陆,或者SESSION是否已过期
 * 可以配置不做SESSION判断的URL,登陆相关的页面,不需要使用这个过滤器判断
 * 如果未登陆或者过期,直接跳转到登陆页面
 * @author 10027909
 *
 */
public class SessionTimeOutFilter implements Filter
{
    /**
     * The default character encoding to set for requests that pass through
     * this filter.
     */
	//不需要检查的URL路径,多份路径使用逗号分隔
    protected String[] exceptiveURLs = null;
    //SESSION过期URL,可以是提示页面,也可以直接配置登陆页面
    protected String sessionTimeOutURL = null;
    //判断SESSION过期的SESSION值名称
    protected String sessionValueName = null;

    /**
     * The filter configuration object we are associated with.  If this value
     * is null, this filter instance is not currently configured.
     */
    protected FilterConfig filterConfig = null;


    /**
     * Take this filter out of service.
     */
    public void destroy()
    {
        this.exceptiveURLs = null;
        this.sessionTimeOutURL = null;
        this.filterConfig = null;
    }

    /**
     * Select and set (if specified) the character encoding to be used to
     * interpret request parameters for this request.
     *
     * @param request The servlet request we are processing
     * @param result The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException
    {
    	HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse servletResponse = (HttpServletResponse)response;
        HttpSession session = servletRequest.getSession();
        String url = servletRequest.getRequestURI();
        
        boolean needcheck = true;
        
        Object loginvalue = session.getAttribute(sessionValueName);
        //优先判断SESSION是否有值,这个判断快些
        if(loginvalue != null){     	
        	needcheck = false;
        }
        
        //比较当前URL,判断是否需要做SESSION检查
        if(needcheck && exceptiveURLs != null && url != null){
        	//取消URL中的应用前缀
        	url = url.substring(servletRequest.getContextPath().length());
        	
        	for(String tempurl:exceptiveURLs){
        		if(url.startsWith(tempurl)){
        			needcheck = false;
        			break;
        		}
        	}
        }

        //System.out.println("url=" + url);
        //System.out.println("loginvalue=" + loginvalue);
        if(needcheck && loginvalue == null){     	
        	//未登陆或则SESSION过期,则跳转到指定页面
        	request.getRequestDispatcher(sessionTimeOutURL).forward(request, response); 
        	//servletResponse.sendRedirect(((HttpServletRequest)request).getContextPath() + sessionTimeOutURL);
        }
        else{
	        // Pass control on to the next filter
	        chain.doFilter(request, response);
        }

    }

    /**
     * Place this filter into service.
     *
     * @param filterConfig The filter configuration object
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
        
        String tempSessionTimeOutURL = filterConfig.getInitParameter("sessionTimeOutURL");
        if(tempSessionTimeOutURL != null){
        	this.sessionTimeOutURL = tempSessionTimeOutURL.trim();
        }
        
        String tempSessionValueName = filterConfig.getInitParameter("sessionValueName");
        if(tempSessionValueName != null){
        	this.sessionValueName = tempSessionValueName.trim();
        }
        
        String tempExceptivURL = filterConfig.getInitParameter("exceptiveURLs");
        if(tempExceptivURL != null && tempExceptivURL.trim().length()>0){
        	this.exceptiveURLs = tempExceptivURL.trim().split(",");
        }
    }

}
