package com.johnny.javase.proxy;
/**
 * 代理设计模式的原理: 
 * 使用一个代理将对象包装起来, 然后用该代理对象取代原始对象. 任何对原始对象的调用都要通过代理. 
 * 代理对象决定是否以及何时将方法调用转到原始对象上.
 * 
 * 静态代理，特征是代理类和目标对象的类都是在编译期间确定下来，不利于程序的扩展。
 * 同时，每一个代理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。
 *
 */
//静态代理模式
//接口
interface ClothFactory{
	void productCloth();
}
//被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nike工厂生产一批衣服");
	}	
}
//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	//创建代理类的对象时，实际传入一个被代理类的对象
	public ProxyFactory(ClothFactory cf){
		this.cf = cf;
	}
	
	@Override
	public void productCloth() {
		System.out.println("代理类开始执行，收代理费$1000");
		cf.productCloth();
	}
	
}

public class TestClothProduct {
	public static void main(String[] args) {
		NikeClothFactory nike = new NikeClothFactory();//创建被代理类的对象
		ProxyFactory proxy = new ProxyFactory(nike);//创建代理类的对象
		proxy.productCloth();
	}
}
