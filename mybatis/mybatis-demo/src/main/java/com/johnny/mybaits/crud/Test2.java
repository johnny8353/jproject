package com.johnny.mybaits.crud;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.johnny.mybaits.bean.Order;
import com.johnny.mybaits.bean.User;
import com.johnny.mybaits.crud.annotation.UserMapper;
import com.johnny.mybaits.util.MybatisUtils;
/*
 * 测试: CRUD操作的XML的实现
 */
public class Test2 {
 
	@Test
	public void testAdd() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession();
		
		String statement = "com.johnny.mybaits.crud.userMapper.addUser";
		int insert = session.insert(statement , new User(-1, "KK", 23));
		//提交
		session.commit();
		
		session.close();
		
		System.out.println(insert);
	}
	
	@Test
	public void testUpate() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		
		String statement = "com.johnny.mybaits.crud.userMapper.updateUser";
		
		int update = session.update(statement, new User(4, "KK444", 25));
		
		session.close();
		System.out.println(update);
	}
	
	@Test
	public void testDelete() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		
		String statement = "com.johnny.mybaits.crud.userMapper.deleteUser";
		
		int delete = session.delete(statement, 4);
		
		session.close();
		System.out.println(delete);
	}
	
	@Test
	public void testGetUser() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		
		String statement = "com.johnny.mybaits.crud.userMapper.getUser";
		
		User user = session.selectOne(statement, 1);
		
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testGetAll() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		
		String statement = "com.johnny.mybaits.crud.userMapper.getAllUsers";
		
		List<User> list = session.selectList(statement);
		
		session.close();
		System.out.println(list);
	}
	/*
	 * 测试:　解决字段名与实体类属性名不相同的冲突
	 */
	@Test
	public void testOrder() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.johnny.mybaits.crud.orderMapper.getOrder";
		statement = "com.johnny.mybaits.crud.orderMapper.getOrder2";
		Order order = session.selectOne(statement , 2);
		System.out.println(order);
	}
	

	/*
	 * 测试: CRUD操作的注解的实现
	 */
	@Test
	public void testAdd2() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session = factory.openSession(true);
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "SS", 45));
		System.out.println(add);
		
		session.close();
	}
	
}
