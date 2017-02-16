package com.zte.html5.sysman.sms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Sms implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Sms.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.String relationId; //关联ID(所从属的对象)

	private java.lang.String smsType; //短信类型(每种短信定义一个常量)

	private java.lang.String receiptName; //收件人姓名

	private java.lang.String receiptCode; //收件人工号

	private java.lang.String receiptNumber; //收件人手机号

	private java.lang.String smsBody; //信息内容

	private java.lang.Long smsLevel; //信息优先级

	private java.lang.String isPromptly; //是否立即发送

	private java.lang.String sendSuccess; //是否发送成功

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date sendTime; //发送时间

	private java.lang.String memo; //备注（用于保存失败原因等信息）

	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建日期

	private java.lang.Long lastUpdatedBy; //最后更新人

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

	public java.lang.String getSmsType()
	{
		return smsType;
	}
	
	public void setSmsType(java.lang.String smsType)
	{
		this.smsType = smsType;
		return;
	}

	public java.lang.String getReceiptName()
	{
		return receiptName;
	}
	
	public void setReceiptName(java.lang.String receiptName)
	{
		this.receiptName = receiptName;
		return;
	}

	public java.lang.String getReceiptCode()
	{
		return receiptCode;
	}
	
	public void setReceiptCode(java.lang.String receiptCode)
	{
		this.receiptCode = receiptCode;
		return;
	}

	public java.lang.String getReceiptNumber()
	{
		return receiptNumber;
	}
	
	public void setReceiptNumber(java.lang.String receiptNumber)
	{
		this.receiptNumber = receiptNumber;
		return;
	}

	public java.lang.String getSmsBody()
	{
		return smsBody;
	}
	
	public void setSmsBody(java.lang.String smsBody)
	{
		this.smsBody = smsBody;
		return;
	}

	public java.lang.Long getSmsLevel()
	{
		return smsLevel;
	}
	
	public void setSmsLevel(java.lang.Long smsLevel)
	{
		this.smsLevel = smsLevel;
		return;
	}

	public java.lang.String getIsPromptly()
	{
		return isPromptly;
	}
	
	public void setIsPromptly(java.lang.String isPromptly)
	{
		this.isPromptly = isPromptly;
		return;
	}

	public java.lang.String getSendSuccess()
	{
		return sendSuccess;
	}
	
	public void setSendSuccess(java.lang.String sendSuccess)
	{
		this.sendSuccess = sendSuccess;
		return;
	}

	public java.util.Date getSendTime()
	{
		return sendTime;
	}
	
	public void setSendTime(java.util.Date sendTime)
	{
		this.sendTime = sendTime;
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