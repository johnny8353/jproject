package com.zte.html5.sysman.logoperation;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ILogOperationService{
	
	public LogOperation get(java.lang.Long id) throws Exception;
	
	public List<LogOperation> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(LogOperation entity) throws Exception;
	
	public int update(LogOperation entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<LogOperation> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}