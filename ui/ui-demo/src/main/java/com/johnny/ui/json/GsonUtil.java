package com.johnny.ui.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/**
 * 类 编 号：
 * 类 名 称：TestJsonObject
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */

public class GsonUtil{
	public static String bean2Json(Object obj){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }
    
    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonStr, objClass);
    }
    
    /**
     * 把混乱的json字符串整理成缩进的json字符串
     * @param uglyJsonStr
     * @return
     */
    public static String jsonFormatter(String uglyJsonStr){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonStr);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
}