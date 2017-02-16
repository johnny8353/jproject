package com.zte.html5.sysman.tenant;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ITenantService{
	
	public Tenant get(java.lang.Long id) throws Exception;
	
	public List<Tenant> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Tenant entity) throws Exception;
	
	public int update(Tenant entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Tenant> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}