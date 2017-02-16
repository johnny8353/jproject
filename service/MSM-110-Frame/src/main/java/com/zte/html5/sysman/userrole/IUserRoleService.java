package com.zte.html5.sysman.userrole;

import java.util.*;
import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IUserRoleService{
	
	public UserRole get(java.lang.Long id) throws Exception;
	
	public List<UserRole> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int deleteByRole(java.lang.Long roleId) throws Exception;
	
	public int insert(UserRole entity) throws Exception;
	
	public int insertBatch(List<UserRole> entitys) throws Exception;
	
	public int update(UserRole entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<UserRole> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
	public int saveEditByRole(Long roleId, List<UserRole> userRoles)throws Exception;
	
}