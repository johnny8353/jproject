package com.zte.html5.sysman.basemployee;

import java.util.*;
import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IBasEmployeeService{
	
	public BasEmployee get(java.lang.Long id) throws Exception;
	
	public List<BasEmployee> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<BasEmployee> getEmpListByRole(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(BasEmployee entity) throws Exception;
	
	public int update(BasEmployee entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<BasEmployee> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}