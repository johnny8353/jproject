package com.johnny.javase.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestCollectionToArray
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestCollectionToArray {
	// 集合转数组
	@Test
	public void TestCollectionToArray() {
		/*
		 * (1)数组是大小固定的，并且同一个数组只能存放类型一样的数据（基本类型/引用类型） (2)JAVA集合可以存储和操作数目不固定的一组数据。
		 * (3)若程序时不知道究竟需要多少对象，需要在空间不足时自动扩增容量，则需要使用容器类库，array不适用。
		 * 
		 * 联系：使用相应的toArray()和Arrays.asList()方法可以回想转换。
		 */

		// 转化为Object[]类型数组
		List<String> list = new ArrayList<String>();
		list.add("johnny");
		list.add("huang");

		Object[] listArray = list.toArray();
		System.out.println(Arrays.toString(listArray));

		Set<String> set = new HashSet<String>();
		set.add("AAA");
		set.add("BBB");
		Object[] setArray = set.toArray();
		System.out.println(Arrays.toString(setArray));

		Map<String, String> map = new TreeMap<String, String>();
		map.put("Jerry", "10000");
		map.put("shellway", "20000");
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		Object[] mapArray = mapSet.toArray();
		System.out.println(Arrays.toString(mapArray));

	}

}
