package com.zte.html5.sysman.roleresource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class RoleResource implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{RoleResource.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long roleId; //角色ID

	private java.lang.Long resourceId; //资源ID
	
	private java.lang.Long parentId; //资源父ID
	
	private java.lang.String resourceName; //资源名称
	
	private java.lang.String resourceCode; // 资源编码
	
	private java.lang.String functionCodes; //功能代码（功能表编码以英文逗号分隔）

	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新时间

	private java.lang.String enableFlag; //有效标志位

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

	public java.lang.Long getRoleId()
	{
		return roleId;
	}
	
	public void setRoleId(java.lang.Long roleId)
	{
		this.roleId = roleId;
		return;
	}

	public java.lang.Long getResourceId()
	{
		return resourceId;
	}
	
	public void setResourceId(java.lang.Long resourceId)
	{
		this.resourceId = resourceId;
		return;
	}
	
	public java.lang.Long getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.String getResourceName() {
		return resourceName;
	}

	public void setResourceName(java.lang.String resourceName) {
		this.resourceName = resourceName;
	}

	public java.lang.String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(java.lang.String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public java.lang.String getFunctionCodes()
	{
		return functionCodes;
	}
	
	public void setFunctionCodes(java.lang.String functionCodes)
	{
		this.functionCodes = functionCodes;
		return;
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