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

public class HelloWorld {
	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(HelloWorld.class);
	
	//3.1.3
//	@Test
//	public void Test1() {
//		CacheManager cacheManager = CacheManagerBuilder
//				.newCacheManagerBuilder()
//				.withCache(
//						"preConfigured",
//						CacheConfigurationBuilder.newCacheConfigurationBuilder(
//								Long.class, String.class,
//								ResourcePoolsBuilder.heap(10))).build();
//		cacheManager.init();
//
//		Cache<Long, String> preConfigured = cacheManager.getCache(
//				"preConfigured", Long.class, String.class);
//
//		Cache<Long, String> myCache = cacheManager.createCache(
//				"myCache",
//				CacheConfigurationBuilder
//						.newCacheConfigurationBuilder(Long.class, String.class,
//								ResourcePoolsBuilder.heap(10)).build());
//
//		myCache.put(1L, "da one!");
//		String value = myCache.get(1L);
//
//		System.out.println(value);
//
//		cacheManager.removeCache("preConfigured");
//
//		cacheManager.close();
//	}
//
//	@Test
//	public void Test2() {
//		logger.warn("begin");
//
//		CacheManager cacheManager = CacheManagerBuilder
//				.newCacheManagerBuilder()
//				.withCache(
//						"preConfigured",
//						CacheConfigurationBuilder.newCacheConfigurationBuilder(
//								String.class, Object.class,
//								ResourcePoolsBuilder.heap(10))).build();
//		cacheManager.init();
//
//		Cache<String, Object> preConfigured = cacheManager.getCache(
//				"preConfigured", String.class, Object.class);
//		Set<User> userSet = new HashSet<>();
//		long begin = System.currentTimeMillis();
//		for (int i = 0; i < 10000; i++) {
//			User user = new User(i, "hfq" + i, new Date(), 22L);
//			userSet.add(user);
//		}
//		preConfigured.put("UserCache", userSet);
//		long end = System.currentTimeMillis();
//		logger.warn("本次put花费的时间：" + (end - begin));
//
//		Set<User> obj = (Set) preConfigured.get("UserCache");
//		logger.warn("输出：--" + obj.size());
//		
//		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
//		
//		for (User object : obj) {
//			if(object.getName().equals("hfq5192")){
//				logger.warn(object.getName());
//			}
//		}
//		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
//		cacheManager.close();
//	}

	//2.6.11
	@Test
	public void TestXML() {
		final URL myUrl = this.getClass().getResource("/ehcache.xml");
		CacheManager myCacheManager = CacheManager.create(myUrl);
		Cache cache = myCacheManager.getCache("mobileMsg");  
		Set<User> userSet = new HashSet<>();
		User user = new User(0, "hfq", new Date(), 22L);
		User user2 = new User(1, "hfq", new Date(), 22L);
		userSet.add(user);
		userSet.add(user2);
		Element element = new Element("UserCache", userSet);
		cache.put(element);

		Object obj = cache.get("UserCache");

		System.out.println(obj);
	}
	
	@Test
	public void TestXML2() {
		final URL myUrl = this.getClass().getResource("/ehcache.xml");
		CacheManager myCacheManager = CacheManager.create(myUrl);
		Cache cache = myCacheManager.getCache("mobileMsg");  
		Set<User> userSet = new HashSet<>();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			User user = new User(i, "hfq" + i, new Date(), 22L);
			userSet.add(user);
		}
		Element element = new Element("UserCache", userSet);
		cache.put(element);
		
		
		long end = System.currentTimeMillis();
		logger.warn("本次put花费的时间：" + (end - begin));
		


		Element result = cache.get("UserCache");
		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
		logger.warn("输出：--"  + result.getObjectKey());
		Set<User> users = (Set<User>) result.getObjectValue();
		for (User object : users) {
			if (object.getName().equals("hfq5192")) {
				logger.warn(object.getName());
			}
		}
		logger.warn("本次get花费的时间：" + (System.currentTimeMillis() - begin));
	}

}
