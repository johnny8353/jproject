package com.zte.html5.sysman.basemployee;

import java.util.*;
import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface BasEmployeeMapper{

	public BasEmployee get(@Param("id")java.lang.Long id);
	
	public List<BasEmployee> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(BasEmployee entity);
	
	public int update(BasEmployee entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<BasEmployee> getPage(Map<String, Object> map);

	public List<BasEmployee> getEmpListByRole(Map<String, Object> map);
}