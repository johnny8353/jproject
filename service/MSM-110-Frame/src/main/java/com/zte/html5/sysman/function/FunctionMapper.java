package com.zte.html5.sysman.function;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface FunctionMapper{

	public Function get(@Param("id")java.lang.Long id);
	
	public List<Function> getList(Map<String, Object> map);
	
	public List<Function> getFunctionList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Function entity);
	
	public int update(Function entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Function> getPage(Map<String, Object> map);
	
	public int updateState(Function entity); 
}