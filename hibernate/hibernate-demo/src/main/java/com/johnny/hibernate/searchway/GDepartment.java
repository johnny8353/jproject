package com.johnny.hibernate.searchway;

import java.util.HashSet;
import java.util.Set;

public class GDepartment {

	private Integer id;
	private String name;
	
	private Set<Employee> emps = new HashSet<>();

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

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + "]";
	}

	public GDepartment(Integer id, String name, Set<Employee> emps) {
		super();
		this.id = id;
		this.name = name;
		this.emps = emps;
	}

	public GDepartment() {
		super();
	}
	
	
	
}
