package com.zte.html5.sysman.email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Email.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String relationId; //关联ID(所从属的对象)

	private java.lang.String sender; //发件人

	private java.lang.String recipient; //收件人

	private java.lang.String cc; //抄送

	private java.lang.String bcc; //密送

	private java.lang.String subject; //主题

	private java.lang.String subjectEn; //主题(英文)

	private java.lang.String content; //内容

	private java.lang.String contentEn; //内容(英文)

	private java.lang.Long mailLevel; //优先级

	private java.lang.String sendFlag; //发送状态（待发送，发送成功，发送失败）

	private java.lang.Long mergeCount; //合并次数

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

	public java.lang.String getRelationId()
	{
		return relationId;
	}
	
	public void setRelationId(java.lang.String relationId)
	{
		this.relationId = relationId;
		return;
	}

	public java.lang.String getSender()
	{
		return sender;
	}
	
	public void setSender(java.lang.String sender)
	{
		this.sender = sender;
		return;
	}

	public java.lang.String getRecipient()
	{
		return recipient;
	}
	
	public void setRecipient(java.lang.String recipient)
	{
		this.recipient = recipient;
		return;
	}

	public java.lang.String getCc()
	{
		return cc;
	}
	
	public void setCc(java.lang.String cc)
	{
		this.cc = cc;
		return;
	}

	public java.lang.String getBcc()
	{
		return bcc;
	}
	
	public void setBcc(java.lang.String bcc)
	{
		this.bcc = bcc;
		return;
	}

	public java.lang.String getSubject()
	{
		return subject;
	}
	
	public void setSubject(java.lang.String subject)
	{
		this.subject = subject;
		return;
	}

	public java.lang.String getSubjectEn()
	{
		return subjectEn;
	}
	
	public void setSubjectEn(java.lang.String subjectEn)
	{
		this.subjectEn = subjectEn;
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

	public java.lang.String getContentEn()
	{
		return contentEn;
	}
	
	public void setContentEn(java.lang.String contentEn)
	{
		this.contentEn = contentEn;
		return;
	}

	public java.lang.Long getMailLevel()
	{
		return mailLevel;
	}
	
	public void setMailLevel(java.lang.Long mailLevel)
	{
		this.mailLevel = mailLevel;
		return;
	}

	public java.lang.String getSendFlag()
	{
		return sendFlag;
	}
	
	public void setSendFlag(java.lang.String sendFlag)
	{
		this.sendFlag = sendFlag;
		return;
	}

	public java.lang.Long getMergeCount()
	{
		return mergeCount;
	}
	
	public void setMergeCount(java.lang.Long mergeCount)
	{
		this.mergeCount = mergeCount;
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