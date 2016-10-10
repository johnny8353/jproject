package com.johnny.javase.performance;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.johnny.javase.performance.collection.TestListPerformance;
import com.johnny.javase.performance.collection.TestMapPerformance;

/**
 * 类 编 号：
 * 类 名 称：TestPerformance
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestPerformance {
	@BeforeClass
	public static void before(){
		
	}

	@Test
	public void testList(){
		System.out.println("名称\t方法\t次数\t时间\t类");
		PerformanceVO performanceVO = new PerformanceVO(100000, "ArrayList", "java.util.ArrayList");
		PerformanceVO performanceVO2 = new PerformanceVO(100000, "LinkedList", "java.util.LinkedList");
		PerformanceVO performanceVO3 = new PerformanceVO(100000, "Vector	", "java.util.Vector");
		ArrayList<PerformanceVO> vos = new ArrayList<>();
		vos.add(performanceVO);
		vos.add(performanceVO2);
		vos.add(performanceVO3);
		for (PerformanceVO vo : vos) {
			Performance performance = (Performance) ProxyFactory.getProxyInstance(new TestListPerformance(vo));
			performance.add();
			performance.delete();
			performance.get();
		}
	}
	
	@Test
	public void testList2(){
		System.out.println("名称\t方法\t次数\t时间\t类");
		PerformanceVO performanceVO = new PerformanceVO(1000000, "ArrayList", "java.util.ArrayList");
		PerformanceVO performanceVO2 = new PerformanceVO(1000000, "LinkedList", "java.util.LinkedList");
		PerformanceVO performanceVO3 = new PerformanceVO(1000000, "Vector	", "java.util.Vector");
		ArrayList<PerformanceVO> vos = new ArrayList<>();
		vos.add(performanceVO);
		vos.add(performanceVO2);
		vos.add(performanceVO3);
		for (PerformanceVO vo : vos) {
			Performance performance = (Performance) ProxyFactory.getProxyInstance(new TestListPerformance(vo));
			performance.add();
			performance.delete();
			performance.get();
		}
	}
	
	@Test
	public void testMap(){
		System.out.println("名称\t方法\t次数\t时间\t类");
		PerformanceVO performanceVO = new PerformanceVO(100000, "HashMap	", "java.util.HashMap");
		PerformanceVO performanceVO2 = new PerformanceVO(100000, "TreeMap	", "java.util.TreeMap");
		PerformanceVO performanceVO3 = new PerformanceVO(100000, "Hashtable", "java.util.Hashtable");
		ArrayList<PerformanceVO> vos = new ArrayList<>();
		vos.add(performanceVO);
		vos.add(performanceVO2);
		vos.add(performanceVO3);
		for (PerformanceVO vo : vos) {
			Performance performance = (Performance) ProxyFactory.getProxyInstance(new TestMapPerformance(vo));
			performance.add();
			performance.update();
			performance.delete();
			performance.get();
		}
	}
	
	
}
