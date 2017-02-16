package com.zte.html5.sysman.logoperation;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface LogOperationMapper{

	public LogOperation get(@Param("id")java.lang.Long id);
	
	public List<LogOperation> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(LogOperation entity);
	
	public int update(LogOperation entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<LogOperation> getPage(Map<String, Object> map);
}