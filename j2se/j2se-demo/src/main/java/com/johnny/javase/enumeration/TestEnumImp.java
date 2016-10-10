package com.johnny.javase.enumeration;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestEnum
 * 内容摘要： 可以把 enum 看成是一个普通的 class，它们都可以定义一些属性和方法，
 * 不同之处是：enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了 java.lang.Enum（java是单一继承）。
 * 完成日期：2016年8月3日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestEnumImp {
	
	//遍历、switch 等常用操作
	@Test
	public void test1() {
		for (EnumImp e : EnumImp.values()) {
			System.out.println(e.toString());
		}

		System.out.println("----------------我是分隔线------------------");

	}

}
