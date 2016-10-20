package com.johnny.monitor.access.vo;

import javax.persistence.Entity;

public class SystemGroupVO {
	private Long rowId;
	private String sysType;
	private String sysCode;
	private String sysName;//SiebelApp
	private String className;//监控使用的类名
	private String devMailto;//开发邮件接受者
	private String testMailto;//测试邮件接受者
	private String recMailto;//仿真邮件接受者
	private String prodMailto;//生产邮件接受者
	private String urlParam;//url 地址
	private int orderBy;//
	private String enableFlag;
	
	public String getSysType() {
		return sysType;
	}
	public void setSysType(String sysType) {
		this.sysType = sysType;
	}
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDevMailto() {
		return devMailto;
	}
	public void setDevMailto(String devMailto) {
		this.devMailto = devMailto;
	}
	public String getTestMailto() {
		return testMailto;
	}
	public void setTestMailto(String testMailto) {
		this.testMailto = testMailto;
	}
	public String getRecMailto() {
		return recMailto;
	}
	public void setRecMailto(String recMailto) {
		this.recMailto = recMailto;
	}
	public String getProdMailto() {
		return prodMailto;
	}
	public void setProdMailto(String prodMailto) {
		this.prodMailto = prodMailto;
	}
	public String getUrlParam() {
		return urlParam;
	}
	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	@Override
	public String toString() {
		return "SystemGroupVO [rowId=" + rowId + ", sysType=" + sysType
				+ ", sysCode=" + sysCode + ", sysName=" + sysName
				+ ", className=" + className + ", devMailto=" + devMailto
				+ ", testMailto=" + testMailto + ", recMailto=" + recMailto
				+ ", prodMailto=" + prodMailto + ", urlParam=" + urlParam
				+ ", orderBy=" + orderBy + ", enableFlag=" + enableFlag + "]";
	}

}
