package com.johnny.basic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCaseBase {
	static long begin = 1L;
	static long end = 1L;
	@BeforeClass
	public static void beforeClass() {
		begin = System.currentTimeMillis();
	}

	@AfterClass
	public static void afterClass() {
		 end = System.currentTimeMillis();
		 System.out.println("本次花费的时间："+(end-begin));
	}
}
