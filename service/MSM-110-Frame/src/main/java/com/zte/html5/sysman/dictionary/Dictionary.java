package com.zte.html5.sysman.dictionary;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Dictionary implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Dictionary.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long parentId; //字典类型

	private java.lang.String parentDictCode; // 类型名称
	
	private java.lang.String dictCode; //字典代码

	private java.lang.String dictName; //字典名称

	private java.lang.String dictValue; //字典值

	private java.lang.String viewLevel; //访问级别
	
	private java.lang.String levelName; //级别名称
	
	
	private java.lang.Long orderBy; //排序

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date effectiveDate; //生效日期

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date expirationDate; //失效日期

	private java.lang.String remark; //备注

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

	public java.lang.Long getParentId()
	{
		return parentId;
	}
	
	public void setParentId(java.lang.Long parentId)
	{
		this.parentId = parentId;
		return;
	}

		
	public java.lang.String getParentDictCode() {
		return parentDictCode;
	}

	public void setParentDictCode(java.lang.String parentDictCode) {
		this.parentDictCode = parentDictCode;
	}

	public java.lang.String getDictCode()
	{
		return dictCode;
	}
	
	public void setDictCode(java.lang.String dictCode)
	{
		this.dictCode = dictCode;
		return;
	}

	public java.lang.String getDictName()
	{
		return dictName;
	}
	
	public void setDictName(java.lang.String dictName)
	{
		this.dictName = dictName;
		return;
	}

	public java.lang.String getDictValue()
	{
		return dictValue;
	}
	
	public void setDictValue(java.lang.String dictValue)
	{
		this.dictValue = dictValue;
		return;
	}

	public java.lang.String getViewLevel()
	{
		return viewLevel;
	}
	
	public void setViewLevel(java.lang.String viewLevel)
	{
		this.viewLevel = viewLevel;
		return;
	}
	
	public java.lang.String getLevelName() {
		return levelName;
	}

	public void setLevelName(java.lang.String levelName) {
		this.levelName = levelName;
	}

	public java.lang.Long getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(java.lang.Long orderBy) {
		this.orderBy = orderBy;
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

	public java.lang.String getRemark()
	{
		return remark;
	}
	
	public void setRemark(java.lang.String remark)
	{
		this.remark = remark;
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