package com.johnny.spring.ssh.service;

import java.util.List;

import com.johnny.spring.ssh.dao.EmployeeDao;
import com.johnny.spring.ssh.entities.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public boolean lastNameIsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> getAll(){
		List<Employee> employees = employeeDao.getAll();
//		employees.clear();
		return employees;
	}

	public Employee get(Integer id) {
		return employeeDao.get(id);
	}
	
}
