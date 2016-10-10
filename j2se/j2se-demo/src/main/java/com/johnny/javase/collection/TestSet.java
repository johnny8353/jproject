package com.johnny.javase.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestSet
 * 内容摘要：Set可以大致分为两类：不排序Set和排序Set，不排序Set包括HashSet和LinkedHashSet，排序Set主要指TreeSet。其中HashSet和LinkedHashSet可以包含null。
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestSet {
	@Test
	public void hashSetTest1()
	{
	    Set<Integer> set = new HashSet<Integer>();
	    
	    for (int i = 0; i < 3; i++)
	    {
	        set.add(new Integer(100));
	    }
	    set.add(null);
	    
	    System.out.println("size of set is " + set.size());
	    System.out.println(set);
	}
	@Test
	public  void hashSetTest2()
	{
	    Set<MyInteger> set = new HashSet<MyInteger>();
	    
	    for (int i = 0; i < 3; i++)
	    {
	        set.add(new MyInteger(100));
	    }
	    
	    System.out.println("size of set is " + set.size());
	    System.out.println(set);
	}
	
	@Test
	public  void treeSetTest1()
	{
	    TreeSet<Integer> set = new TreeSet<Integer>();
	    
	    Random r = new Random();
	    for (int i = 0 ; i < 5; i++)
	    {
	        set.add(new Integer(r.nextInt(100)));
	    }

	    System.out.println(set);
	    System.out.println(set.first());
	    System.out.println(set.last());
	    System.out.println(set.descendingSet());
	    System.out.println(set.headSet(new Integer(50)));
	    System.out.println(set.tailSet(new Integer(50)));
	    System.out.println(set.subSet(30, 60));
	    System.out.println(set.floor(50));
	    System.out.println(set.ceiling(50));
	}
	//TreeSet中的元素，一般都实现了Comparable接口，默认情况下，对于Integer来说，SortedList是采用升序来存储的，我们也可以自定义Compare方式，例如以降序的方式来存储。
	@Test
	public void treeSetTest2()
	{
	    TreeSet<Integer> set1 = new TreeSet<Integer>();
	    TreeSet<MyInteger2> set2 = new TreeSet<MyInteger2>();
	    Random r = new Random();
	    for (int i = 0 ; i < 5; i++)
	    {
	        int value = r.nextInt(100);
	        set1.add(new Integer(value));
	        set2.add(new MyInteger2(value));
	    }
	    System.out.println("Set1 as below:");
	    System.out.println(set1);
	    System.out.println("Set2 as below:");
	    System.out.println(set2);
	}
}
