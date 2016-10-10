package com.johnny.javase.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 泛型，JDK1.5新加入的，解决数据类型的安全性问题，其主要原理是在类声明时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。
 * 这样在类声明或实例化时只要指定好需要的具体的类型即可。Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮。
 * 
 * 泛型的使用
 * 1.在集合中使用泛型(掌握)
 * 2.自定义泛型类、泛型接口、泛型方法（理解 --->使用）
 * 3.泛型与继承的关系
 * 4.通配符
 * 
 * 特点：
 * 	1.对象实例化时不指定泛型，默认为：Object。
	2.泛型不同的引用不能相互赋值。
	3.加入集合中的对象类型必须与指定的泛型类型一致。
	4.静态方法中不能使用类的泛型。
	6.不能在catch中使用泛型
	7.从泛型类派生子类，泛型类型需具体化
	8.方法，也可以被泛型化，不管此时定义在其中的类是不是泛型化的。
	在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。没有指定默认是Object
 */
public class TestGeneric {

	/**
	 * 通配符的使用
	 * 读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
	 * 写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
	 * 唯一的例外是null，它是所有类型的成员。
	 */
	@Test
	public void test7() {
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list1 = list;
		// 可以读取声明为通配符的集合类的对象
		Iterator<?> iterator = list1.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// 不允许向声明为通配符的集合类中写入对象。唯一例外的是null
		// list1.add("CC");
		// list1.add(123);//编译时错误,因为我们不知道c的元素类型，我们不能向其中添加对象。

		list1.add(null);
	}

	/**
	 * 通配符 ?
	 * List<A>、List<B>、。。。。都是List<?>的子类
	 * 
	 * ? extends A :可以存放A及其子类
	 * ? super A:可以存放A及其父类
	 */
	@Test
	public void test6() {
		List<?> list = null;
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		list = list1;
		list = list2;

		show(list1);
//		show(list2);
		show2(list1);
		show2(list2);
		show1(list1);
		show1(list2);
		List<? extends Number> list3 = null;
		List<Integer> list4 = null;
		list3 = list4;
		// list3 = list1;
		List<? super Number> list5 = null;
		list5 = list1;
	}

	public void show(List<Object> list) {

	}

	public <E> void show2(List<E> e) {
		System.out.println(e.toString());
	}

	public void show1(List<?> list) {

	}

	/**
	 * 泛型与继承的关系:
	 * 如果B是A的一个子类型（子类或者子接口），而G是具有泛型声明的类或接口，G<B>并不是G<A>的子类型！
	 * 比如：String是Object的子类，但是List<String >并不是List<Object>的子类。
	 */
	@Test
	public void test5() {
		Object obj = null;
		String str = "AA";
		obj = str;

		Object[] obj1 = null;
		String[] str1 = new String[] { "AA", "BB", "CC" };
		obj1 = str1;

		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
		// list = list1;//如果B是A的一个子类型（子类或者子接口），而G是具有泛型声明的类或接口，G<B>并不是G<A>的子类型！
		// 假设list = list1满足
		// list.add(123);
		// String str = list1.get(0);//出现问题，所以假设不满足
	}

	// 自定义泛型类的使用
	@Test
	public void test4() {
		// 1.当实例化泛型类的对象时，指明泛型的类型。
		// 指明以后，对应的类中所有使用泛型的位置，都变为实例化中指定的泛型的类型
		// 2.如果我们自定义了泛型类，但是在实例化时没有使用，那么默认类型是Object类的
		Order<Boolean> order = new Order<Boolean>();
		// order.getT();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		List<Boolean> list = order.list;
		System.out.println(list);

		SubOrder o = new SubOrder();
		o.setT(100);
		o.add();
		List<Integer> list1 = o.list;

		System.out.println(list1);
		// 当通过对象调泛型方法时，指明泛型方法的类型。
		Integer i = order.getE(34);
		Double d = order.getE(2.3);

		// 在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。
		Integer[] in = new Integer[] { 1, 2, 3 };
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = order.fromArrayToList(in);
		System.out.println(list3);

		// 没有指定默认是Object
		List<Object> objs = order.getEList();
		System.out.println(objs);
	}

	@Test
	public void test3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("AA", 78);
		map.put("BB", 87);
		map.put("DD", 98);

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for (Map.Entry<String, Integer> o : set) {
			System.out.println(o.getKey() + "--->" + o.getValue());
		}
	}

	// 2.在集合中使用泛型
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(78);
		list.add(87);
		// list.add("AA");

		// for(int i = 0;i < list.size();i++){
		// int score = list.get(i);
		// System.out.println(score);
		// }
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// 1.在集合中没有使用泛型的情况下
	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(89);
		list.add(87);
		list.add(67);
		// 1.没有使用泛型，任何Object及其子类的对象都可以添加进来
		list.add(new String("AA"));

		for (int i = 0; i < list.size(); i++) {
			// 2.强转为int型时，可能报ClassCastException的异常
			int score = (Integer) list.get(i);
			System.out.println(score);
		}
	}
}
