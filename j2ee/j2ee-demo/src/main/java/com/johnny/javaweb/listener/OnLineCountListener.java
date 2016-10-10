package com.johnny.javaweb.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 类 编 号：
 * 类 名 称：OnLineCountListener
 * 内容摘要：统计当前在线用户个数
 * 完成日期：2016年7月25日
 * 编码作者：JohnnyHuang 黄福强
 */
public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
        	onLineCount = 1;
            context.setAttribute("onLineCount", onLineCount);
        }else{
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
        System.out.println("在线人数："+ onLineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
        	onLineCount = 0;
            context.setAttribute("onLineCount", onLineCount);
        }else{
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
        System.out.println("在线人数：" + onLineCount);
    }
}