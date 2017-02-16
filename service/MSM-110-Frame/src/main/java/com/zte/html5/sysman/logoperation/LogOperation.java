package com.zte.html5.sysman.logoperation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LogOperation implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{LogOperation.id.NotNull}")
	private java.lang.Long id; //

	private java.lang.String logType; //

	private java.lang.String businessName; //

	private java.lang.String optType; //

	private java.lang.Long elapsedTime; //

	private java.lang.String logIp; //

	private java.lang.String logStatus; //

	private java.lang.String tableName; //

	private java.lang.String primaryValue; //

	private java.lang.String columnsContent; //

	private java.lang.String auditUrl; //

	private java.lang.Long orgId; //

	private java.lang.String createdBy; //

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.String getLogType()
	{
		return logType;
	}
	
	public void setLogType(java.lang.String logType)
	{
		this.logType = logType;
		return;
	}

	public java.lang.String getBusinessName()
	{
		return businessName;
	}
	
	public void setBusinessName(java.lang.String businessName)
	{
		this.businessName = businessName;
		return;
	}

	public java.lang.String getOptType()
	{
		return optType;
	}
	
	public void setOptType(java.lang.String optType)
	{
		this.optType = optType;
		return;
	}

	public java.lang.Long getElapsedTime()
	{
		return elapsedTime;
	}
	
	public void setElapsedTime(java.lang.Long elapsedTime)
	{
		this.elapsedTime = elapsedTime;
		return;
	}

	public java.lang.String getLogIp()
	{
		return logIp;
	}
	
	public void setLogIp(java.lang.String logIp)
	{
		this.logIp = logIp;
		return;
	}

	public java.lang.String getLogStatus()
	{
		return logStatus;
	}
	
	public void setLogStatus(java.lang.String logStatus)
	{
		this.logStatus = logStatus;
		return;
	}

	public java.lang.String getTableName()
	{
		return tableName;
	}
	
	public void setTableName(java.lang.String tableName)
	{
		this.tableName = tableName;
		return;
	}

	public java.lang.String getPrimaryValue()
	{
		return primaryValue;
	}
	
	public void setPrimaryValue(java.lang.String primaryValue)
	{
		this.primaryValue = primaryValue;
		return;
	}

	public java.lang.String getColumnsContent()
	{
		return columnsContent;
	}
	
	public void setColumnsContent(java.lang.String columnsContent)
	{
		this.columnsContent = columnsContent;
		return;
	}

	public java.lang.String getAuditUrl()
	{
		return auditUrl;
	}
	
	public void setAuditUrl(java.lang.String auditUrl)
	{
		this.auditUrl = auditUrl;
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

	public java.lang.String getCreatedBy()
	{
		return createdBy;
	}
	
	public void setCreatedBy(java.lang.String createdBy)
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
}