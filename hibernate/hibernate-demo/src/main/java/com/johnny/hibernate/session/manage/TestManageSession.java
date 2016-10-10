package com.johnny.hibernate.session.manage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.johnny.hibernate.secondcache.Department8;

public class TestManageSession {

	@Test
	public void testManageSession() {

		// 获取 Session
		// 开启事务
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println("-->" + session.hashCode());
		Transaction transaction = session.beginTransaction();

		DepartmentDao departmentDao = new DepartmentDao();

		Department8 dept = new Department8();
		dept.setName("johnny");

		departmentDao.save(dept);
		departmentDao.save(dept);
		departmentDao.save(dept);

		// 若 Session 是由 thread 来管理的, 则在提交或回滚事务时, 已经关闭 Session 了.
		transaction.commit();
		System.out.println(session.isOpen());
	}

}
