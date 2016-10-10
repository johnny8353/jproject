package com.johnny.hibernate.searchway;

public class Employee {

	private Integer id;
	private String name;
	private float salary;
	private String email;
	
	private GDepartment dept;

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

	public GDepartment getDept() {
		return dept;
	}

	public void setDept(GDepartment dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}

	public Employee(String email, float salary, GDepartment dept) {
		super();
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}
	
	public Employee() {
		super();
	}

	public Employee(String name, float salary, String email,
			GDepartment dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}
	
	
	
}
