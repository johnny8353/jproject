package com.zte.html5.sysman.function;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Function implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Function.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long resourceId; //资源id
	
	private java.lang.String resourceName; //资源名称
	
	private java.lang.String functionCode; //功能代码

	private java.lang.String functionName; //功能名称

	private java.lang.Long createdBy; //创建人
	
	private java.lang.String createdName; //创建人名称

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新时间

	private java.lang.String enableFlag; //有效标志位

	private java.lang.Long orgId; //组织ID（组织表主键）

	private java.lang.String functionType; // 功能类型

	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
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

	
	public java.lang.String getResourceName() {
		return resourceName;
	}

	public void setResourceName(java.lang.String resourceName) {
		this.resourceName = resourceName;
	}

	public java.lang.String getFunctionCode()
	{
		return functionCode;
	}
	
	public void setFunctionCode(java.lang.String functionCode)
	{
		this.functionCode = functionCode;
		return;
	}

	public java.lang.String getFunctionName()
	{
		return functionName;
	}
	
	public void setFunctionName(java.lang.String functionName)
	{
		this.functionName = functionName;
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

	public java.lang.String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(java.lang.String functionType) {
		this.functionType = functionType;
	}

	/**
	 * @return the createdName
	 */
	public java.lang.String getCreatedName() {
		return createdName;
	}

	/**
	 * @param createdName the createdName to set
	 */
	public void setCreatedName(java.lang.String createdName) {
		this.createdName = createdName;
	}

	
	
}