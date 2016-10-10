package com.johnny.spring.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.johnny.spring.ssh.entities.Employee;
import com.johnny.spring.ssh.service.DepartmentService;
import com.johnny.spring.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,
 ModelDriven<Employee>, Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String list() {
		request.put("employees", employeeService.getAll());
		return "list";
	}

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	public String input(){
		request.put("departments", departmentService.getAll());
		return INPUT;
	}
	
	public void prepareInput(){
		if(id != null){
			model = employeeService.get(id);
		}
	}
	
	public String save(){
		if(id == null){
			model.setCreateTime(new Date());			
		}
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	/**
	 * 可以根据 id 来判断为 save 方法准备的 model 是 new 的还是从数据库获取的!
	 */
	public void prepareSave(){
		if(id == null){
			model = new Employee();
		}else{
			model = employeeService.get(id);
		}
	}
	
	private String lastName;
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
		//对于ajax处理，必须要手动try catch，否则不能捕获到异常也不会打印出来
		try {
			if(employeeService.lastNameIsValid(lastName)){
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			inputStream = new ByteArrayInputStream("2".getBytes("UTF-8")); 
		}
		
		
		return "ajax-success";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {}

	private Employee model;
	
	@Override
	public Employee getModel() {
		return model;
	}

}
