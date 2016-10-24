package com.johnny.task.access.vo;

import java.util.Date;

import com.johnny.common.access.vo.BaseVO;

public class TaskVO extends BaseVO{
    private Date actlEndDt;
    private Date actlStartDt;
    private Date expirationDt;
    private Date schedStartDt;
    private Date submitDate;
    private String className;
    private String completionCd;
    private String completionText;
    private String descText;//说明
    private String execSrvrName;
    private String method;//组件/作业
    private String tmodel;
    private String rptFlag;
    private String rptInterval;
    private String rptUom;
    private String status;
    private String taskPid;
	public Date getActlEndDt() {
		return actlEndDt;
	}
	public void setActlEndDt(Date actlEndDt) {
		this.actlEndDt = actlEndDt;
	}
	public Date getActlStartDt() {
		return actlStartDt;
	}
	public void setActlStartDt(Date actlStartDt) {
		this.actlStartDt = actlStartDt;
	}
	public Date getExpirationDt() {
		return expirationDt;
	}
	public void setExpirationDt(Date expirationDt) {
		this.expirationDt = expirationDt;
	}
	public Date getSchedStartDt() {
		return schedStartDt;
	}
	public void setSchedStartDt(Date schedStartDt) {
		this.schedStartDt = schedStartDt;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCompletionCd() {
		return completionCd;
	}
	public void setCompletionCd(String completionCd) {
		this.completionCd = completionCd;
	}
	public String getCompletionText() {
		return completionText;
	}
	public void setCompletionText(String completionText) {
		this.completionText = completionText;
	}
	public String getDescText() {
		return descText;
	}
	public void setDescText(String descText) {
		this.descText = descText;
	}
	public String getExecSrvrName() {
		return execSrvrName;
	}
	public void setExecSrvrName(String execSrvrName) {
		this.execSrvrName = execSrvrName;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getTmodel() {
		return tmodel;
	}
	public void setTmodel(String tmodel) {
		this.tmodel = tmodel;
	}
	public String getRptFlag() {
		return rptFlag;
	}
	public void setRptFlag(String rptFlag) {
		this.rptFlag = rptFlag;
	}
	public String getRptInterval() {
		return rptInterval;
	}
	public void setRptInterval(String rptInterval) {
		this.rptInterval = rptInterval;
	}
	public String getRptUom() {
		return rptUom;
	}
	public void setRptUom(String rptUom) {
		this.rptUom = rptUom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskPid() {
		return taskPid;
	}
	public void setTaskPid(String taskPid) {
		this.taskPid = taskPid;
	}
	@Override
	public String toString() {
		return "TaskVO [className=" + className + ", descText=" + descText
				+ ", method=" + method + ", rptFlag=" + rptFlag
				+ ", rptInterval=" + rptInterval + ", rptUom=" + rptUom
				+ ", status=" + status + "]";
	}

}