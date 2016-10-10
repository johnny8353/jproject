package com.johnny.javaweb.junit;

/**
 * 类 编 号：
 * 类 名 称：Calculator
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
public class Calculator {

	private static int result; // 静态变量，用于存储运行结果        

	public void add(int n) {
		result = result + n;
	}

	public void substract(int n) {
		result = result - 1; // Bug: 正确的应该是 result =result-n
	}

	public void multiply(int n) {
	} // 此方法尚未写好

	public void divide(int n) {
		result = result / n;
	}

	public void square(int n) {
		result = n * n;
	}

	public void squareRoot(int n) {
		for (;;)
			; // Bug : 死循环
	}

	public void clear() { // 将结果清零
		result = 0;
	}

	public int getResult() {
		return result;
	}

}
