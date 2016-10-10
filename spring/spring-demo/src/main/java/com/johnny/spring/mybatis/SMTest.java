package com.johnny.spring.mybatis;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnny.spring.mybatis.bean.User;
import com.johnny.spring.mybatis.mapper.UserMapper;

public class SMTest {

	private UserMapper userMapper;
	private ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		userMapper = ctx.getBean(UserMapper.class);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testAdd() {
		User user = new User(-1, "tom", new Date(), 1234);
		userMapper.save(user);
		
		int id = user.getId();
		System.out.println(id);
	}
	
	@Test
	public void update() {
		User user = userMapper.findById(2);
		user.setSalary(2000);
		userMapper.update(user);
	}

	@Test
	public void delete() {
		userMapper.delete(3);
	}

	@Test
	public void findById() {
		User user = userMapper.findById(1);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		List<User> users = userMapper.findAll();
		System.out.println(users);
	}
}
