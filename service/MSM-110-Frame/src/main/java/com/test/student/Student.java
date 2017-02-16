package com.test.student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Student.classno.NotNull}")
	private java.lang.String classno; //班号
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Student.stuid.NotNull}")
	private java.lang.String stuid; //学号

	private java.lang.String name; //姓名

	//指定spring mvc绑定日期类型请求参数时使用的格式/转换为JSON字符串的格式
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private java.util.Date birth; //生日

	private java.lang.Float score; //成绩


	public java.lang.String getClassno()
	{
		return classno;
	}
	
	public void setClassno(java.lang.String classno)
	{
		this.classno = classno;
		return;
	}

	public java.lang.String getStuid()
	{
		return stuid;
	}
	
	public void setStuid(java.lang.String stuid)
	{
		this.stuid = stuid;
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

	public java.util.Date getBirth()
	{
		return birth;
	}
	
	public void setBirth(java.util.Date birth)
	{
		this.birth = birth;
		return;
	}

	public java.lang.Float getScore()
	{
		return score;
	}
	
	public void setScore(java.lang.Float score)
	{
		this.score = score;
		return;
	}
}