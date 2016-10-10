package com.johnny.javase.thread;

import java.io.IOException;

/**
 * 类 编 号：
 * 类 名 称：TestRunable
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年9月9日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestRunable {
	private int i = 10;
	private Object object = new Object();
	public static void main(String[] args) throws IOException {
		TestRunable test = new TestRunable();
		System.out.println(Thread.currentThread().getName()+":--"+Thread.currentThread().getState());
		Thread thread1 = new Thread(test.new MyThread(),"线程I");
		Thread thread2 = new Thread(test.new MyThread(),"线程2");
		thread1.start();
		thread2.start();
	}
	
	class MyThread implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+":--"+Thread.currentThread().getState());
			synchronized (object) {
				System.out.println(Thread.currentThread().getName()+":--"+Thread.currentThread().getState());
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
			System.out.println(Thread.currentThread().getName()+":--"+Thread.currentThread().getState());
		}
		
	}
}
