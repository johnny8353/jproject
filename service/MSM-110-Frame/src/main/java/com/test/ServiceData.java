package com.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 统一的服务器返回的数据实体类
 * @author 10027909
 *
 * @param <T>
 */
public class ServiceData<T> implements Serializable{
	
	boolean success = false;  //操作是否成功
	String msg = null;  //成功/异常消息
	
	T bo = null; //返回单个实体对象
	
	long total = 0l;  //返回符合条件的总记录数
	List<T> rows = null;  //返回的列表记录
	
	Map other = null;  //附加数据
	
	public T getBo() {
		return bo;
	}

	public void setBo(T bo) {
		this.bo = bo;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
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
		
	}

}
