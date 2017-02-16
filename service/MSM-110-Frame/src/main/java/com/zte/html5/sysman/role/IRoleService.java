package com.zte.html5.sysman.role;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IRoleService{
	
	public Role get(java.lang.Long id) throws Exception;
	
	public List<Role> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Role entity) throws Exception;
	
	public int update(Role entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Role> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}