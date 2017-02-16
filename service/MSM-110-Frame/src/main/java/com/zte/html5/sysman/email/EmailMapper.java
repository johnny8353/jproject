package com.zte.html5.sysman.email;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface EmailMapper{

	public Email get(@Param("id")java.lang.Long id);
	
	public List<Email> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Email entity);
	
	public int update(Email entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Email> getPage(Map<String, Object> map);
}