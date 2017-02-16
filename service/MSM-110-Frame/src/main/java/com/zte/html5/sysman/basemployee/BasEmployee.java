package com.zte.html5.sysman.basemployee;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BasEmployee implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{BasEmployee.id.NotNull}")
	private java.lang.Long id; //主键

	private java.lang.Long userId; //用户ID（用户表主键）

	private java.lang.String employeeName; //员工姓名

	private java.lang.String employeeNo; //员工短工号

	private java.lang.String employeeNoFull; //员工长工号

	private java.lang.String employeeComputerNo; //员工电脑号

	private java.lang.String employeeType; //员工类型

	private java.lang.Long deptId; //部门ID（部门表主键）

	private java.lang.String status; //状态

	private java.lang.String email; //邮件地址

	private java.lang.String mobileNumber; //用户手机号

	private java.lang.String nationlity; //国籍

	private java.lang.Long createdBy; //创建人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdDate; //创建时间

	private java.lang.Long lastUpdatedBy; //最后更新人

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date lastUpdatedDate; //最后更新日期

	private java.lang.String enableFlag; //是否有效

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

	public java.lang.Long getUserId()
	{
		return userId;
	}
	
	public void setUserId(java.lang.Long userId)
	{
		this.userId = userId;
		return;
	}

	public java.lang.String getEmployeeName()
	{
		return employeeName;
	}
	
	public void setEmployeeName(java.lang.String employeeName)
	{
		this.employeeName = employeeName;
		return;
	}

	public java.lang.String getEmployeeNo()
	{
		return employeeNo;
	}
	
	public void setEmployeeNo(java.lang.String employeeNo)
	{
		this.employeeNo = employeeNo;
		return;
	}

	public java.lang.String getEmployeeNoFull()
	{
		return employeeNoFull;
	}
	
	public void setEmployeeNoFull(java.lang.String employeeNoFull)
	{
		this.employeeNoFull = employeeNoFull;
		return;
	}

	public java.lang.String getEmployeeComputerNo()
	{
		return employeeComputerNo;
	}
	
	public void setEmployeeComputerNo(java.lang.String employeeComputerNo)
	{
		this.employeeComputerNo = employeeComputerNo;
		return;
	}

	public java.lang.String getEmployeeType()
	{
		return employeeType;
	}
	
	public void setEmployeeType(java.lang.String employeeType)
	{
		this.employeeType = employeeType;
		return;
	}

	public java.lang.Long getDeptId()
	{
		return deptId;
	}
	
	public void setDeptId(java.lang.Long deptId)
	{
		this.deptId = deptId;
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

	public java.lang.String getEmail()
	{
		return email;
	}
	
	public void setEmail(java.lang.String email)
	{
		this.email = email;
		return;
	}

	public java.lang.String getMobileNumber()
	{
		return mobileNumber;
	}
	
	public void setMobileNumber(java.lang.String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
		return;
	}

	public java.lang.String getNationlity()
	{
		return nationlity;
	}
	
	public void setNationlity(java.lang.String nationlity)
	{
		this.nationlity = nationlity;
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