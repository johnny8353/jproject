package com.zte.html5.sysman.dictionary;

import java.util.*;
import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IDictionaryService{
	
	public Dictionary get(java.lang.Long id) throws Exception;
	
	public Dictionary getByOrgId(Map<String, Object> map) throws Exception;
	
	public List<Dictionary> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Dictionary entity) throws Exception;
	
	public int update(Dictionary entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Dictionary> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
	public List<Dictionary> getMyOrgList(Map<String, Object> map,String orderField,String order) throws Exception;
		
}