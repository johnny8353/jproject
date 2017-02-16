package com.zte.html5.sysman.basdepartment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BasDepartment implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{BasDepartment.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long parentId; //父部门Id

	private java.lang.String deptCode; //部门编码

	private java.lang.String deptName; //部门名称

	private java.lang.Long deptLevel; //部门层级

	private java.lang.Long companyId; //公司ID
	
	private java.lang.String dataSource; //数据来源
	
	private java.lang.String status; //状态
	
	private java.lang.String memo; //备注
	
	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新时间

	private java.lang.String enableFlag; //有效标识

	private java.lang.Long orgId; //组织ID（组织表主键）


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.Long getParentId()
	{
		return parentId;
	}
	
	public void setParentId(java.lang.Long parentId)
	{
		this.parentId = parentId;
		return;
	}

	public java.lang.String getDeptCode()
	{
		return deptCode;
	}
	
	public void setDeptCode(java.lang.String deptCode)
	{
		this.deptCode = deptCode;
		return;
	}

	public java.lang.String getDeptName()
	{
		return deptName;
	}
	
	public void setDeptName(java.lang.String deptName)
	{
		this.deptName = deptName;
		return;
	}

	public java.lang.Long getDeptLevel()
	{
		return deptLevel;
	}
	
	public void setDeptLevel(java.lang.Long deptLevel)
	{
		this.deptLevel = deptLevel;
		return;
	}

	public java.lang.Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}

	public java.lang.String getDataSource() {
		return dataSource;
	}

	public void setDataSource(java.lang.String dataSource) {
		this.dataSource = dataSource;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.Long getCreatedBy()
	{
		return createdBy;
	}
	
	public void setCreatedBy(java.lang.Long createdBy)
	{
		this.createdBy = createdBy;
		return;
	}

	public java.util.Date getCreatedDate()
	{
		return createdDate;
	}
	
	public void setCreatedDate(java.util.Date createdDate)
	{
		this.createdDate = createdDate;
		return;
	}

	public java.lang.Long getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	
	public void setLastUpdatedBy(java.lang.Long lastUpdatedBy)
	{
		this.lastUpdatedBy = lastUpdatedBy;
		return;
	}

	public java.util.Date getLastUpdatedDate()
	{
		return lastUpdatedDate;
	}
	
	public void setLastUpdatedDate(java.util.Date lastUpdatedDate)
	{
		this.lastUpdatedDate = lastUpdatedDate;
		return;
	}

	public java.lang.String getEnableFlag()
	{
		return enableFlag;
	}
	
	public void setEnableFlag(java.lang.String enableFlag)
	{
		this.enableFlag = enableFlag;
		return;
	}

	public java.lang.Long getOrgId()
	{
		return orgId;
	}
	
	public void setOrgId(java.lang.Long orgId)
	{
		this.orgId = orgId;
		return;
	}
}