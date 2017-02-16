package com.johnny.zookeeper.hello;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback.ChildrenCallback;
import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Zookeeper 官方提供了两套java 客户端API 即 同步与异步。
 * @author Administrator
 *
 */
public class Hello {
	private static final String CONNETION_STRING = "10.5.172.200:2181";// ip:port,ip:port
	private static final int SESSION_TIMEOUT = 5000;// 客户端与服务端通过心跳检测来维持会话的有效性。在SESSION_TIMEOUT内没有有效的检测，会话失效
	private static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk = new ZooKeeper(CONNETION_STRING, SESSION_TIMEOUT, new Watcher() {
			// 监控所有被触发的事件
			public void process(WatchedEvent event) {
				System.out.println("已经触发了" + event.getType() + "事件！");
				if (event.getState() == Event.KeeperState.SyncConnected) {
					latch.countDown();
				}
			}
		});
		// 由于创建zk会话的过程是异步的。线程会继续执行后续代码，所以需要使用CountDownLatch工具，当创建zk对象完毕后，调用latch.await()方法，
		// 使线程进行等待状态，等待syncConnected事件（zk已经创建完毕）的到来，再执行latch.countDown()方法。
		latch.await();

		//
		System.out.println(zk);

		// 1列出子节点
		// 同步
		List<String> children = zk.getChildren("/", null);
		for (String node : children) {
			System.out.println(node);
		}
		// 异步
		zk.getChildren("/", null, new ChildrenCallback() {
			@Override
			public void processResult(int rc, String path, Object ctx, List<String> children) {
				/**
				 * rc 调用结果码 0 成功 -4 客户端与服务端断开连接 -110 节点已经存在 -112 会话过期
				 */
				for (String node : children) {
					System.out.println(node);
				}
			}
		}, null);

		// 判断节点是否存在
		// 同步方式
		Stat stat = zk.exists("/", null);
		if (stat != null) {
			System.out.println("node exists");
		} else {
			System.out.println("node does not exists");
		}
		// 异步方式
		// zk.exists(path, watch, cb, ctx);
		zk.exists("/", null, new StatCallback() {
			@Override
			public void processResult(int rc, String path, Object ctx, Stat stat) {
				if (stat != null) {
					System.out.println("node exists");
				} else {
					System.out.println("node does not exists");
				}
			}
		}, null);

		// 创建节点
		// 创建一个目录节点
//		zk.create(path, data, acl, createMode) 
//		acl Ids.OPEN_ACL_UNSAFE 表示不带有ACL权限控制
//		createMode
//		  public static final enum org.apache.zookeeper.CreateMode PERSISTENT;
//		  public static final enum org.apache.zookeeper.CreateMode PERSISTENT_SEQUENTIAL;
//		  public static final enum org.apache.zookeeper.CreateMode EPHEMERAL;
//		  public static final enum org.apache.zookeeper.CreateMode EPHEMERAL_SEQUENTIAL;
//		zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		//获取节点数据
		byte[] data = zk.getData("/testRootPath", null, null);
		System.out.println(new String(data));
		
		//更新节点
		Stat stat3 = zk.setData("/testRootPath", "hi".getBytes(), -1);
		System.out.println(stat3 != null);
		
		//delete
		zk.delete("/testRootPath", -1); //没有返回值 成功

	}

}
