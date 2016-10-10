package com.johnny.hibernate.secondcache;

public class Employee8 {

	private Integer id;
	private String name;
	private float salary;
	private String email;
	
	private Department8 dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department8 getDept() {
		return dept;
	}

	public void setDept(Department8 dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}

	public Employee8(String email, float salary, Department8 dept) {
		super();
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}
	
	public Employee8() {
		super();
	}

	public Employee8(String name, float salary, String email,
			Department8 dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}
	
	
	
}
