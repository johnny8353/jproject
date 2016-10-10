package com.johnny.mybaits.relation;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.johnny.mybaits.bean.Classes;
import com.johnny.mybaits.util.MybatisUtils;

public class Test5 {
	/*
	 * 测试: 一对一关联表查询
	 */
	@Test
	public void testOne2M() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.johnny.mybaits.relation.ClassMapper.getClass";

//		statement = "com.johnny.mybaits.relation.ClassMapper.getClass2";

		Classes c = session.selectOne(statement, 2);
		System.out.println(c);

		session.close();
	}

	/*
	 * 测试: 一对多关联表查询
	 */
	@Test
	public void testM2M() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.johnny.mybaits.relation.ClassMapper2.getClass";

//		statement = "com.johnny.mybaits.relation.ClassMapper2.getClass2";

		Classes c = session.selectOne(statement, 2);
		System.out.println(c);

		session.close();
	}

}
