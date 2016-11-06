package com.johnny.ehcache.a_helllo;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 下面说下最近使用到的磁盘持久化与加载功能，由于之前使用过程中一般为直接缓存，而最近想到使用diskPersistent来配置本地磁盘持久化，发现了一些常见问题，网上找了很多文章终于得到最终效果。
实现此功能其实非常简单，只用简单的将diskPersistent配置为true，以tomcat为例，在重启时候需要告知EhCache，你要重启了，
让EhCache去序列化内容到磁盘，此过程可以自己写监听实现重启时调用CacheManager的shutdown，也可以直接使用EhCache提供的监听类
net.sf.ehcache.constructs.web.ShutdownListener，但是有一点需要注意，
	就是在使用此项功能时，必须保持重启或者关闭Server采用的是正常手段关闭，直接杀进程之类的关闭时完全不生效的。
 * @author Administrator
 *
 */
public class EhcacheToDisk {
	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(EhcacheToDisk.class);
	@Test
	public void test0()  throws Exception{
		/**
		 * 创建缓存管理对象
		 */
		URL url = EhcacheToDisk.class.getResource("/ehcache.xml");
		CacheManager cacheManager = CacheManager.create(url);
		Thread.sleep(1000);
		
		/**
		 * 获取缓存对象
		 */
		Cache cache = cacheManager.getCache("authCache1");
		/**
		 * 存入数据
		 */
		Set<User> userSet = new HashSet<>();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			User user = new User(i, "hfq1" + i, new Date(), 22L);
			userSet.add(user);
		}
		Element element = new Element("UserCache", userSet);
		cache.put(element);
		
		/*强行输出内存数据到硬盘*/
		cache.flush();
		Thread.sleep(500);
		long end = System.currentTimeMillis();
		logger.warn("本次put花费的时间：" + (end - begin));
		/**
		 * 关闭ehcache
		 */
		Thread.sleep(500);
		cacheManager.shutdown();
		
		/**
		 * 取出数据
		 */
//		cacheManager = CacheManager.create(url);
//		Thread.sleep(1000);
//		
//		cache = cacheManager.getCache("authCache1");
//		logger.warn("本次getCache花费的时间：" + (System.currentTimeMillis() - begin));
//
//		Element result = cache.get("UserCache");
//		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
//		logger.warn("输出：--"  + result.getObjectKey());
//		Set<User> users = (Set<User>) result.getObjectValue();
//		for (User object : users) {
//			if (object.getName().equals("hfq519")) {
//				logger.warn(object.getName());
//			}
//		}
//		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
//		
//		cacheManager.shutdown();
	}
	
	@Test
	public void test() throws InterruptedException{
		/**
		 * 创建缓存管理对象
		 */
		URL url = EhcacheToDisk.class.getResource("/ehcache.xml");
		CacheManager cacheManager = CacheManager.create(url);
		Thread.sleep(1000);
		/**
		 * 取出数据
		 */
		long begin = System.currentTimeMillis();
		Cache cache = cacheManager.getCache("authCache1");
		logger.warn("本次getCache花费的时间：" + (System.currentTimeMillis() - begin));

		Element result = cache.get("UserCache");
		if(result==null) return ;
		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
		logger.warn("输出：--"  + result.getObjectKey());
		Set<User> users = (Set<User>) result.getObjectValue();
		logger.warn(users.size()+"");
		for (User object : users) {
			if (object.getName().indexOf("519")>-1) {
				logger.warn("users:"+object.getName());
			}
		}
		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
		
		cacheManager.shutdown();
	}

}
