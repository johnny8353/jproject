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


/**
 * 处理登陆页面跳转为HTTPS的过滤器
 * @author 10027909
 *
 */
public class HttpsFilter implements Filter
{
    /**
     * The default character encoding to set for requests that pass through
     * this filter.
     */
	//是否起用强制HTTP登陆
    protected boolean useHttps = false;
	//需要使用HTTPS访问的URL
    protected String[] httpsURLs = null;
    
    protected int httpPort = 80;
    protected int httpsPort = 443;
   
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
        this.httpsURLs = null;
        this.useHttps = false;
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
        String url = servletRequest.getRequestURI();
        
        if(useHttps && url != null){  
        	String contextPath = servletRequest.getContextPath();
        	//取消URL中的应用前缀
        	url = url.substring(contextPath.length());
        	
        	//如果是HTTP,且需要强制使用HTTP,则跳转HTTPS
        	if("http".equals(request.getScheme())){
	        	boolean needredrect = false;
	        	for(String tempurl:httpsURLs){
	        		if(url.startsWith(tempurl)){
	        			needredrect = true;
	        			break;
	        		}
	        	}
	        	
	        	if(needredrect){
	        		String newurl = "https://" + servletRequest.getRemoteAddr() + ((httpsPort==443)?"":(":"+httpsPort)) + contextPath + url;
	        		//request.getRequestDispatcher(newurl).forward(request, response);
	        		servletResponse.sendRedirect(newurl);       		
	        	}
        	}      	
        	else if("https".equals(request.getScheme())){
        		//如果是HTTPs,且不是需要强制使用HTTPs的URL,则跳转到HTTP
	        	boolean needredrect = true;
	        	for(String tempurl:httpsURLs){
	        		if(url.startsWith(tempurl)){
	        			needredrect = false;
	        			break;
	        		}
	        	}
	        	
	        	if(needredrect){
	        		String newurl = "http://" + servletRequest.getRemoteAddr() + ((httpPort==80)?"":(":"+httpPort)) + contextPath + url;
	        		//request.getRequestDispatcher(newurl).forward(request, response);
	        		servletResponse.sendRedirect(newurl);     		
	        	}
        	}
        }
        
        chain.doFilter(request, response);

    }

    /**
     * Place this filter into service.
     *
     * @param filterConfig The filter configuration object
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
        
        String tempuseHttps = filterConfig.getInitParameter("useHttps");
        if(tempuseHttps != null && "true".equals(tempuseHttps)){
        	this.useHttps = true;
        }   
        
        String temphttpPort = filterConfig.getInitParameter("httpPort");
        if(temphttpPort != null){
        	this.httpPort = Integer.parseInt(temphttpPort);
        }   
        
        String temphttpsPort = filterConfig.getInitParameter("httpsPort");
        if(temphttpsPort != null){
        	this.httpsPort = Integer.parseInt(temphttpsPort);
        } 
        
        String temphttpsURLs = filterConfig.getInitParameter("httpsURLs");
        if(temphttpsURLs != null && temphttpsURLs.trim().length()>0){
        	this.httpsURLs = temphttpsURLs.trim().split(",");
        }
    }

}
