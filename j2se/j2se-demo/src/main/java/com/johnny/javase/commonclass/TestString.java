package com.johnny.javase.commonclass;

import org.junit.Test;

public class TestString {
	/*
	 1.字符串 与基本数据类型、包装类之间转换
	 ①字符串 --->基本数据类型、包装类:调用相应的包装类的parseXxx(String str);
	 ①基本数据类型、包装类--->字符串:调用字符串的重载的valueOf()方法
	 
	 2.字符串与字节数组间的转换
	 ①字符串---->字节数组:调用字符串的getBytes()
	 ②字节数组---->字符串：调用字符串的构造器
	 
	 3.字符串与字符数组间的转换
	 ①字符串---->字符数组：调用字符串的toCharArray();
	 ②字符数组---->字符串:调用字符串的构造器
	 */
	@Test
	public void test5(){
		//1.字符串 与基本数据类型、包装类之间转换
		String str1 = "123";
		int i = Integer.parseInt(str1);
		System.out.println(i);
		String str2 = i + "";
		str2 = String.valueOf(i);
		System.out.println(str2);
		System.out.println();
		//2.字符串与字节数组间的转换
		String str = "abcd123";
		byte[] b = str.getBytes();
		for(int j = 0;j < b.length;j++){
			System.out.println((char)b[j]);
		}
		String str3 = new String(b);
		System.out.println(str3);
		System.out.println();
		//3.字符串与字符数组间的转换
		String str4 = "abc123中国人";
		char[] c = str4.toCharArray();
		for(int j = 0;j < c.length;j++){
			System.out.println(c[j]);
		}
		String str5 = new String(c);
		System.out.println(str5);
	}
	
	/*
	 	public String substring(int startpoint)
		public String substring(int start,int end):返回从start开始到end结束的一个左闭右开的子串。start可以从0开始的。
		pubic String replace(char oldChar,char newChar)
		public String replaceAll(String old,String new)
		public String trim()：去除当前字符串中首尾出现的空格，若有多个，就去除多个。
		public String concat(String str):连接当前字符串与str
		public String[] split(String regex)：按照regex将当前字符串拆分，拆分为多个字符串，整体返回值为String[]

	 */
	@Test
	public void test4() {
		String str1 = "北京尚硅谷教育北京";
		String str2 = "上海尚硅谷教育";
		String str3 = str1.substring(2, 5);
		System.out.println(str3);
		System.out.println(str1);
		String str4 = str1.replace("北京", "东京");
		System.out.println(str4);// 东京尚硅谷教育东京
		System.out.println(str1);// 北京尚硅谷教育北京
		String str5 = "   abc   d  ";
		String str6 = str5.trim();
		System.out.println("----" + str6 + "----");
		System.out.println("----" + str5 + "----");
		String str7 = str1.concat(str2);
		System.out.println(str1);
		System.out.println(str7);
		System.out.println();
		
		String str8 = "abc*d-e7f-ke";
		String[] strs = str8.split("-");
		for(int i = 0;i < strs.length;i++){
			System.out.println(strs[i]);
		}

	}

	
/*	 public int length() 
	 public char charAt(int index):返回在指定index位置的字符。index从0开始 
	 public boolean equals(Object anObject)：比较两个字符串是否相等。相等返回true。否则返回false 
	 public int compareTo(String anotherString) 
	 public int indexOf(String s)：返回s字符串在当前字符串中首次出现的位置。若没有，返回-1
	 public int indexOf(String s ,int startpoint)：返回s字符串从当前字符串startpoint位置开始的，首次出现的位置。 
	 public int lastIndexOf(String s):返回s字符串最后一次在当前字符串中出现的位置。若无，返回-1 
	 public int lastIndexOf(String s ,int startpoint) 
	 public boolean startsWith(String prefix):判断当前字符串是否以prefix开始。
	 public boolean endsWith(String suffix)：判断当前字符串是否以suffix结束。
	 public boolean regionMatches(int firstStart,String other,int otherStart ,int length):
	 判断当前字符串从firstStart开始的子串与另一个字符串other从otherStart开始，length长度的字串是否equals
	 */
	@Test
	public void test3() {
		String str1 = "abccdefghijkbcc";
		String str2 = "bcc";
		String str3 = "jkbcc";
		System.out.println(str2.length());
		System.out.println(str1.charAt(10));
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals("abcc"));
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.indexOf(str2, 5));
		System.out.println(str1.lastIndexOf(str2));
		System.out.println(str1.startsWith("abcd"));
		System.out.println(str1.regionMatches(10, str3, 0, str3.length()));

	}

	/*
	 String:代表不可变的字符序列。底层使用char[]存放。
	 String 是final的。
	 */
	@Test
	public void test1(){
		String str1 = "JavaEE";
		String str2 = "JavaEE";
		String str3 = new String("JavaEE");
		String str4 = "JavaEE" + "Android";
		String str5 = "Android";
		String str6 = str1 + str5;
		str5 = str5 + "Handoop";
		String str7 = str6.intern();
		String str8 = "JavaEEAndroid";
		System.out.println(str1 == str2);//true
		System.out.println(str1 == str3);//false
		System.out.println(str1.equals(str3));//true
		
		System.out.println(str4 == str6);//false
		System.out.println(str4.equals(str6));//true
		System.out.println(str7 == str4);//true
		System.out.println(str4 == str8);//true
		
		Person p1 = new Person("AA");
		Person p2 = new Person("AA");
		System.out.println("^_^"+ (p1.name == p2.name));//true
	}
}

class Person{
	String name;
	Person(String name){
		this.name = name;
	}
}