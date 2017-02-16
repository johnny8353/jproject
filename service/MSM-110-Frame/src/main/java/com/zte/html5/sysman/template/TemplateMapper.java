package com.zte.html5.sysman.template;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface TemplateMapper{

	public Template get(@Param("id")java.lang.Long id);
	
	public List<Template> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Template entity);
	
	public int update(Template entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Template> getPage(Map<String, Object> map);
}