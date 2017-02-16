package com.zte.html5.sysman.template;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface ITemplateService{
	
	public Template get(java.lang.Long id) throws Exception;
	
	public List<Template> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.Long id) throws Exception;
	
	public int insert(Template entity) throws Exception;
	
	public int update(Template entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Template> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}