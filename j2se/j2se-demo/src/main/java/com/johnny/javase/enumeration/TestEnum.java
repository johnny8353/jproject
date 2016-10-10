package com.johnny.javase.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestEnum
 * 内容摘要： 可以把 enum 看成是一个普通的 class，它们都可以定义一些属性和方法，
 * 不同之处是：enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了 java.lang.Enum（java是单一继承）。
 * 完成日期：2016年8月3日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestEnum {
	
	//遍历、switch 等常用操作
	@Test
	public void test1() {
		for (EnumTest e : EnumTest.values()) {
			System.out.println(e.toString());
		}

		System.out.println("----------------我是分隔线------------------");

		EnumTest test = EnumTest.TUE;
		switch (test) {
			case MON:
				System.out.println("今天是星期一");
				break;
			case TUE:
				System.out.println("今天是星期二");
				break;
			default:
				System.out.println(test);
				break;
		}
	}

	// enum常用方法
	@Test
	public void test2() {
		EnumTest test = EnumTest.TUE;

		// compareTo(E o)
		switch (test.compareTo(EnumTest.MON)) {
			case -1:
				System.out.println("TUE 在 MON 之前");
				break;
			case 1:
				System.out.println("TUE 在 MON 之后");
				break;
			default:
				System.out.println("TUE 与 MON 在同一位置");
				break;
		}

		// getDeclaringClass()
		System.out.println("getDeclaringClass(): "
				+ test.getDeclaringClass().getName());

		// name() 和 toString()
		System.out.println("name(): " + test.name());
		System.out.println("toString(): " + test.toString());

		// ordinal()， 返回值是从 0 开始
		System.out.println("ordinal(): " + test.ordinal());
	}
	
	//给 enum 自定义属性和方法
	@Test
	public void test3() {
		//给 enum 对象加一下 value 的属性和 getValue() 的方法：
		System.out.println("EnumTest.FRI 的 value = " + EnumTest.FRI.getValue());
	}
	
	//EnumSet，EnumMap 的应用
	@Test
	public void test4() {
		 // EnumSet的使用
        EnumSet<EnumTest> weekSet = EnumSet.allOf(EnumTest.class);
        for (EnumTest day : weekSet) {
            System.out.println(day);
        }
 
        // EnumMap的使用
        EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
        weekMap.put(EnumTest.MON, "星期一");
        weekMap.put(EnumTest.TUE, "星期二");
        // ... ...
        for (Iterator<Entry<EnumTest, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Entry<EnumTest, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
	}

}
