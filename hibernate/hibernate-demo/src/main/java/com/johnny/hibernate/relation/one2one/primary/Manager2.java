package com.johnny.hibernate.relation.one2one.primary;

public class Manager2 {

	private Integer mgrId;
	private String mgrName;
	
	private Department2 dept;

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public Department2 getDept() {
		return dept;
	}

	public void setDept(Department2 dept) {
		this.dept = dept;
	}
	
	
	
}
