package com.zte.html5.sysman.attachmentpath;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AttachmentPath implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{AttachmentPath.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String actualPath; //附件物理路径

	private java.lang.String userName; //用户名

	private java.lang.String password; //密码

	private java.lang.String port; //端口号

	private java.lang.String memo; //备注

	private java.lang.Long createdBy; //创建者

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建日期

	private java.lang.Long lastUpdatedBy; //最后更新者

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新日期

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

	public java.lang.String getActualPath()
	{
		return actualPath;
	}
	
	public void setActualPath(java.lang.String actualPath)
	{
		this.actualPath = actualPath;
		return;
	}

	public java.lang.String getUserName()
	{
		return userName;
	}
	
	public void setUserName(java.lang.String userName)
	{
		this.userName = userName;
		return;
	}

	public java.lang.String getPassword()
	{
		return password;
	}
	
	public void setPassword(java.lang.String password)
	{
		this.password = password;
		return;
	}

	public java.lang.String getPort()
	{
		return port;
	}
	
	public void setPort(java.lang.String port)
	{
		this.port = port;
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