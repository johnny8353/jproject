package com.johnny.javaweb.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

    /**
     * 存储数据
     */
    private Object items;
    
    /**
     * 迭代集合时使用的变量
     */
    private String var;
    
    /**
     * 集合，用于存储items中的数据
     */
    private Collection collection;

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        //迭代collection集合
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            //得到一个迭代出来的对象
            Object object = (Object) it.next();
            //将迭代出来的对象存放到pageContext对象中
            pageContext.setAttribute(var, object);
            //输出标签体中的内容
            this.getJspBody().invoke(null);
        }
    }

    public void setVar(String var) {
        this.var = var;
    }
    
    public void setItems(Object items) {
        if (items instanceof Collection) {
            collection = (Collection) items;//list
        }else if (items instanceof Map) {
            Map map = (Map) items;
            collection = map.entrySet();//map
        }else if (items.getClass().isArray()) {
            collection = new ArrayList();
            //获取数组的长度
            int len = Array.getLength(items);
            for (int i = 0; i < len; i++) {
                //获取数组元素
                Object object = Array.get(items, i);
                collection.add(object);
            }
        }
        this.items = items;
    }
}