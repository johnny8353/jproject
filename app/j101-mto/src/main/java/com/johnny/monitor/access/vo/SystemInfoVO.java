package com.johnny.monitor.access.vo;

public class SystemInfoVO {
	private Long rowId;
	private Long groupId;
	private String enviromentType;
	private String enviromentName;//
	private String ipAddr;
	private String userName;
	private String passWord;
	private int orderby;
	private String enableFlag;
	
	public String getEnviromentType() {
		return enviromentType;
	}
	public void setEnviromentType(String enviromentType) {
		this.enviromentType = enviromentType;
	}
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getEnviromentName() {
		return enviromentName;
	}
	public void setEnviromentName(String enviromentName) {
		this.enviromentName = enviromentName;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public int getOrderby() {
		return orderby;
	}
	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	@Override
	public String toString() {
		return "SystemInfoVO [rowId=" + rowId + ", groupId=" + groupId
				+ ", enviromentType=" + enviromentType + ", enviromentName="
				+ enviromentName + ", ipAddr=" + ipAddr + ", orderby="
				+ orderby + ", enableFlag=" + enableFlag + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
