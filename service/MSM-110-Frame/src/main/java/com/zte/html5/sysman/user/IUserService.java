package com.zte.html5.sysman.user;

import java.util.*;
import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IUserService{
	
	public User get(java.lang.Long id) throws Exception;
	
	public User getByAccount(java.lang.String account) throws Exception;
	
	public User getByToken(java.lang.String token) throws Exception;
	
	public List<User> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<User> getRoleUserList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(User entity) throws Exception;
	
	public int update(User entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<User> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}