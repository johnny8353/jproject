package com.johnny.javase.thread.sync;

/**
 * 类 编 号：
 * 类 名 称：User
 * 内容摘要：synchronized实现同步
 * 完成日期：2016年9月9日
 * 编码作者：JohnnyHuang 黄福强
 */
public class User {
	private static int age = 0;

	public synchronized void print(String user) throws InterruptedException {
		// 结论：同步加在非静态方法 - 加锁 对多线程中下同一对象有作用，对不同对象没作用
		doPrint(user);
	}

	public void print2(String name,User user) throws InterruptedException {
		//结论：synchronized 同步块锁定对象，根据 锁定目标在不同对象间是否相等，判断是否起作用
		//如果多线程下不同对象间调用该方法的锁定目标都相等，加锁在不同对象间有效，否则无效
		synchronized (user) {
			doPrint(name);
		}
	}
	
	private byte[] lock = new byte[0]; // 特殊的instance变量

	public void print7(String user) throws InterruptedException {
		//结论：成员变量  -  加锁 对多线程中下同一对象有作用，对不同对象没作用
		synchronized (lock) {
			doPrint(user);
		}
	}
	
	public void print5(String user) throws InterruptedException {
		//结论：同步 当前对象  -  加锁 对多线程中下同一对象有作用，对不同对象没作用
		synchronized (this) {
			doPrint(user);
		}
	}

	public void print3(String user) throws InterruptedException {
		//结论：同步 Class对象  -  加锁	对多线程中下同一对象，对不同对象 都有作用
		synchronized (User.class) {
			doPrint(user);
		}
	}

	public void print4(String user) throws InterruptedException {
		//结论：同步 Class对象  -  加锁	对多线程中下同一对象，对不同对象 都有作用
		User user2 = new User();
		synchronized (user2.getClass()) {
			doPrint(user);
		}
	}

	public synchronized static void print6(String user) throws InterruptedException {
		//结论：同步 static方法  -  加锁	对多线程中下同一对象，对不同对象 都有作用
		for (int i = 0; i < 10; i++) {
			Thread.sleep(50);
			System.out.println(user + " say" + age++);
		}
	}
	

	
	public void doPrint(String name) throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			Thread.sleep(50);
			System.out.println(name + " say" + age++);
		}
	}

}
