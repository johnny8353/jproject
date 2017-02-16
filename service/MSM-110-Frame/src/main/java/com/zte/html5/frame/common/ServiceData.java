package com.zte.html5.frame.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestContext;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 服务器返回结前台的数据类封装
 * @author 10027909
 *
 * @param <T>
 */
public class ServiceData implements Serializable{
	
	RetCode code = RetCode.Success;  //操作结果
	
	Object bo = null; //返回的数据对象,在返回异常编码时,这个对象可设置详细的异常信息
	
	Map other = null;  //附加数据
	
	
	public RetCode getCode() {
		return code;
	}


	public void setCode(HttpServletRequest request, RetCode code) {
		this.code = code;
		
		//从后台代码获取国际化提示信息            
		RequestContext requestContext = new RequestContext(request);
		this.code.setMsg( requestContext.getMessage(this.code.getMsgId()));

	}


	public Object getBo() {
		return bo;
	}


	public void setBo(Object bo) {
		this.bo = bo;
	}


	public Map getOther() {
		return other;
	}


	public void setOther(Map other) {
		this.other = other;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(RetCode.ServerError);
		
	}
	
	
	//返回编码:包括操作成功、服务器异常、身份验证失败、权限验证失败、字段效验错误、业务模块异常等场景，
	//和前台的异常类型变量一一对应
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum RetCode {
		Success("0000","RetCode.Success"),
		ServerError("0001","RetCode.ServerError"),
		AuthFailed("0002","RetCode.AuthFailed"),
		PermissionDenied("0003","RetCode.PermissionDenied"),
		ValidationError("0004","RetCode.ValidationError"),
		BusinessError("0005","RetCode.BusinessError");
		
		
		private final String code;
		private final String msgId;
		private String msg;
		 
		public String getCode() {
			return code;
		}

		public String getMsgId() {
			return msgId;
		}
		
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		//返回本地化的提示消息
		public String getMsg() {
			return msg;
		}

		//枚举类构造函数
		private RetCode(String code, String msgId) {
		     this.code = code;
		     this.msgId = msgId;
		}
		

		//覆盖了父类Enum的toString()  
		@Override
        public String toString(){  
        	return "code=" + code + ", msgId=" + msgId;  
        }  
	}
	
}
