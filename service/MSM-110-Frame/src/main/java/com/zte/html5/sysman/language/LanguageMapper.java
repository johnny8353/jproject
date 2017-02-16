package com.zte.html5.sysman.language;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface LanguageMapper{

	public Language get(@Param("id")java.lang.Long id);
	
	public List<Language> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Language entity);
	
	public int update(Language entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Language> getPage(Map<String, Object> map);
}