package com.johnny.hibernate.secondcache;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
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
	public void testBatch(){
		session.doWork(new Work() {			
			@Override
			public void execute(Connection connection) throws SQLException {
				//通过 JDBC 原生的 API 进行操作, 效率最高, 速度最快!
			}
		});
	}
	
	@Test
	public void testQueryIterate(){
		Department8 dept = (Department8) session.get(Department8.class, 1);
		System.out.println(dept.getName());
		System.out.println(dept.getEmps().size()); 
		
		Query query = session.createQuery("FROM Employee8 e WHERE e.dept.id = 2");
//		List<Employee> emps = query.list();
//		System.out.println(emps.size()); 
		
		Iterator<Employee8> empIt = query.iterate();
		while(empIt.hasNext()){
			System.out.println(empIt.next().getName()); 
		}
	}
	
	@Test
	public void testUpdateTimeStampCache(){
		Query query = session.createQuery("FROM Employee8");
		query.setCacheable(true);
		
		List<Employee8> emps = query.list();
		System.out.println(emps.size());
		
		Employee8 employee = (Employee8) session.get(Employee8.class, 1);
		employee.setSalary(30000);
		
		emps = query.list();
		System.out.println(emps.size());
	}
	
	/**
	 * 查询缓存: 默认情况下, 设置的缓存对 HQL 及 QBC 查询时无效的, 但可以通过以下方式使其是有效的
		I.  在 hibernate 配置文件中声明开启查询缓存
		<property name="cache.use_query_cache">true</property>
		II. 调用 Query 或 Criteria 的 setCacheable(true) 方法
		III. 查询缓存依赖于二级缓存
	 */
	@Test
	public void testQueryCache(){
		Query query = session.createQuery("FROM Employee8");
		query.setCacheable(true);
		
		List<Employee8> emps = query.list();
		System.out.println(emps.size());
		
		emps = query.list();
		System.out.println(emps.size());
		
		Criteria criteria = session.createCriteria(Employee8.class);
		criteria.setCacheable(true);
	}
	
	@Test
	public void testCollectionSecondLevelCache(){
		//<collection-cache usage="read-write" collection="com.johnny.hibernate.secondcache.Department8.emps"/>
		//对depts的emps 集合开启二级缓存
		Department8 dept = (Department8) session.get(Department8.class, 2);
		System.out.println(dept.getName());
		System.out.println(dept.getEmps().size()); 
		
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Department8 dept2 = (Department8) session.get(Department8.class, 2);
		System.out.println(dept2.getName());
		System.out.println(dept2.getEmps().size()); 
	}
	
	@Test
	public void testHibernateSecondLevelCache(){
		//
		Employee8 employee = (Employee8) session.get(Employee8.class, 1);
		System.out.println(employee.getName()); 
		
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Employee8 employee2 = (Employee8) session.get(Employee8.class, 1);
		System.out.println(employee2.getName()); 
	}
	
	@Test
	public void TestSave(){
		Department8 department = new Department8();
		department.setName("IT部");
		Employee8 employee = new Employee8();
		employee.setName("hfq");
		employee.setSalary(19000);
		employee.setEmail("AA@qq.com");
		Employee8 employee2 = new Employee8();
		employee2.setSalary(17000);
		employee2.setName("hfq2");
		employee2.setEmail("AA@qq.com");
		
		department.getEmps().add(employee);
		department.getEmps().add(employee2);
		employee.setDept(department);
		employee2.setDept(department);
		
		session.save(department);
		session.save(employee);
		session.save(employee2);
	}

}
