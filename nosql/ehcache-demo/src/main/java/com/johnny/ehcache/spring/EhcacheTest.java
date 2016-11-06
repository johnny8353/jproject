package com.johnny.ehcache.spring;

import java.util.Date;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.ehcache.a_helllo.User;
/**
 Cache中常用参数的具体意义
        （1）name：Cache的唯一标识。
        （2）maxElementsInMemory：内存中最大缓存对象数。
        （3）eternal：Element是否永久有效，一旦设置true，timeout将不起作用。
        （4）timeToIdleSeconds：设置Element在失效前的允许闲置时间。仅当element不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大。
        （5）timeToLiveSeconds：设置Element在失效前允许存活时间。最大时间介于创建时间和失效时间之间。仅当element不是永久有效时使用，默认是0.，也就是element存活时间无穷大。
        （6）overflowToDisk：配置此属性，当内存中Element数量达到maxElementsInMemory时，Ehcache将会Element写到磁盘中。
        （7）maxElementsOnDisk：磁盘中最大缓存对象数，若是0表示无穷大。
        （8） memoryStoreEvictionPolicy：当达到maxElementsInMemory限制时，Ehcache将会根据指定的策略去清理缓存中的内容。默认策略是LRU（最近最少使用），你也可以设置为FIFO（先进先出）或是LFU（较少使用） 
 * @author Administrator
 *
 */
public class EhcacheTest {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CacheManager cacheManager = (CacheManager) ctx
				.getBean("cacheManager");
		Cache levelOneCache = cacheManager.getCache("levelOneCache");
		Thread.sleep(2000);
		User cacheObject = null;
		for (int i = 0; i < 10; i++) {
			Element element = levelOneCache.get("key");

			if (element == null) {
				cacheObject = new User(1, "hfq1", new Date(), 22L);
				element = new Element("key", cacheObject);
				levelOneCache.put(element);
				System.out.println("cacheObject[" + cacheObject + "]"
						+ ",无法从缓存中取到");
			} else {
				cacheObject = (User) element.getValue();
				System.out.println("cacheObject[" + cacheObject + "]"
						+ ",从缓存中取到");
			}
		}
		cacheManager.shutdown();
//		levelOneCache.flush();
//		System.out.println("flush");
	}
}