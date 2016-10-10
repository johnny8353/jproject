package com.johnny.hibernate.relation.n2n;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private Integer id;
	private String name;
	
	private Set<Category> categories = new HashSet<>();
	
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
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	
}
