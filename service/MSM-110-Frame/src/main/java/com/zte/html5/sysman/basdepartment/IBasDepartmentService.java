package com.zte.html5.sysman.basdepartment;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IBasDepartmentService{
	
	public BasDepartment get(java.lang.Long id) throws Exception;
	
	public List<BasDepartment> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(BasDepartment entity) throws Exception;
	
	public int update(BasDepartment entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<BasDepartment> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}