package com.johnny.javase.commonclass;

import java.util.ArrayList;

import org.junit.Test;

/*
 * java.lang.StringBuffer：可变的字符序列
 * java.lang.StringBuilder:可变的字符序列，是jdk5.0新加入的，线程不安全，效率要高于StringBuffer.
 */
public class TestStringBuffer {
	/*
	 * 对比String，StringBuffer,StringBuilder三者在添加上的效率：
	 * 效率从高到底： StringBuilde > StringBuffer > String
	 */
	@Test
	public void test3(){
		String text = "";
		long startTime = 0L;
		long endTime = 0L;
		StringBuffer buffer = new StringBuffer("");
		StringBuilder builder = new StringBuilder("");
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++){
		buffer.append(String.valueOf(i));}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer的执行时间："+(endTime-startTime));
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++){
		builder.append(String.valueOf(i));}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder的执行时间："+(endTime-startTime));
		
		startTime = System.currentTimeMillis();
		for(int i = 0;i<20000;i++){
		text = text + i;}
		endTime = System.currentTimeMillis();
		System.out.println("String的执行时间："+(endTime-startTime));

	}
	
/*
 * java.lang.StringBuffer和StringBuilder:代表可变的字符序列，可以对字符串内容进行增删
 * 
 *  StringBuffer append(String s),   StringBuffer append(int n) ,  
 StringBuffer append(Object o) ,  StringBuffer append(char n),
 StringBuffer append(long n),  StringBuffer append(boolean n),
 StringBuffer insert(int index, String str) 
 public StringBuffer reverse() :反转此StringBuffer
 StringBuffer delete(int startIndex, int endIndex) 
 public char charAt(int n )
 public void setCharAt(int n ,char ch)
 StringBuffer replace( int startIndex ,int endIndex, String str) 
 public int indexOf(String str)
 public String substring(int start,int end)
 public int length()

 总结：添加：append() 删除：delete(int i,int j) 修改：setCharAt(int index,char ch) 查 charAt(int n);
 插入：insert(int index,String str)  反转：reverse() 长度：length()

 */
	@Test
	public void test1() {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());
		sb.append("abc").append("123").append(true);

		// ArrayList list = new ArrayList();
		System.out.println(sb); // HK WC
		sb.insert(3, "hello");
		System.out.println(sb);

		StringBuffer sb1 = sb.reverse();
		System.out.println(sb1);
		System.out.println(sb);
	}
}
