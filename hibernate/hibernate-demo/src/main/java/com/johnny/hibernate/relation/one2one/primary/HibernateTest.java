package com.johnny.hibernate.relation.one2one.primary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void testGet2(){
		//在查询没有外键的实体对象时, 使用的左外连接查询, 一并查询出其关联的对象
		//并已经进行初始化. 
		Manager2 mgr = (Manager2) session.get(Manager2.class, 1);
		System.out.println(mgr.getMgrName()); 
		System.out.println(mgr.getDept().getDeptName()); 
	}
	
	@Test
	public void testGet(){
		//1. 默认情况下对关联属性使用懒加载
		Department2 dept = (Department2) session.get(Department2.class, 1);
		System.out.println(dept.getDeptName()); 
		
		//2. 所以会出现懒加载异常的问题. 
		Manager2 mgr = dept.getMgr();
		System.out.println(mgr.getMgrName()); 
	}
	
	@Test
	public void testSave(){
		
		Department2 department = new Department2();
		department.setDeptName("DEPT-DD");
		
		Manager2 manager = new Manager2();
		manager.setMgrName("MGR-DD");
		
		//设定关联关系
		manager.setDept(department);
		//必须关联mgr，主键由mgr生成
		department.setMgr(manager);
		
		//保存操作
		//先插入哪一个都不会有多余的 UPDATE
		session.save(department);
		session.save(manager);
		
	}
	
	@Test
	public void testSaveSingle(){
		Manager2 manager = new Manager2();
		manager.setMgrName("MGR-FF");
		//不会插入 dept表
		session.save(manager);
		
	}
	

}
