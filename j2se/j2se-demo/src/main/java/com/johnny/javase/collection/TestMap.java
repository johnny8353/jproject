package com.johnny.javase.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestMap
 * 内容摘要：HashMap和Hashtable都是采取Hash表的方式进行存储，HashMap不是线程安全的，Hashtable是线程安全的，我们可以把HashMap看做是“简化”版的Hashtable。
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestMap {
	@Test
	public void hashMapTest1()
	{
	    Map<Integer,String> map = new HashMap<Integer, String>();
	    
	    map.put(new Integer(1), "a");
	    map.put(new Integer(2), "b");
	    map.put(new Integer(3), "c");
	    
	    System.out.println(map);
	    System.out.println(map.entrySet());
	    System.out.println(map.keySet());
	    System.out.println(map.values());
	    
	    for(Entry<Integer,String> entry : map.entrySet()){
	    	System.out.println(entry.getKey());
	    	System.out.println(entry.getValue());
	    }
	    
	    for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer,String> type = (Entry<Integer,String>) iterator.next();
			System.out.println(type.getKey());
	    	System.out.println(type.getValue());
			
		}
	}
	@Test
	public void hashMapTest2()
	{
	    Map<Integer,String> map = new HashMap<Integer, String>();
	    
	    map.put(null, null);//key如果重复，后面会覆盖前面
	    map.put(null, "d");
	    map.put(new Integer(4), null);
	    map.put(new Integer(5), null);
	    
	    System.out.println(map);
	    System.out.println(map.entrySet());
	    System.out.println(map.keySet());
	    System.out.println(map.values());
	}
	
	@Test
	public void hashTableTest1()
	{
	    Map<Integer,String> table = new Hashtable<Integer, String>();
	    
	    table.put(new Integer(1), "a");
	    table.put(new Integer(2), "b");
	    table.put(new Integer(3), "c");
	    
	    System.out.println(table);
	    System.out.println(table.entrySet());
	    System.out.println(table.keySet());
	    System.out.println(table.values());
	}
	@Test
	public void hashTableTest2()
	{
	    Map<Integer,String> table = new Hashtable<Integer, String>();
	    
	    table.put(null, null);//不可写入 当我们试图将null插入到hashtable中时，报出了空指针异常。
	    table.put(null, null);
	    table.put(new Integer(4), null);
	    table.put(new Integer(5), null);
	    
	    System.out.println(table);
	    System.out.println(table.entrySet());
	    System.out.println(table.keySet());
	    System.out.println(table.values());
	}
}
