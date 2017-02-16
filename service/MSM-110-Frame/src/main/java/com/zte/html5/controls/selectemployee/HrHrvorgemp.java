package com.zte.html5.controls.selectemployee;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class HrHrvorgemp implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{HrHrvorgemp.empidUi.NotNull}")
	private java.lang.String empidUi; //

	private java.lang.String userName; //

	private java.lang.String userEnName; //

	private java.lang.String userFullId; //

	private java.lang.String userId; //

	private java.lang.String orgCnName; //

	private java.lang.String orgEnName; //

	private java.lang.String orgNo; //

	private java.lang.String topOrgNo; //

	private java.lang.String topOrgCnName; //

	private java.lang.String topOrgEnName; //

	private java.lang.String twoOrgNo; //

	private java.lang.String twoOrgCnName; //

	private java.lang.String twoOrgEnName; //

	private java.lang.String status; //

	private java.lang.String email; //

	private java.lang.String notesmail; //

	private java.lang.String orgType; //

	private java.lang.String userTelephone; //

	private java.lang.String relationDeptNo; //

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	private java.util.Date lastUpdateDate; //

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	private java.util.Date activeDate; //

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	private java.util.Date inactiveDate; //

	private java.lang.String employeetype; //

	private java.lang.String worktype; //

	private java.lang.String nationality; //

	private java.lang.String empidFull; //

	private java.lang.String empidComputer; //

	private java.lang.String searchcode; //

	private java.lang.String combinedinfoen; //

	private java.lang.String combinedinfocn; //

	private java.lang.String seekInfo; //

	private java.lang.String isDealUser; //


	public java.lang.String getEmpidUi()
	{
		return empidUi;
	}
	
	public void setEmpidUi(java.lang.String empidUi)
	{
		this.empidUi = empidUi;
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

	public java.lang.String getUserEnName()
	{
		return userEnName;
	}
	
	public void setUserEnName(java.lang.String userEnName)
	{
		this.userEnName = userEnName;
		return;
	}

	public java.lang.String getUserFullId()
	{
		return userFullId;
	}
	
	public void setUserFullId(java.lang.String userFullId)
	{
		this.userFullId = userFullId;
		return;
	}

	public java.lang.String getUserId()
	{
		return userId;
	}
	
	public void setUserId(java.lang.String userId)
	{
		this.userId = userId;
		return;
	}

	public java.lang.String getOrgCnName()
	{
		return orgCnName;
	}
	
	public void setOrgCnName(java.lang.String orgCnName)
	{
		this.orgCnName = orgCnName;
		return;
	}

	public java.lang.String getOrgEnName()
	{
		return orgEnName;
	}
	
	public void setOrgEnName(java.lang.String orgEnName)
	{
		this.orgEnName = orgEnName;
		return;
	}

	public java.lang.String getOrgNo()
	{
		return orgNo;
	}
	
	public void setOrgNo(java.lang.String orgNo)
	{
		this.orgNo = orgNo;
		return;
	}

	public java.lang.String getTopOrgNo()
	{
		return topOrgNo;
	}
	
	public void setTopOrgNo(java.lang.String topOrgNo)
	{
		this.topOrgNo = topOrgNo;
		return;
	}

	public java.lang.String getTopOrgCnName()
	{
		return topOrgCnName;
	}
	
	public void setTopOrgCnName(java.lang.String topOrgCnName)
	{
		this.topOrgCnName = topOrgCnName;
		return;
	}

	public java.lang.String getTopOrgEnName()
	{
		return topOrgEnName;
	}
	
	public void setTopOrgEnName(java.lang.String topOrgEnName)
	{
		this.topOrgEnName = topOrgEnName;
		return;
	}

	public java.lang.String getTwoOrgNo()
	{
		return twoOrgNo;
	}
	
	public void setTwoOrgNo(java.lang.String twoOrgNo)
	{
		this.twoOrgNo = twoOrgNo;
		return;
	}

	public java.lang.String getTwoOrgCnName()
	{
		return twoOrgCnName;
	}
	
	public void setTwoOrgCnName(java.lang.String twoOrgCnName)
	{
		this.twoOrgCnName = twoOrgCnName;
		return;
	}

	public java.lang.String getTwoOrgEnName()
	{
		return twoOrgEnName;
	}
	
	public void setTwoOrgEnName(java.lang.String twoOrgEnName)
	{
		this.twoOrgEnName = twoOrgEnName;
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

	public java.lang.String getNotesmail()
	{
		return notesmail;
	}
	
	public void setNotesmail(java.lang.String notesmail)
	{
		this.notesmail = notesmail;
		return;
	}

	public java.lang.String getOrgType()
	{
		return orgType;
	}
	
	public void setOrgType(java.lang.String orgType)
	{
		this.orgType = orgType;
		return;
	}

	public java.lang.String getUserTelephone()
	{
		return userTelephone;
	}
	
	public void setUserTelephone(java.lang.String userTelephone)
	{
		this.userTelephone = userTelephone;
		return;
	}

	public java.lang.String getRelationDeptNo()
	{
		return relationDeptNo;
	}
	
	public void setRelationDeptNo(java.lang.String relationDeptNo)
	{
		this.relationDeptNo = relationDeptNo;
		return;
	}

	public java.util.Date getLastUpdateDate()
	{
		return lastUpdateDate;
	}
	
	public void setLastUpdateDate(java.util.Date lastUpdateDate)
	{
		this.lastUpdateDate = lastUpdateDate;
		return;
	}

	public java.util.Date getActiveDate()
	{
		return activeDate;
	}
	
	public void setActiveDate(java.util.Date activeDate)
	{
		this.activeDate = activeDate;
		return;
	}

	public java.util.Date getInactiveDate()
	{
		return inactiveDate;
	}
	
	public void setInactiveDate(java.util.Date inactiveDate)
	{
		this.inactiveDate = inactiveDate;
		return;
	}

	public java.lang.String getEmployeetype()
	{
		return employeetype;
	}
	
	public void setEmployeetype(java.lang.String employeetype)
	{
		this.employeetype = employeetype;
		return;
	}

	public java.lang.String getWorktype()
	{
		return worktype;
	}
	
	public void setWorktype(java.lang.String worktype)
	{
		this.worktype = worktype;
		return;
	}

	public java.lang.String getNationality()
	{
		return nationality;
	}
	
	public void setNationality(java.lang.String nationality)
	{
		this.nationality = nationality;
		return;
	}

	public java.lang.String getEmpidFull()
	{
		return empidFull;
	}
	
	public void setEmpidFull(java.lang.String empidFull)
	{
		this.empidFull = empidFull;
		return;
	}

	public java.lang.String getEmpidComputer()
	{
		return empidComputer;
	}
	
	public void setEmpidComputer(java.lang.String empidComputer)
	{
		this.empidComputer = empidComputer;
		return;
	}

	public java.lang.String getSearchcode()
	{
		return searchcode;
	}
	
	public void setSearchcode(java.lang.String searchcode)
	{
		this.searchcode = searchcode;
		return;
	}

	public java.lang.String getCombinedinfoen()
	{
		return combinedinfoen;
	}
	
	public void setCombinedinfoen(java.lang.String combinedinfoen)
	{
		this.combinedinfoen = combinedinfoen;
		return;
	}

	public java.lang.String getCombinedinfocn()
	{
		return combinedinfocn;
	}
	
	public void setCombinedinfocn(java.lang.String combinedinfocn)
	{
		this.combinedinfocn = combinedinfocn;
		return;
	}

	public java.lang.String getSeekInfo()
	{
		return seekInfo;
	}
	
	public void setSeekInfo(java.lang.String seekInfo)
	{
		this.seekInfo = seekInfo;
		return;
	}

	public java.lang.String getIsDealUser()
	{
		return isDealUser;
	}
	
	public void setIsDealUser(java.lang.String isDealUser)
	{
		this.isDealUser = isDealUser;
		return;
	}
}