package com.zte.html5.sysman.attachment;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Attachment implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Attachment.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String relationId; //关联ID(所从属的对象)

	private java.lang.String attachType; //附件类型

	private java.lang.String attachTitle; //附件标题

	private java.lang.Long attachPathId; //附件路径信息表主键

	private java.lang.String path; //附件路径（相对路径）

	private java.lang.String fileName; //附件文件名

	private java.lang.String extendedName; //扩展名

	private java.lang.Long size; //附件大小

	private java.lang.String oldFileName; //附件原文件名

	private java.lang.String memo; //备注

	private java.lang.String fileCategory; //文件类别

	private java.lang.String fileType; //文件类型

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

	private java.lang.String attachGroupId; //附件分组UUID
	

	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}

	public java.lang.String getRelationId()
	{
		return relationId;
	}
	
	public void setRelationId(java.lang.String relationId)
	{
		this.relationId = relationId;
		return;
	}

	public java.lang.String getAttachType()
	{
		return attachType;
	}
	
	public void setAttachType(java.lang.String attachType)
	{
		this.attachType = attachType;
		return;
	}

	public java.lang.String getAttachTitle()
	{
		return attachTitle;
	}
	
	public void setAttachTitle(java.lang.String attachTitle)
	{
		this.attachTitle = attachTitle;
		return;
	}

	public java.lang.Long getAttachPathId()
	{
		return attachPathId;
	}
	
	public void setAttachPathId(java.lang.Long attachPathId)
	{
		this.attachPathId = attachPathId;
		return;
	}

	public java.lang.String getPath()
	{
		return path;
	}
	
	public void setPath(java.lang.String path)
	{
		this.path = path;
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

	public java.lang.String getExtendedName()
	{
		return extendedName;
	}
	
	public void setExtendedName(java.lang.String extendedName)
	{
		this.extendedName = extendedName;
		return;
	}

	public java.lang.Long getSize()
	{
		return size;
	}
	
	public void setSize(java.lang.Long size)
	{
		this.size = size;
		return;
	}

	public java.lang.String getOldFileName()
	{
		return oldFileName;
	}
	
	public void setOldFileName(java.lang.String oldFileName)
	{
		this.oldFileName = oldFileName;
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

	public java.lang.String getFileCategory()
	{
		return fileCategory;
	}
	
	public void setFileCategory(java.lang.String fileCategory)
	{
		this.fileCategory = fileCategory;
		return;
	}

	public java.lang.String getFileType()
	{
		return fileType;
	}
	
	public void setFileType(java.lang.String fileType)
	{
		this.fileType = fileType;
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

	public java.lang.String getAttachGroupId() {
		return attachGroupId;
	}

	public void setAttachGroupId(java.lang.String attachGroupId) {
		this.attachGroupId = attachGroupId;
	}



	
	
}