package com.johnny.monitor.access.vo;

import java.util.Date;

public class SystemMonitorInstanceVO {
	private Long rowId;
	private Long groupId;
	private Long systemId;
	private String batchNum;
	private String result;
	private String resultMessage;
	private Date createDate;
	private Date lastUpdDate;
	
	
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
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
	public Long getSystemId() {
		return systemId;
	}
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdDate() {
		return lastUpdDate;
	}
	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}
	@Override
	public String toString() {
		return "SystemMonitorInstanceVO [rowId=" + rowId + ", groupId="
				+ groupId + ", systemId=" + systemId + ", result=" + result
				+ ", resultMessage=" + resultMessage + ", createDate="
				+ createDate + ", lastUpdDate=" + lastUpdDate + "]";
	}
	
	
	
}
