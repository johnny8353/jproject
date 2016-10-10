package com.johnny.spring.tx;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("hfq", Arrays.asList("001", "001"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("hfq", "001");
	}
	
	@Test
	public void testBookShopDaoUpdateUserAccount(){
		bookShopDao.updateUserAccount("hfq", 2000);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopDao.updateBookStock("001");
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("001"));
	}

}
