package com.johnny.javase.thread;

import java.io.IOException;

/**
 * 类 编 号：
 * 类 名 称：TestThrad
 * 内容摘要：sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。
 * 完成日期：2016年8月4日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestThread {
	private int i = 10;
	private Object object = new Object();

	public static void main(String[] args) throws IOException, InterruptedException {
		TestThread test = new TestThread();
		MyThread thread1 = test.new MyThread("线程I");
		MyThread thread2 = test.new MyThread("线程II");
		System.out.println(thread1.getName()+":--"+thread1.getState());//NEW
		System.out.println(thread2.getName()+":--"+thread2.getState());//NEW
		thread1.start();
		thread2.start();
		thread1.join();
		System.out.println(thread1.getName()+":--"+thread1.getState());//TERMINATED
		thread2.join();
		System.out.println(thread2.getName()+":--"+thread2.getState());//TERMINATED
	}

	class MyThread extends Thread {
		public MyThread(String threadname) {
			// TODO Auto-generated constructor stub
			super(threadname);
			//main:--RUNNABLE
			System.out.println("Construct..."+Thread.currentThread().getName()+":--"+Thread.currentThread().getState());
		}
		public MyThread() {
			super();
		}
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			synchronized (object) {
				System.out.println("run..."+Thread.currentThread().getName()+":--"+Thread.currentThread().getState());//RUNNABLE
				i++;
				System.out.println("i:" + i);
				try {
					System.out.println("线程：" + Thread.currentThread().getName()
							+ "进入睡眠状态");
					Thread.currentThread().sleep(10000);
				}
				catch (InterruptedException e) {
					// TODO: handle exception
				}
				System.out.println("线程：" + Thread.currentThread().getName()
						+ "睡眠结束");
				i++;
				System.out.println("i:" + i);
			}
		}
	}

}
