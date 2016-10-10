package com.johnny.spring.ssh.service;

import java.util.List;

import com.johnny.spring.ssh.dao.DepartmentDao;
import com.johnny.spring.ssh.entities.Department;

public class DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
	
}
