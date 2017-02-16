package com.zte.html5.sysman.loginlog;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{LoginLog.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long loginUserId; //登陆用户ID

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date loginTime; //登陆时间

	private java.lang.String loginMsg; //登陆信息

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

	public java.lang.Long getLoginUserId()
	{
		return loginUserId;
	}
	
	public void setLoginUserId(java.lang.Long loginUserId)
	{
		this.loginUserId = loginUserId;
		return;
	}

	public java.util.Date getLoginTime()
	{
		return loginTime;
	}
	
	public void setLoginTime(java.util.Date loginTime)
	{
		this.loginTime = loginTime;
		return;
	}

	public java.lang.String getLoginMsg()
	{
		return loginMsg;
	}
	
	public void setLoginMsg(java.lang.String loginMsg)
	{
		this.loginMsg = loginMsg;
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