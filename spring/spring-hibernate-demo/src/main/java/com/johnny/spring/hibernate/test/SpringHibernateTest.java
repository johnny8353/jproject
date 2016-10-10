package com.johnny.spring.hibernate.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.spring.hibernate.entities.Account;
import com.johnny.spring.hibernate.service.BookShopService;
import com.johnny.spring.hibernate.service.Cashier;

public class SpringHibernateTest {

	private ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testCashier(){
		//事务传播行为 ，如果为propagation="REQUIRES_NEW" 两次购买一次成功也可以提交
		cashier.checkout("hfq", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopService(){
		//测试事务 ,开启事物  库存和金额为一组原子操作
		bookShopService.purchase("hfq", "1001");
	}
	
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
