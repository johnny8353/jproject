package com.johnny.data.access.vo;

import com.johnny.common.access.vo.BaseVO;

public class SystemPreferenceVO extends BaseVO{
	private String name;
	private String val;
	private String comments;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SystemPreferenceVO [name=" + name + ", val=" + val
				+ ", comments=" + comments + ", type=" + type
				+ ", getCreateDate()=" + getCreateDate() + ", getRowId()="
				+ getRowId() + "]";
	}
	
	
}
