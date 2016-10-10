package com.johnny.hibernate.session;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * flush  refresh   clear
 * @author Administrator
 *
 */
public class TestHibernateFirstCache {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				                            .buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	
	/**
	 * clear(): 清理缓存
	 */
	@Test
	public void testClear(){
		News2 news1 = (News2) session.get(News2.class, 1);
		
		session.clear();
		
		News2 news2 = (News2) session.get(News2.class, 1);
	}
	
	/**
	 * refresh(): 会强制发送 SELECT 语句, 以使 Session 缓存中对象的状态和数据表中对应的记录保持一致!
	 * mysql默认隔离级别为可重复读，修改为读已提交，两次读到的数据才会刷新
	 * <!-- 设置 Hibernate 的事务隔离级别 -->
    	<property name="connection.isolation">2</property>
    	1. READ UNCOMMITED
		2. READ COMMITED
		4. REPEATABLE READ
		8. SERIALIZEABLE
	 */
	@Test
	public void testRefresh(){
		News2 news = (News2) session.get(News2.class, 1);
		System.out.println(news);
		
		session.refresh(news); 
		System.out.println(news); 
	}
	
	@Test
	public void testUpdate(){
		News2 news = (News2) session.get(News2.class, 1);
		news.setAuthor("hfq");
		session.update(news);
	}
	
	/**
	 * flush: 使数据表中的记录和 Session 缓存中的对象的状态保持一致. 为了保持一致, 则可能会发送对应的 SQL 语句.
	 * 1. 在 Transaction 的 commit() 方法中: 先调用 session 的 flush 方法, 再提交事务
	 * 2. flush() 方法会可能会发送 SQL 语句, 但不会提交事务. 
	 * 3. 注意: 在未提交事务或显式的调用 session.flush() 方法之前, 也有可能会进行 flush() 操作.
	 * 1). 执行 HQL 或 QBC 查询, 会先进行 flush() 操作, 以得到数据表的最新的记录
	 * 2). 若记录的 ID 是由底层数据库使用自增的方式生成的, 则在调用 save() 方法时, 就会立即发送 INSERT 语句. 
	 * 因为 save 方法后, 必须保证对象的 ID 是存在的!
	 */
	@Test
	public void testSessionFlush2(){
		News2 news = new News2("Java", "SUN", new java.util.Date());
		session.save(news);
	}
	
	@Test
	public void testSessionFlush(){
		News2 news = (News2) session.get(News2.class, 1);
		news.setAuthor("Oracle");
		
//		session.flush();
//		System.out.println("flush");
		
		News2 news2 = (News2) session.createCriteria(News2.class).uniqueResult();
		System.out.println(news2);
	}
	
	@Test
	public void testSessionCache(){
		//	第二次从缓存中读取，只会执行一次sql	
		News2 news = (News2) session.get(News2.class, 1);
		System.out.println(news); 
		
		News2 news2 = (News2) session.get(News2.class, 1);
		System.out.println(news2);
	}
	
	
	@Test
	public void testSave() {
		News2 news2 = new News2("java", "Sun", new Date(new java.util.Date().getTime()));
		session.save(news2);
	}
}
