package com.johnny.javase.thread.sync;

/**
 * 类 编 号：
 * 类 名 称：TestSynchronized
 * 内容摘要：synchronized实现同步
 * 完成日期：2016年9月9日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TestSynchronized {

	public static void main(String[] args) {
		Runnable run1 = new Runnable() {
			User user = new User();//多线程下同一对象
			@Override
			public void run() {
				try {
					//多线程下不同对象
					User user2 = new User();
					user2.print6(Thread.currentThread().getName());
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(run1, "线程1");
		Thread t2 = new Thread(run1, "线程2");

		t1.start();
		t2.start();
	}

}
