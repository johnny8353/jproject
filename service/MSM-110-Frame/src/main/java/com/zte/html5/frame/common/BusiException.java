package com.zte.html5.frame.common;

public class BusiException extends Exception{
	
	String exCode;   //业务异常编码
	String exMsg;   //业务异常消息
	
	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public String getExMsg() {
		return exMsg;
	}

	public void setExMsg(String exMsg) {
		this.exMsg = exMsg;
	}

	public BusiException(String code,String msg)
	 {
	  super(msg);
	  this.exCode = code;
	  this.exMsg = msg;
	 } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
