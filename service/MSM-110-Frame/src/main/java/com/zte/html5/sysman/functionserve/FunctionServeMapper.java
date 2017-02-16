package com.zte.html5.sysman.functionserve;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface FunctionServeMapper{

	public FunctionServe get(@Param("id")java.lang.Long id);
	
	public List<FunctionServe> getList(Map<String, Object> map);
	
	public List<FunctionServe> getFunctionServeList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int deleteServe(@Param("functionId")java.lang.Long functionId);
	
	public int insert(FunctionServe entity);
	
	public int update(FunctionServe entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<FunctionServe> getPage(Map<String, Object> map);
	
	public int updateState(FunctionServe entity); 
}