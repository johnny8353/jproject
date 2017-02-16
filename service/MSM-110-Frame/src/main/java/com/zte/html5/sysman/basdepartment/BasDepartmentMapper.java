package com.zte.html5.sysman.basdepartment;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface BasDepartmentMapper{

	public BasDepartment get(@Param("id")java.lang.Long id);
	
	public List<BasDepartment> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(BasDepartment entity);
	
	public int update(BasDepartment entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<BasDepartment> getPage(Map<String, Object> map);
}