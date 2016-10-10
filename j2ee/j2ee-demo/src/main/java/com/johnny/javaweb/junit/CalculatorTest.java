package com.johnny.javaweb.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：CalculatorTest
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
public class CalculatorTest {

	private static Calculator calculator = new Calculator();

	@Before
	public void setUp() throws Exception {
		calculator.clear();

	}

	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5, calculator.getResult());
	}

	@Test
	public void testSubstract() {
		calculator.add(10);
		calculator.substract(2);
		assertEquals(8, calculator.getResult());

	}

	@Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		calculator.add(8);
		calculator.divide(2);
		assertEquals(4, calculator.getResult());

	}

	@Test(expected = ArithmeticException.class)
	public void divideByZero() {
		calculator.add(8);
		calculator.divide(0);
		assertEquals(4, calculator.getResult());
	}

}
