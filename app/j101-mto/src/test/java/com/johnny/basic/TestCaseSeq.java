package com.johnny.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class TestCaseSeq extends TestCaseBase{
	@Before
	public void before() {
		System.out.println("-before-");
	}

	@After
	public void after() {
		System.out.println("-after-");
	}
	@Test
	public void test2(){
		System.out.println("-test2-");
	}
	@Test
	public void test1(){
		System.out.println("-test1-");
	}
	@Test
	public void test3(){
		System.out.println("-test3-");
	}
}
