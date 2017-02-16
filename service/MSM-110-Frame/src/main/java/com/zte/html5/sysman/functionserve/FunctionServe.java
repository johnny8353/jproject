package com.zte.html5.sysman.functionserve;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zte.html5.sysman.dictionary.Dictionary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FunctionServe implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{FunctionServe.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long functionId; //资源id
	
	private java.lang.Long dictId; // 字典ID
	
	private java.lang.String dictCode; // 字典编码
	
	private java.lang.String dictName; // 编码名称
	
	private java.lang.String dictValue; // 编码名称
	
	private List<Dictionary> dictList;	// 快速编码对象

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

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(java.lang.Long functionId) {
		this.functionId = functionId;
	}


	public java.lang.Long getDictId() {
		return dictId;
	}

	public void setDictId(java.lang.Long dictId) {
		this.dictId = dictId;
	}

	public java.lang.String getDictCode() {
		return dictCode;
	}

	public void setDictCode(java.lang.String dictCode) {
		this.dictCode = dictCode;
	}

	public java.lang.String getDictName() {
		return dictName;
	}

	public void setDictName(java.lang.String dictName) {
		this.dictName = dictName;
	}

	public java.lang.String getDictValue() {
		return dictValue;
	}

	public void setDictValue(java.lang.String dictValue) {
		this.dictValue = dictValue;
	}

	public List<Dictionary> getDictList() {
		return dictList;
	}

	public void setDictList(List<Dictionary> dictList) {
		this.dictList = dictList;
	}

	public java.lang.Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(java.lang.Long createdBy) {
		this.createdBy = createdBy;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.lang.Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(java.lang.Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public java.util.Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public java.lang.String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(java.lang.String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public java.lang.Long getOrgId() {
		return orgId;
	}

	public void setOrgId(java.lang.Long orgId) {
		this.orgId = orgId;
	}


	
	
	
}