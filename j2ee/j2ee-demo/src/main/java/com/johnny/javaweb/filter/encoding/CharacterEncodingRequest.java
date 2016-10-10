package com.johnny.javaweb.filter.encoding;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 1.实现与被增强对象相同的接口 
 * 2、定义一个变量记住被增强对象
 * 3、定义一个构造器，接收被增强对象
 * 4、覆盖需要增强的方法
 * 5、对于不想增强的方法，直接调用被增强对象（目标对象）的方法
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class CharacterEncodingRequest extends HttpServletRequestWrapper{
    
    private HttpServletRequest request;
    public CharacterEncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
    /* 重写getParameter方法
     * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String name) {
        
        try{
            //获取参数的值
            String value= this.request.getParameter(name);
            if(value==null){
                return null;
            }
            //如果不是以get方式提交数据的，就直接返回获取到的值
            if(!this.request.getMethod().equalsIgnoreCase("get")) {
                return value;
            }else{
                //如果是以get方式提交数据的，就对获取到的值进行转码处理
                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
                return value;
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}