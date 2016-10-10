package com.johnny.hibernate.relation.n2one.both;

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
 * 多对一双向
 */
public class HibernateTest {

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
	
	@Test
	public void testCascade(){
		Customer2 customer = (Customer2) session.get(Customer2.class, 3);
		customer.getOrders().clear();
	}
	
	@Test
	public void testDelete(){
		//在不设定级联关系的情况下, 且 1 这一端的对象有 n 的对象在引用, 不能直接删除 1 这一端的对象
		Customer2 customer = (Customer2) session.get(Customer2.class, 1);
		session.delete(customer); 
	}
	
	@Test
	public void testUpdat2(){
		Customer2 customer = (Customer2) session.get(Customer2.class, 1);
		customer.getOrders().iterator().next().setOrderName("GGG"); 
	}
	
	@Test
	public void testUpdate(){
		Order2 order = (Order2) session.get(Order2.class, 1);
		order.getCustomer().setCustomerName("AAA");
	}
	
	@Test
	public void testOne2ManyGet(){
		//1. 对 n 的一端的集合使用延迟加载
		Customer2 customer = (Customer2) session.get(Customer2.class, 2);
		System.out.println(customer.getCustomerName()); 
		//2. 返回的多的一端的集合时 Hibernate 内置的集合类型. 
		//该类型具有延迟加载和存放代理对象的功能. 
		System.out.println(customer.getOrders().getClass()); 
		
		//session.close();
		//3. 可能会抛出 LazyInitializationException 异常 
		
		System.out.println(customer.getOrders().size()); 
		
		//4. 再需要使用集合中元素的时候进行初始化. 
	}
	
	@Test
	public void testMany2OneGet(){
		//1. 若查询多的一端的一个对象, 则默认情况下, 只查询了多的一端的对象. 而没有查询关联的
		//1 的那一端的对象!
		Order2 order = (Order2) session.get(Order2.class, 1);
		System.out.println(order.getOrderName()); 
		
		System.out.println(order.getCustomer().getClass().getName());
		
//		session.close();
		
		//2. 在需要使用到关联的对象时, 才发送对应的 SQL 语句. 
		Customer2 customer = order.getCustomer();
		System.out.println(customer.getCustomerName()); 
		
		//3. 在查询 Customer 对象时, 由多的一端导航到 1 的一端时, 
		//若此时 session 已被关闭, 则默认情况下
		//会发生 LazyInitializationException 异常
		
		//4. 获取 Order 对象时, 默认情况下, 其关联的 Customer 对象是一个代理对象!
		
	}
	
	@Test
	public void testMany2OneSave(){
		Customer2 customer = new Customer2();
		customer.setCustomerName("AA");
		
		Order2 order1 = new Order2();
		order1.setOrderName("ORDER-1");
		
		Order2 order2 = new Order2();
		order2.setOrderName("ORDER-2");
		
		//设定关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		
		//执行  save 操作: 先插入 Customer, 再插入 Order, 3 条 INSERT, 2 条 UPDATE
		//因为 1 的一端和 n 的一端都维护关联关系. 所以会多出 UPDATE
		//可以在 1 的一端的 set 节点指定 inverse=true, 来使 1 的一端放弃维护关联关系!
		//建议设定 set 的 inverse=true, 建议先插入 1 的一端, 后插入多的一端
		//好处是不会多出 UPDATE 语句
		session.save(customer);
		
		session.save(order1);
		session.save(order2);
		
		//先插入 Order, 再插入 Cusomer, 3 条 INSERT, 4 条 UPDATE
//		session.save(order1);
//		session.save(order2);
//		
//		session.save(customer);
	}

}
