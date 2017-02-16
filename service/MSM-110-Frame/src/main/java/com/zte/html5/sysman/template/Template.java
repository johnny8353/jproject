package com.zte.html5.sysman.template;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Template implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Template.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String guid; //主键

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

	private java.lang.Long deptId; //部门ID（部门表主键）

	private java.lang.Long userId; //部门ID（部门表主键）

	private java.lang.String xxCode; //

	private java.lang.String xxType; //

	private java.lang.String xxName; //

	private java.lang.String memo; //


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.String getGuid()
	{
		return guid;
	}
	
	public void setGuid(java.lang.String guid)
	{
		this.guid = guid;
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

	public java.lang.Long getDeptId()
	{
		return deptId;
	}
	
	public void setDeptId(java.lang.Long deptId)
	{
		this.deptId = deptId;
		return;
	}

	public java.lang.Long getUserId()
	{
		return userId;
	}
	
	public void setUserId(java.lang.Long userId)
	{
		this.userId = userId;
		return;
	}

	public java.lang.String getXxCode()
	{
		return xxCode;
	}
	
	public void setXxCode(java.lang.String xxCode)
	{
		this.xxCode = xxCode;
		return;
	}

	public java.lang.String getXxType()
	{
		return xxType;
	}
	
	public void setXxType(java.lang.String xxType)
	{
		this.xxType = xxType;
		return;
	}

	public java.lang.String getXxName()
	{
		return xxName;
	}
	
	public void setXxName(java.lang.String xxName)
	{
		this.xxName = xxName;
		return;
	}

	public java.lang.String getMemo()
	{
		return memo;
	}
	
	public void setMemo(java.lang.String memo)
	{
		this.memo = memo;
		return;
	}
}