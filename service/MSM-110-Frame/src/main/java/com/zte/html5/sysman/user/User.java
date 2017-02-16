package com.zte.html5.sysman.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{User.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String name; //用户名
	
	private java.lang.String account; //登陆帐号

	private java.lang.String pwd; //密码

	private java.lang.String token; //会话令牌

	private java.lang.String enckey; //加密密钥1

	private java.lang.String enciv; //加密密钥2

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date effectiveDate; //生效日期

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date expirationDate; //失效日期

	private java.lang.String email; //EMAIL

	private java.lang.String mobileNo; //手机号码

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


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.String getName()
	{
		return name;
	}
	
	public void setName(java.lang.String name)
	{
		this.name = name;
		return;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getPwd()
	{
		return pwd;
	}
	
	public void setPwd(java.lang.String pwd)
	{
		this.pwd = pwd;
		return;
	}

	public java.lang.String getToken()
	{
		return token;
	}
	
	public void setToken(java.lang.String token)
	{
		this.token = token;
		return;
	}

	public java.lang.String getEnckey()
	{
		return enckey;
	}
	
	public void setEnckey(java.lang.String enckey)
	{
		this.enckey = enckey;
		return;
	}

	public java.lang.String getEnciv()
	{
		return enciv;
	}
	
	public void setEnciv(java.lang.String enciv)
	{
		this.enciv = enciv;
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

	public java.lang.String getEmail()
	{
		return email;
	}
	
	public void setEmail(java.lang.String email)
	{
		this.email = email;
		return;
	}

	public java.lang.String getMobileNo()
	{
		return mobileNo;
	}
	
	public void setMobileNo(java.lang.String mobileNo)
	{
		this.mobileNo = mobileNo;
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