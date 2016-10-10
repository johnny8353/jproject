package com.johnny.javase.generic;

import java.util.ArrayList;
import java.util.List;

//自定义泛型类
public class Order<T> {
	private String orderName;
	private int orderId;
	private T t;
	List<T> list = new ArrayList<T>();
	
	public void add(){
		list.add(t);
	}
	public  T getT(){
		return t;
	}
	public void setT(T t){
		this.t = t;
	}
	//不可以在static方法中使用泛型的声明
//	public static void show(){
//		System.out.println(t);
//	}
	public void info(){
		//不可以在try-catch中使用类的泛型的声明
//		try{
//			
//		}catch(T e){
//			
//		}
	}
	//声明泛型方法
	public static <E> E getE(E e){
		return e;
	}
	//实现数组到集合的复制
	public <E> List<E> fromArrayToList(E[] e){
		List<E> list = new ArrayList<E>();
		for(E e1 : e){
			list.add(e1);
		}
		return list;
	}
	
	public <E> List<E> getEList(){return null;}
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderId=" + orderId
				+ ", t=" + t + "]";
	}
}
//继承泛型类或泛型接口时，可以指明泛型的类型
class SubOrder extends Order<Integer>{
	
}
