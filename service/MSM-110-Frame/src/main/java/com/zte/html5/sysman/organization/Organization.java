package com.zte.html5.sysman.organization;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Organization.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long parentId; //父组织ID

	private java.lang.String orgCode; //组织编码

	private java.lang.String orgName; //组织名称（如不从多语表关联，可直接使用此字段）

	private java.lang.String orgNameAbbr; //组织名称缩写

	private java.lang.String orgType; //组织类型（字典编码）

	private java.lang.String isTopOrg; //是否顶层组织
	
	private java.lang.String standardMomey; //本位币

	private java.lang.String dataSource; //数据来源（字典编码，自动、手动）

	private java.lang.String status; //状态（启用、禁用）

	private java.lang.String memo; //备注

	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新时间

	private java.lang.String enableFlag; //有效标志位

	private java.lang.Long tenantId; //租户ID(FRM_TENANT表主键)

	
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

	public java.lang.String getOrgCode()
	{
		return orgCode;
	}
	
	public void setOrgCode(java.lang.String orgCode)
	{
		this.orgCode = orgCode;
		return;
	}

	public java.lang.String getOrgName()
	{
		return orgName;
	}
	
	public void setOrgName(java.lang.String orgName)
	{
		this.orgName = orgName;
		return;
	}

	public java.lang.String getOrgNameAbbr()
	{
		return orgNameAbbr;
	}
	
	public void setOrgNameAbbr(java.lang.String orgNameAbbr)
	{
		this.orgNameAbbr = orgNameAbbr;
		return;
	}

	public java.lang.String getOrgType()
	{
		return orgType;
	}
	
	public void setOrgType(java.lang.String orgType)
	{
		this.orgType = orgType;
		return;
	}

	public java.lang.String getIsTopOrg()
	{
		return isTopOrg;
	}
	
	public void setIsTopOrg(java.lang.String isTopOrg)
	{
		this.isTopOrg = isTopOrg;
		return;
	}

	public java.lang.String getDataSource()
	{
		return dataSource;
	}
	
	public void setDataSource(java.lang.String dataSource)
	{
		this.dataSource = dataSource;
		return;
	}

	public java.lang.String getStatus()
	{
		return status;
	}
	
	public void setStatus(java.lang.String status)
	{
		this.status = status;
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

	public java.lang.Long getTenantId()
	{
		return tenantId;
	}
	
	public void setTenantId(java.lang.Long tenantId)
	{
		this.tenantId = tenantId;
		return;
	}


	public java.lang.String getStandardMomey() {
		return standardMomey;
	}

	public void setStandardMomey(java.lang.String standardMomey) {
		this.standardMomey = standardMomey;
	}
	
	
}