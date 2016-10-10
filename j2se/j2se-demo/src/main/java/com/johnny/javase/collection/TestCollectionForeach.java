package com.johnny.javase.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestCollectionForeach
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestCollectionForeach {

	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		list.add("johnny");
		list.add("huang");
		// 方法1 - iterator while
		Iterator it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		// 方法2 - iterator for
		for (Iterator it2 = list.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}
		// 方法3 foreach
		for (String tmp : list) {
			System.out.println(tmp);
		}
		// 方法4 因为list有顺序，利用size()和get()方法获取
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}

	@Test
	public void testSet() {
		Set<String> set = new HashSet<String>();
		set.add("AAA");
		set.add("BBB");
		set.add("CCC");

		// 方法1 - iterator while
		Iterator<String> it1 = set.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		// 方法2 - iterator for
		for (Iterator<String> it2 = set.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}
		// 方法3 foreach
		for (String sss : set) {
			System.out.println(sss);
		}
	}

	@Test
	public void testMap() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Jerry", "10000");
		map.put("shellway", "20000");
		map.put("Kizi", "30000");

		// Map的第一种遍历方式：先获得key,再获得值value
		Set<String> sett = map.keySet();
		for (String s : sett) {
			System.out.println("1--:" + s + ":" + map.get(s));
		}
		// Map的第二种遍历方式：获得键值对
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("2--:" + entry.getKey() + " : "
					+ entry.getValue());
		}

		// 方法1 - iterator while
		Set<Map.Entry<String, String>> sets = map.entrySet();
		Iterator<Map.Entry<String, String>> it1 = sets.iterator();
		while (it1.hasNext()) {
			Map.Entry<String, String> entry = it1.next();
			System.out.println("3--:" + entry.getKey() + " : "
					+ entry.getValue());
		}
	}
	
	
}
