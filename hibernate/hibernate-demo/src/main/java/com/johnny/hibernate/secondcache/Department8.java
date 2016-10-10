package com.johnny.hibernate.secondcache;

import java.util.HashSet;
import java.util.Set;

public class Department8 {

	private Integer id;
	private String name;
	
	private Set<Employee8> emps = new HashSet<>();

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

	public Set<Employee8> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee8> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + "]";
	}

	public Department8(Integer id, String name, Set<Employee8> emps) {
		super();
		this.id = id;
		this.name = name;
		this.emps = emps;
	}

	public Department8() {
		super();
	}
	
	
	
}
