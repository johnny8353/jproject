package com.zte.html5.sysman.notice;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Notice.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String title; //标题

	private java.lang.String content; //内容

	private java.lang.String category; //一级分类

	private java.lang.String subCategory; //二级分类

	private java.lang.String publisher; //发布人

	private java.lang.String status; //发布状态

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date issuintTime; //发布时间

	private java.lang.String importance; //重要性标识

	private java.lang.Long priority; //优先级（置顶级别）

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date effectiveDate; //生效日期

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date expirationDate; //失效日期

	private java.lang.String createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.String lastUpdatedBy; //最后更新人

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

	public java.lang.String getTitle()
	{
		return title;
	}
	
	public void setTitle(java.lang.String title)
	{
		this.title = title;
		return;
	}

	public java.lang.String getContent()
	{
		return content;
	}
	
	public void setContent(java.lang.String content)
	{
		this.content = content;
		return;
	}

	public java.lang.String getCategory()
	{
		return category;
	}
	
	public void setCategory(java.lang.String category)
	{
		this.category = category;
		return;
	}

	public java.lang.String getSubCategory()
	{
		return subCategory;
	}
	
	public void setSubCategory(java.lang.String subCategory)
	{
		this.subCategory = subCategory;
		return;
	}

	public java.lang.String getPublisher()
	{
		return publisher;
	}
	
	public void setPublisher(java.lang.String publisher)
	{
		this.publisher = publisher;
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

	public java.util.Date getIssuintTime()
	{
		return issuintTime;
	}
	
	public void setIssuintTime(java.util.Date issuintTime)
	{
		this.issuintTime = issuintTime;
		return;
	}

	public java.lang.String getImportance()
	{
		return importance;
	}
	
	public void setImportance(java.lang.String importance)
	{
		this.importance = importance;
		return;
	}

	public java.lang.Long getPriority()
	{
		return priority;
	}
	
	public void setPriority(java.lang.Long priority)
	{
		this.priority = priority;
		return;
	}

	public java.util.Date getEffectiveDate()
	{
		return effectiveDate;
	}
	
	public void setEffectiveDate(java.util.Date effectiveDate)
	{
		this.effectiveDate = effectiveDate;
		return;
	}

	public java.util.Date getExpirationDate()
	{
		return expirationDate;
	}
	
	public void setExpirationDate(java.util.Date expirationDate)
	{
		this.expirationDate = expirationDate;
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

	public java.lang.String getLastUpdatedBy()
	{
		return lastUpdatedBy;
	}
	
	public void setLastUpdatedBy(java.lang.String lastUpdatedBy)
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