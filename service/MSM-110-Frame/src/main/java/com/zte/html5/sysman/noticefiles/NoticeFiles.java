package com.zte.html5.sysman.noticefiles;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class NoticeFiles implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{NoticeFiles.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long noticeId; //公告id

	private java.lang.String fileName; //文件名称

	private java.lang.String fileUrl; //文件地址

	private java.lang.Long fileSize; //文件大小（单位K）

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

	public java.lang.Long getNoticeId()
	{
		return noticeId;
	}
	
	public void setNoticeId(java.lang.Long noticeId)
	{
		this.noticeId = noticeId;
		return;
	}

	public java.lang.String getFileName()
	{
		return fileName;
	}
	
	public void setFileName(java.lang.String fileName)
	{
		this.fileName = fileName;
		return;
	}

	public java.lang.String getFileUrl()
	{
		return fileUrl;
	}
	
	public void setFileUrl(java.lang.String fileUrl)
	{
		this.fileUrl = fileUrl;
		return;
	}

	public java.lang.Long getFileSize()
	{
		return fileSize;
	}
	
	public void setFileSize(java.lang.Long fileSize)
	{
		this.fileSize = fileSize;
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