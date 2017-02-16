package com.zte.html5.sysman.functionserve;

import java.util.*;
import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IFunctionServeService{
	
	public FunctionServe get(java.lang.Long id) throws Exception;
	
	public List<FunctionServe> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<FunctionServe> getFunctionServeList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int deleteServe(java.lang.Long functionId) throws Exception;
	
	public int insert(FunctionServe entity) throws Exception;
	
	public int update(FunctionServe entity) throws Exception;
	
	public int updateState(FunctionServe entity) throws Exception; 
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<FunctionServe> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}