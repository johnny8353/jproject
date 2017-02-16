package com.zte.html5.sysman.email;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IEmailService{
	
	public Email get(java.lang.Long id) throws Exception;
	
	public List<Email> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Email entity) throws Exception;
	
	public int update(Email entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Email> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}