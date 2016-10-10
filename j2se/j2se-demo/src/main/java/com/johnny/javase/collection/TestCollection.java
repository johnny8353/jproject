package com.johnny.javase.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestCollection
 * 内容摘要：
		添加元素：add/addAll
		清空集合：clear
		删除元素：remove/removeAll
		判断集合中是否包含某元素：contains/containsAll
		判断集合是否为空：isEmpty
		计算集合中元素的个数：size
		将集合转换为数组：toArray
		获取迭代器：iterator
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestCollection {
	static Collection<Integer> collection;

	@BeforeClass
	public static void beforeClass() {
		collection = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			collection.add(new Integer(r.nextInt(100)));
		}
	}

	@Test
	public void test1() {
	    Iterator<Integer> iterator = collection.iterator();
	    System.out.println("The value in the list:");
	    while(iterator.hasNext())
	    {
	        System.out.println(iterator.next());
	    }
	    /*
	   	使用for可以节省空间
	    for (Iterator it = al.iterator(); it.hasNext();) {
	        if(it.next().equals("java03"))
	            it.remove();
	        }
	        System.out.println(al);
	    */
	}
	@Test
	public void test2() {
	    System.out.println("The value in the list:");
	    for(Integer value : collection)
	    {
	        System.out.println(value);
	    }
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void addDemo() {
		//添加元素 boolean add(Object);
		ArrayList a1 = new ArrayList();
	    a1.add("java01");
	    a1.add("java02");
	    a1.add("java03");
	    a1.add("java04");
	    System.out.println(a1);//可以直接打印集合
	    
	    Object[] o1 = a1.toArray();
	    for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
		}
	    
	    //判断某元素是否存在：boolean contains(Object)
	    boolean b = a1.contains("java03");
	    System.out.println("java03是否存在："+b);
	    
	    //获取集合中元素的个数：int size();
	    int a = a1.size();
	    System.out.println("size:"+a);
	    
	    //删除元素 boolean remove(Object); 返回的是boolean.(List集合下也可以通过指定的角标来删除某个对象，返回的是被删除的那个对象)
	    boolean b2 = a1.remove("java03");
	    System.out.println(a1);
	    System.out.println(b2);
	    
	    //清空元素：void clear();如果集合不支持该方法会抛出该异常：UnsupportedOperationException
	    a1.clear();
	    System.out.println(a1);
	    
	    //判断集合是否为空：boolean isEmpty();
	    boolean b3 = a1.isEmpty();
	    System.out.println("集合是否为空？："+b3);
	    
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void retainAll() {
		//取交集:al1中只会保留和al2中相同的元素,如果没有交集就为空:boolean retainAll(Object)
		ArrayList al1 = new ArrayList();
	    al1.add("java01");
	    al1.add("java02");
	    al1.add("java03");
	    al1.add("java04");
	           
	    ArrayList al2 = new ArrayList();
	    al2.add("java01");
	    al2.add("java02");
	    al2.add("java05");
	    al2.add("java06");
	           
	    boolean b = al1.retainAll(al2);
	    System.out.println(b);
	    System.out.println(al1);
	    System.out.println(al2);
	           
	           
	    boolean b2 = al1.removeAll(al2);//把相同的删除
	    System.out.println(b2);
	    System.out.println(al1);
	}

}
