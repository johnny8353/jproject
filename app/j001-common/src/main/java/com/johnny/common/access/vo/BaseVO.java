package com.johnny.common.access.vo;

import java.util.Date;

public class BaseVO {
	private Date createDate;
	private Date lastUpdDate;
	private Date dbLastUpd;
	private Long rowId;
	private Long modificationNum;
	private String createdBy;
	private String lastUpdBy;
	private String conflictId;
	private String dbLastUpdSrc;
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
	public Date getDbLastUpd() {
		return dbLastUpd;
	}
	public void setDbLastUpd(Date dbLastUpd) {
		this.dbLastUpd = dbLastUpd;
	}
	public Long getModificationNum() {
		return modificationNum;
	}
	public void setModificationNum(Long modificationNum) {
		this.modificationNum = modificationNum;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastUpdBy() {
		return lastUpdBy;
	}
	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	public String getConflictId() {
		return conflictId;
	}
	public void setConflictId(String conflictId) {
		this.conflictId = conflictId;
	}
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getDbLastUpdSrc() {
		return dbLastUpdSrc;
	}
	public void setDbLastUpdSrc(String dbLastUpdSrc) {
		this.dbLastUpdSrc = dbLastUpdSrc;
	}
	
	
	
}
