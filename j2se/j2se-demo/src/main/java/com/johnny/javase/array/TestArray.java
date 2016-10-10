package com.johnny.javase.array;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 类 编 号：
 * 类 名 称：TestArray
 * 内容摘要：数组是一种非常快的数据结构，如果你已经知道元素的长度，那么就应该使用数组而非ArrayList等数据结构。
 * 完成日期：2016年9月8日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestArray {
	@Test
	public void test(){
//		1、定义一个Java数组
//		第一种是定义了一个数组，并且指定了数组的长度，我们这里称它为动态定义。
//		第二种和第三种在分配内存空间的同时还初始化了值。
		String[] aArray = new String[5];
		String[] bArray = {"a","b","c", "d", "e"};
		String[] cArray = new String[]{"a","b","c","d","e"};
		
//		2、打印Java数组中的元素
//		这里的重点是说明了Java中数组的引用和值得区别，第三行直接打印intArray，输出的是乱码，因为intArray仅仅是一个地址引用。
//		第4行输出的则是真正的数组值，因为它经过了Arrays.toString()的转化。
		int[] intArray = { 1, 2, 3, 4, 5 };
		String intArrayString = Arrays.toString(intArray);
		 
		// print directly will print reference value
		System.out.println(intArray);
		// [I@7150bd4d
		 
		System.out.println(intArrayString);
		// [1, 2, 3, 4, 5]
		
//		3、从Array中创建ArrayList
//		为什么要将Array转换成ArrayList呢？可能是因为ArrayList是动态链表，我们可以更方便地对ArrayList进行增删改，
//		我们并不需要循环Array将每一个元素加入到ArrayList中，用以上的代码即可简单实现转换。
		String[] stringArray = { "a", "b", "c", "d", "e" };
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
		//注意：对于int[]数组不能直接这样做，因为asList()方法的参数必须是对象。应该先把int[]转化为Integer[]。
		int[] intArray3 = { 1, 2, 3, 4, 5 };
		Integer[] integerArray3 = new Integer[]{ 1, 2, 3, 4, 5 };
//		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(intArray3)); //error
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(integerArray3));
		Set set = new HashSet(Arrays.asList(stringArray)); //使用list构造set
		System.out.println("arrayList..."+arrayList);
		System.out.println("set..."+set);
		// [a, b, c, d, e]
		
//		4、检查数组中是否包含某一个值
//		先使用Arrays.asList()将Array转换成List<String>，这样就可以用动态链表的contains函数来判断元素是否包含在链表中。
		String[] stringArray4 = { "a", "b", "c", "d", "e" };
		boolean b = Arrays.asList(stringArray4).contains("a");
		System.out.println(b);
		// true
		
//		5、连接两个数组
		int[] intArray5 = { 1, 2, 3, 4, 5 };
		int[] intArray6 = { 6, 7, 8, 9, 10 };
		// Apache Commons Lang library
		int[] combinedIntArray = ArrayUtils.addAll(intArray5, intArray6);
		System.out.println(Arrays.toString(combinedIntArray));
		
//		6、声明一个数组内链
//		method(new String[]{"a", "b", "c", "d", "e"});
		
//		7、将数组中的元素以字符串的形式输出
		// containing the provided list of elements
		// Apache common lang
//		同样利用StringUtils中的join方法，可以将数组中的元素以一个字符串的形式输出。
		String j = StringUtils.join(new String[] { "a", "b", "c" }, "||");
		System.out.println(j);
		// a, b, c
		
//		8、将Array转化成Set集合
//		在Java中使用Set，可以方便地将需要的类型以集合类型保存在一个变量中，主要应用在显示列表。同样可以先将Array转换成List，然后再将List转换成Set。
		Set<String> set8 = new HashSet<String>(Arrays.asList(stringArray));
		System.out.println(set8);
		//[d, e, b, c, a]
		
//		9、数组翻转
//		依然用到了万能的ArrayUtils。
//		Java API同样提供了一些便捷方法通过java.utils.Arrays类去操作数组，通过使用Arrays你可以排序数组，你可以做二分搜索。
		int[] intArray9 = { 1, 2, 3, 4, 5 };
		ArrayUtils.reverse(intArray9);
		System.out.println(Arrays.toString(intArray9));
		//[5, 4, 3, 2, 1]
		
//		10、从数组中移除一个元素
		int[] intArray10 = { 1, 2, 3, 4, 5 };
		int[] removed = ArrayUtils.removeElement(intArray10, 3);//create a new array
		System.out.println(Arrays.toString(removed));
		
//		将一个int值转化成byte数组
		byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
		 
		for (byte t : bytes) {
			System.out.format("0x%x ", t);
		}
	}

	@Test
	public void test2(){
		System.out.println("----test2----");
//		Java同样支持多维数组，在表示2D和3D的时候非常有用，像行和列或矩阵。多维数组也是一个数组的数组，这里是创建多维数组的例子：
		int[][] multiArray = {{1,2,3},{10,20,30}};
		System.out.println(multiArray[0].length);
		System.out.println(multiArray[1].length);
	}
}
