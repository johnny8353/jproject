package com.zte.html5.sysman.language;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ILanguageService{
	
	public Language get(java.lang.Long id) throws Exception;
	
	public List<Language> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Language entity) throws Exception;
	
	public int update(Language entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Language> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}