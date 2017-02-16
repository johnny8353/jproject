package com.zte.html5.sysman.test1;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Test1 implements Serializable{
	//设置效验规则,主键字段不能为空
	@NotNull(message="{Test1.id.NotNull}")
	private java.lang.Long id; //


	public java.lang.Long getId()
	{
		return id;
	}
	
	public void setId(java.lang.Long id)
	{
		this.id = id;
		return;
	}
}