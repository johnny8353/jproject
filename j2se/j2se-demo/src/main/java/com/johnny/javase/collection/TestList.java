package com.johnny.javase.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestList
 * 内容摘要：List中常用的集合对象包括：ArrayList、Vector和LinkedList，其中前两者是基于数组来进行存储，后者是基于链表进行存储。其中Vector是线程安全的，其余两个不是线程安全的。
 * ArrayList 例子见TestCollection
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestList {
	/**
	 * 业务描述：
	 * 编码作者:JohnnyHuang 黄福强
	 * 完成日期:2016年8月4日
	 * @param 
	 * @return void
	 */
	@Test
	public void vectorTest1()
	{
	    List<Integer> list = new Vector<Integer>();
	    for (int i = 0 ; i < 5; i++)
	    {
	        list.add(new Integer(100));
	    }
	    list.add(null);
	    System.out.println("size of vector is " + list.size());
	    System.out.println(list);
	}
	@Test
	public void vectorTest2()
	{
	    Vector<Integer> list = new Vector<Integer>();
	    Random r = new Random();
	    for (int i = 0 ; i < 10; i++)
	    {
	        list.add(new Integer(r.nextInt(100)));
	    }
	    System.out.println("size of vector is " + list.size());
	    System.out.println(list);
	    System.out.println(list.firstElement());
	    System.out.println(list.lastElement());
	    System.out.println(list.subList(3, 8));
	    List<Integer> temp = new ArrayList<Integer>();
	    for(int i = 4; i < 7; i++)
	    {
	        temp.add(list.get(i));
	    }
	    list.retainAll(temp);
	    System.out.println("size of vector is " + list.size());
	    System.out.println(list);
	}
	
	//这里列出了LinkedList常用的各个方法，从方法名可以看出，LinkedList也可以用来实现栈和队列。
	@Test
	public void linkedListTest1()
	{
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    Random r = new Random();
	    for (int i = 0 ; i < 10; i++)
	    {
	        list.add(new Integer(r.nextInt(100)));
	    }
	    list.add(null);
	    System.out.println("size of linked list is " + list.size());
	    System.out.println(list);
	    System.out.println(list.element());
	    System.out.println(list.getFirst());
	    System.out.println(list.getLast());
	    System.out.println(list.peek());
	    System.out.println(list.peekFirst());
	    System.out.println(list.peekLast());
	    System.out.println(list.poll());
	    System.out.println(list.pollFirst());
	    System.out.println(list.pollLast());
	    System.out.println(list.pop());
	    list.push(new Integer(100));
	    System.out.println("size of linked list is " + list.size());
	    System.out.println(list);
	}

}
