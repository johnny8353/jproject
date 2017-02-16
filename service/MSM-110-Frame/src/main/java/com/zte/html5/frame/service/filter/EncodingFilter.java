package com.zte.html5.frame.service.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符集过滤器
 * @author 10027909
 *
 */
public class EncodingFilter implements Filter
{
    //web.xml中配置的缺省编码
    protected String encoding = null;
    
    //是否忽略请求中包含的编码、强制使用指定的编码格式
    protected boolean ignore = true;

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
        this.encoding = null;
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
        if(ignore || (request.getCharacterEncoding() == null))
        {
            if(null != encoding)
            {
                request.setCharacterEncoding(encoding);
            }
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
        this.encoding = filterConfig.getInitParameter("encoding");
        String value = filterConfig.getInitParameter("forceEncoding");
        if(value == null)
        {
            this.ignore = true;
        }
        else if(value.equalsIgnoreCase("true"))
        {
            this.ignore = true;
        }
        else if(value.equalsIgnoreCase("yes"))
        {
            this.ignore = true;
        }
        else
        {
            this.ignore = false;
        }
    }
}
