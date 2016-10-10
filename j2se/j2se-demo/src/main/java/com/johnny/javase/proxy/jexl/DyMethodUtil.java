package com.johnny.javase.proxy.jexl;

import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

/**
 * 类 编 号：
 * 类 名 称：DyMethodUtil
 * 内容摘要：使用commons的jexl可实现将字符串变成可执行代码的功能
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class DyMethodUtil {

	public static Object invokeMethod(String jexlExp,Map<String,Object> map){
		JexlEngine jexl=new JexlEngine();
		Expression e = jexl.createExpression(jexlExp);
		JexlContext jc = new MapContext();
		for(String key:map.keySet()){
			jc.set(key, map.get(key));
		}
		if(null==e.evaluate(jc)){
			return "";
		}
		return e.evaluate(jc);
	}
}
