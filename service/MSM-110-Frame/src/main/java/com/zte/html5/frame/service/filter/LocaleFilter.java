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
 * 国际化过滤器,设置local,用户未选择则使用用户自定义配置语言
 * @author 10027909
 *
 */
public class LocaleFilter implements Filter
{
    /**
     * The default character encoding to set for requests that pass through
     * this filter.
     */
    protected String defaultLocale = null;
    protected String localeParamName = null;

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
        this.defaultLocale = null;
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
        Object sessionlocale = session.getAttribute("WW_TRANS_I18N_LOCALE");
        Object reqlocale = servletRequest.getParameter("soc_locale");
        String url = servletRequest.getRequestURI();
    	
        if(reqlocale != null && ((String)reqlocale).length()>0 ){
        	//用户设置多语言环境
        	Locale local = Locale.CHINA;
        	if(((String)reqlocale).startsWith("en_")){
        		//ActionContext.getContext().setLocale(Locale.US);
        		local = Locale.US;
        		//session.
        	}
        	else if(((String)reqlocale).startsWith("zh_")){
        		local = Locale.CHINA;
        	}
        	
        	//设置structs2国际化
        	//JSP页面上,可以用这样的标签来判断是什么语言
        	//<s:if test="#session.WW_TRANS_I18N_LOCALE.language eq 'zh'">中文</s:if><s:else>英文</s:else>
        	session.setAttribute("WW_TRANS_I18N_LOCALE",local);
        	session.setAttribute("LoginLanguage", local.getLanguage());
        	
        	//servletRequest.setAttribute("request_locale", local.getLanguage());
        	
        }
        else if(sessionlocale == null)
        {
    		//用户没有设置多语言,且当前请求中没有多语言请求参数
            //这时候应该根据用户的国际或者用户指定的常用语言设置LOCAL
        	
        	Locale local = Locale.CHINA;
        	session.setAttribute("WW_TRANS_I18N_LOCALE",local);
        	session.setAttribute("LoginLanguage", local.getLanguage());
        	
        	//servletRequest.setAttribute("request_locale", local.getLanguage());
           
        }
        
        
        //System.out.println("reqlocale=" + reqlocale);
        //System.out.println("sessionlocale=" + session.getAttribute("WW_TRANS_I18N_LOCALE"));
        //System.out.println("ActionContext.getContext().getLocale()=" + ActionContext.getContext().getLocale()); 
        
        //为修复安全漏洞,把structs升级到2.3.4
        //但是2.3.4处理Locale的方式和早期的版本不同,structs过滤器及标签,直接取Request中的Locale
        //所以将请求对象再做一个包装,重写了getLocale方法,以session中的值优先 .
        SOCHttpServletRequestWrapper socrequest = new SOCHttpServletRequestWrapper(servletRequest);
        
        // Pass control on to the next filter
        chain.doFilter(socrequest, response);

    }

    /**
     * Place this filter into service.
     *
     * @param filterConfig The filter configuration object
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {

        this.filterConfig = filterConfig;
        this.defaultLocale = filterConfig.getInitParameter("defaultLocal");
        this.localeParamName = filterConfig.getInitParameter("localeParamName");
        

    }

}
