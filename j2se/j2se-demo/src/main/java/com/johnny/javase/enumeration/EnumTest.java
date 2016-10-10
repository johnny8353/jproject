package com.johnny.javase.enumeration;

/**
 * 类 编 号：
 * 类 名 称：EnumTest
 * 内容摘要：可以把 enum 看成是一个普通的 class，它们都可以定义一些属性和方法，
 * 不同之处是：enum 不能使用 extends 关键字继承其他类，因为 enum 已经继承了 java.lang.Enum（java是单一继承）。
 * 完成日期：2016年8月3日
 * 编码作者：JohnnyHuang 黄福强
 */
public enum EnumTest {
	//枚举类的所有实例必须在枚举类中显式列出(, 分隔    ; 结尾). 列出的实例系统会自动添加 public static final 修饰
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6);

	private int value;

	private EnumTest(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
