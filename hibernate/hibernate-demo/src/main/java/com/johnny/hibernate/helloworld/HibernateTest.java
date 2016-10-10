package com.johnny.hibernate.helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		
		System.out.println("test...");
		
		//1. 创建一个 SessionFactory 对象
		SessionFactory sessionFactory = null;
		
		//1). 创建 Configuration 对象: 对应 hibernate 的基本配置信息和 对象关系映射信息
		Configuration configuration = new Configuration().configure();
		
		//4.0 之前这样创建
//		sessionFactory = configuration.buildSessionFactory();
		
		//2). 创建一个 ServiceRegistry 对象: hibernate 4.x 新添加的对象
		//hibernate 的任何配置和服务都需要在该对象中注册后才能有效.
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				                            .buildServiceRegistry();
		
		//3).
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//2. 创建一个 Session 对象
		Session session = sessionFactory.openSession();
		
		//3. 开启事务
		Transaction transaction = session.beginTransaction();
		
		//4. 执行保存操作
		News news = new News("Java12345", "johnny", new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//5. 提交事务 
		transaction.commit();
		
		//6. 关闭 Session
		session.close();
		
		//7. 关闭 SessionFactory 对象
		sessionFactory.close();
	}
	
}
