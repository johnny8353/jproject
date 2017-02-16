package com.zte.html5.sysman.role;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	//设置效验规则,主键字段不能为空,
	//新增的时候主键为空,使用数据库自增长特性生成值,所以这里屏蔽校验规则,
	//@NotNull(message="{Role.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String roleCode; //角色代码

	private java.lang.String roleName; //角色名称

	private java.lang.String roleCategory; //角色类型

	private java.lang.Long parentId; //角色父Id

	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新时间

	private java.lang.String enableFlag; //有效标志位

	private java.lang.Long orgId; //组织id


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.String getRoleCode()
	{
		return roleCode;
	}
	
	public void setRoleCode(java.lang.String roleCode)
	{
		this.roleCode = roleCode;
		return;
	}

	public java.lang.String getRoleName()
	{
		return roleName;
	}
	
	public void setRoleName(java.lang.String roleName)
	{
		this.roleName = roleName;
		return;
	}

	public java.lang.String getRoleCategory()
	{
		return roleCategory;
	}
	
	public void setRoleCategory(java.lang.String roleCategory)
	{
		this.roleCategory = roleCategory;
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