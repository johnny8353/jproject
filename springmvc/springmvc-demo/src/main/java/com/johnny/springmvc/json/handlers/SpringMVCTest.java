package com.johnny.springmvc.json.handlers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.johnny.springmvc.crud.dao.EmployeeDao;
import com.johnny.springmvc.crud.entities.Employee;

@RequestMapping("/json")
@Controller("jsonSpringMVCTest")
public class SpringMVCTest {
	@Autowired
	private EmployeeDao employeeDao;
	
	private static final String SUCCESS = "success";
	
	/**
	 * 返回 集合或对象
	 * 添加@ResponseBody
	 * 
	 * Jackson jar 包：
		- jackson-annotations-2.1.5.jar
		- jackson-core-2.1.5.jar
		- jackson-databind-2.1.5.jar
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		System.out.println("testJson...");
		return employeeDao.getAll();
	}

}
