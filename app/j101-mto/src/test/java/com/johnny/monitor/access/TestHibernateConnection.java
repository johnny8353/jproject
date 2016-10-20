package com.johnny.monitor.access;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author Administrator
 * 
 */
public class TestHibernateConnection {
	private ApplicationContext ctx = null;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	}

	@Test
	public void testSession() {
		SessionFactory sessionFactory = (SessionFactory) ctx
				.getBean("sessionFactory");
		System.out.println(sessionFactory);
		// 2. 创建一个 Session 对象
		Session session = sessionFactory.openSession();

		// 3. 开启事务
		Transaction transaction = session.beginTransaction();

		// 4. 执行保存操作
//		News news = new News("Java12345", "johnny", new Date(
//				new java.util.Date().getTime()));
//		session.save(news);

		// 5. 提交事务
		transaction.commit();

		// 6. 关闭 Session
		session.close();

		// 7. 关闭 SessionFactory 对象
		sessionFactory.close();
	}
}