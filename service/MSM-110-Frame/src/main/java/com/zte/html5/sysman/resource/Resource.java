package com.zte.html5.sysman.resource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resource implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Resource.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long parentId; //资源父Id

	private java.lang.String parentName; // 父资源名称
	
	private java.lang.String resourceType; //资源类型

	private java.lang.String resourceCode; //资源代码

	private java.lang.String resourceName; //资源名称

	private java.lang.String resourceValue; //资源值
	
	private java.lang.String iconValue; //资源图标样式

	private java.lang.String encryptFlag; //是否强制加密

	private java.lang.String privilegeFlag; //是否鉴权

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

	private Resource parentMenu; 	//  
	
	private List<Resource> subMenu; // 
	
	private boolean open = true;// 默认展开
	
	private boolean checked; // =true; // 默认勾选
	
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

	
	public java.lang.String getParentName() {
		return parentName;
	}

	public void setParentName(java.lang.String parentName) {
		this.parentName = parentName;
	}

	public java.lang.String getResourceType()
	{
		return resourceType;
	}
	
	public void setResourceType(java.lang.String resourceType)
	{
		this.resourceType = resourceType;
		return;
	}

	public java.lang.String getResourceCode()
	{
		return resourceCode;
	}
	
	public void setResourceCode(java.lang.String resourceCode)
	{
		this.resourceCode = resourceCode;
		return;
	}

	public java.lang.String getResourceName()
	{
		return resourceName;
	}
	
	public void setResourceName(java.lang.String resourceName)
	{
		this.resourceName = resourceName;
		return;
	}

	public java.lang.String getResourceValue()
	{
		return resourceValue;
	}
	
	public void setResourceValue(java.lang.String resourceValue)
	{
		this.resourceValue = resourceValue;
		return;
	}
	
	public java.lang.String getIconValue()
	{
		return iconValue;
	}
	
	public void setIconValue(java.lang.String iconValue)
	{
		this.iconValue = iconValue;
		return;
	}

	public java.lang.String getEncryptFlag()
	{
		return encryptFlag;
	}
	
	public void setEncryptFlag(java.lang.String encryptFlag)
	{
		this.encryptFlag = encryptFlag;
		return;
	}

	public java.lang.String getPrivilegeFlag()
	{
		return privilegeFlag;
	}
	
	public void setPrivilegeFlag(java.lang.String privilegeFlag)
	{
		this.privilegeFlag = privilegeFlag;
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

	public Resource getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Resource parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<Resource> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Resource> subMenu) {
		this.subMenu = subMenu;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}