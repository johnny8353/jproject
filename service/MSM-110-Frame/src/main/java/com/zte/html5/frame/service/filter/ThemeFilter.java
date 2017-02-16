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
 * 主题样式过滤器,设置主题样式,用户未选择则使用用户自定义配置语言
 * @author 10027909
 *
 */
public class ThemeFilter implements Filter
{
    /**
     * The default character encoding to set for requests that pass through
     * this filter.
     */
    protected String defaultTheme = null;
    protected String themeParamName = null;

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
        this.defaultTheme = null;
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
        Object sessionTheme = session.getAttribute("SYSTEM_THEME");
        Object reqTheme = servletRequest.getParameter("soc_theme");
        String url = servletRequest.getRequestURI();
    	
        if(reqTheme != null && ((String)reqTheme).length()>0 ){
        	//用户设置主题样式
        	session.setAttribute("SYSTEM_THEME",(String)reqTheme);      	
        }
        else if(sessionTheme == null)
        {
    		//用户没有设置主题样式,且当前请求中没有主题样式请求参数
            //这时候应该根据用户的系统的默认常用主题样式设置
        	
        	session.setAttribute("SYSTEM_THEME",defaultTheme);
        	
        	//servletRequest.setAttribute("request_locale", local.getLanguage());
        }
        
        // Pass control on to the next filter
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
        this.defaultTheme = filterConfig.getInitParameter("defaultTheme");
        this.themeParamName = filterConfig.getInitParameter("themeParamName");
        

    }

}
