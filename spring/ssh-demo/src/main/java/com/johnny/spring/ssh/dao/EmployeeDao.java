package com.johnny.spring.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import com.johnny.spring.ssh.entities.Employee;

public class EmployeeDao extends BaseDao{
	
	public void delete(Integer id){
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public List<Employee> getAll(){
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	public Employee getEmployeeByLastName(String lastName){
		String hql = "FROM Employee e WHERE e.lastName = ?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		Employee employee = (Employee) query.uniqueResult();
//		System.out.println(employee.getDepartment().getClass().getName());
		return employee;
	}
	
	public Employee get(Integer id){
		return (Employee) getSession().get(Employee.class, id);
	}
}
