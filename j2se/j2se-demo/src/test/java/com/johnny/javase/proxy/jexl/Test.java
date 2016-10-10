package com.johnny.javase.proxy.jexl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 类 编 号：
 * 类 名 称：Test
 * 内容摘要：使用commons的jexl可实现将字符串变成可执行代码的功能
 * 完成日期：2016年9月1日
 * 编码作者：JohnnyHuang 黄福强
 */
public class Test {
	@org.junit.Test
	public void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<String> list = new ArrayList<>();
		list.add("3");
		System.out.println(list.size());
		map.put("list", list);
		String expression = "list.size()";
		// String expression="System.out.println(1)";
		Object obj = DyMethodUtil.invokeMethod(expression, map);
		System.out.println(obj);
	}

	@org.junit.Test
	public void test2() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("money", 2100);
			String expression = "money>=2000&&money<=4000";
			Object code = DyMethodUtil.invokeMethod(expression, map);
			System.out.println(code);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void test3() {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("www".equalsIgnoreCase("WWW"));
		map.put("a", "www");
		map.put("b", "WWW");
		String expression = "a.equalsIgnoreCase(b)";
		Object obj = DyMethodUtil.invokeMethod(expression, map);
		System.out.println(obj);
	}
}
