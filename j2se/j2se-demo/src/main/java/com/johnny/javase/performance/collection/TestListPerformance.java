package com.johnny.javase.performance.collection;

import java.util.List;

import com.johnny.javase.performance.Performance;
import com.johnny.javase.performance.PerformanceBase;
import com.johnny.javase.performance.PerformanceVO;

/**
 * 类 编 号：
 * 类 名 称：TestPerformance
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestListPerformance extends PerformanceBase implements Performance{
	private List<String> list;
	public TestListPerformance(PerformanceVO performanceVO){
		this.performanceVO  = performanceVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add() {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(performanceVO.getObject());
			list = (List<String>) clazz.newInstance();
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < performanceVO.getCount(); i++) {
			list.add(String.valueOf(i));
		}
	}
	
	@Override
	public void update() {
		
	}
	@Override
	public void delete() {
		for (int i = 0; i < 1000; i++) {
			list.remove(3);
		}
		
	}

	@Override
	public void get() {
		for (int i = 0; i < 1000; i++) {
			list.get(4);
		}
		
	}

}
