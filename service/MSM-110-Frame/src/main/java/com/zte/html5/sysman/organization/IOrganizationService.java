package com.zte.html5.sysman.organization;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IOrganizationService{
	
	public Organization get(java.lang.Long id) throws Exception;
	
	public List<Organization> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Organization entity) throws Exception;
	
	public int update(Organization entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Organization> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}