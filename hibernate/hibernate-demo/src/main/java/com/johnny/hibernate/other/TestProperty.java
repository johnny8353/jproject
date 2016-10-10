package com.johnny.hibernate.other;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestProperty {
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
	public void testComponent(){
		Worker worker = new Worker();
		Pay pay = new Pay();
		
		pay.setMonthlyPay(1000);
		pay.setYearPay(80000); 
		pay.setVocationWithPay(5);
		
		worker.setName("ABCD");
		worker.setPay(pay);
		
		session.save(worker);
	}
	
	@Test
	public void testBlob() throws Exception{
		News3 news = new News3();
		news.setAuthor("cc");
		news.setContent("CONTENT");
		news.setDate(new Date());
		news.setDesc("DESC");
		news.setTitle("CC");
		System.out.println(System.getProperty("user.dir")+"/src/main/resources");
		InputStream stream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/t.jpg");
		Blob image = Hibernate.getLobCreator(session)
				              .createBlob(stream, stream.available());
		news.setImage(image);
		
		session.save(news);
		
		News3 news3 = (News3) session.get(News3.class, 4);
		Blob image3 = news3.getImage();
		
		InputStream in = image3.getBinaryStream();
		System.out.println(in.available()); 
	}
	
	@Test
	public void testPropertyUpdate(){
		News3 news = (News3) session.get(News3.class, 1);
		news.setTitle("aaaa"); 
		
		System.out.println(news.getDesc());
		System.out.println(news.getDate().getClass()); 
	}
	
	@Test
	public void testIdGenerator() throws InterruptedException{
		News3 news = new News3("AA", "aa", new java.sql.Date(new Date().getTime()));
		session.save(news); 
		
//		Thread.sleep(5000); 
	}
	
	@Test
	public void testDynamicUpdate(){
		News3 news = (News3) session.get(News3.class, 1);
		news.setAuthor("AABCD");
		
	}
	
}
