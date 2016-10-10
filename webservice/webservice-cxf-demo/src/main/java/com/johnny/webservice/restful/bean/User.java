package com.johnny.webservice.restful.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Users")
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String address;
    
    //getter/setter
    
    @Override
    public String toString() {
        return this.id + "#" + this.name + "#" + this.email + "#" + this.address;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}