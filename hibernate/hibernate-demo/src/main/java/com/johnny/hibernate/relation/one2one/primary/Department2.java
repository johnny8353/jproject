package com.johnny.hibernate.relation.one2one.primary;

public class Department2 {

	private Integer deptId;
	private String deptName;
	
	private Manager2 mgr;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager2 getMgr() {
		return mgr;
	}

	public void setMgr(Manager2 mgr) {
		this.mgr = mgr;
	}
	
	
	
}
