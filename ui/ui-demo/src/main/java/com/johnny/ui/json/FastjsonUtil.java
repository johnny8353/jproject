package com.johnny.ui.json;

import com.alibaba.fastjson.JSON;


/**
 * 类 编 号：
 * 类 名 称：TestJsonObject
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */

public class FastjsonUtil{
    public static String bean2Json(Object obj){
        return JSON.toJSONString(obj);
    }
    
    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        return JSON.parseObject(jsonStr, objClass);
    }
}
