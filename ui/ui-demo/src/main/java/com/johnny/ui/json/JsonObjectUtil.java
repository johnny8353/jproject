package com.johnny.ui.json;

import net.sf.json.JSONObject;


/**
 * 类 编 号：
 * 类 名 称：TestJsonObject
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class JsonObjectUtil {
	  /**
     * 将对象序列化成json字符串
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj){
        JSONObject jsonObject=JSONObject.fromObject(obj);
        return jsonObject.toString();
    }
    
    /**
     * 将json字符串反序列化为对象
     * @param jsonStr
     * @param objClass 反序列化为该类的对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        return (T)JSONObject.toBean(JSONObject.fromObject(jsonStr), objClass);
    }
}
