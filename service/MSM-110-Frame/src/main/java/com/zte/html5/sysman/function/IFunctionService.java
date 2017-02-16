package com.zte.html5.sysman.function;

import java.util.*;
import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IFunctionService{
	
	public Function get(java.lang.Long id) throws Exception;
	
	public List<Function> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Function> getFunctionList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Function entity) throws Exception;
	
	public int update(Function entity) throws Exception;
	
	public int updateState(Function entity) throws Exception; 
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Function> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}