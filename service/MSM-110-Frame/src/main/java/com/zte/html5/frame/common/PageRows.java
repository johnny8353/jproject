package com.zte.html5.frame.common;

import java.util.List;

public class PageRows<T> {
	
	long current = 0l;  //当前页数
	long total = 0l;  //返回符合条件的总记录数
	List<T> rows = null;  //返回的列表记录
	
	public long getCurrent() {
		return current;
	}
	public void setCurrent(long current) {
		this.current = current;
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
	
}
