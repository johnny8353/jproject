package com.zte.html5.sysman.dictionary;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface DictionaryMapper{

	public Dictionary get(@Param("id")java.lang.Long id);
	
	public Dictionary getByOrgId(Map<String, Object> map);
	
	public List<Dictionary> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Dictionary entity);
	
	public int update(Dictionary entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Dictionary> getPage(Map<String, Object> map);
	
	public List<Dictionary> getMyOrgList(Map<String, Object> map);
	
}