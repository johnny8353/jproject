package com.zte.html5.sysman.user;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface UserMapper{

	public User get(@Param("id")java.lang.Long id);
	
	public User getByAccount(@Param("account")java.lang.String account);
	
	public User getByToken(@Param("token")java.lang.String token);
	
	public List<User> getList(Map<String, Object> map);
	
	public List<User> getRoleUserList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(User entity);
	
	public int update(User entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<User> getPage(Map<String, Object> map);
}