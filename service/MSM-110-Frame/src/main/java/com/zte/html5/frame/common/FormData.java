package com.zte.html5.frame.common;

import java.io.Serializable;
import java.util.Map;

/**
 * 列表查询/分页查询,统一的用户提交数据实体,类似STRUTS的FORMDATA
 * @author 10027909
 *
 * @param <T>
 */
public class FormData<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5228445432334255284L;

	T bo = null;  //界面上传业务实体
	
	Map<Object,Object> other = null;  //附加数据,放到MAP中,
	
	String sort = null;  //指定排序字段
	String order = null;  //指定升序/倒序
	
	long page = 0l;  //当前页数
	long rows = 0l;  //每页记录行数
	
	public T getBo() {
		return bo;
	}

	public void setBo(T bo) {
		this.bo = bo;
	}

	public Map<Object,Object> getOther() {
		return other;
	}

	public void setOther(Map<Object,Object> other) {
		this.other = other;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getRows() {
		return rows;
	}

	public void setRows(long rows) {
		this.rows = rows;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
