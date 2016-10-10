package com.johnny.hibernate.relation.one2one.foreign;


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
		Manager mgr = (Manager) session.get(Manager.class, 1);
		System.out.println(mgr.getMgrName()); 
		System.out.println(mgr.getDept().getDeptName()); 
	}
	
	@Test
	public void testGet(){
		//1. 默认情况下对关联属性使用懒加载
		Department dept = (Department) session.get(Department.class, 1);
		System.out.println(dept.getDeptName()); 
		
		//2. 所以会出现懒加载异常的问题. 
//		session.close();
//		Manager mgr = dept.getMgr();
//		System.out.println(mgr.getClass()); 
//		System.out.println(mgr.getMgrName()); 
		
		//3. 查询 Manager 对象的连接条件应该是 dept.manager_id = mgr.manager_id
		//而不应该是 dept.dept_id = mgr.manager_id
		Manager mgr = dept.getMgr();
		System.out.println(mgr.getMgrName()); 
		
		
	}
	
	@Test
	public void testSave(){
		
		Department department = new Department();
		department.setDeptName("DEPT-BB");
		
		Manager manager = new Manager();
		manager.setMgrName("MGR-BB");
		
		//设定关联关系
		department.setMgr(manager);
		manager.setDept(department);
		
		//保存操作
		//建议先保存没有外键列的那个对象. 这样会减少 UPDATE 语句
		session.save(department);
		session.save(manager);
		
	}
	
	

}
