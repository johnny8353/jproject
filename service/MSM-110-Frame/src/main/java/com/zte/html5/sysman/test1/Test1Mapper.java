package com.zte.html5.sysman.test1;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface Test1Mapper{

	public Test1 get(@Param("id")java.lang.Long id);
	
	public List<Test1> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Test1 entity);
	
	public int update(Test1 entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Test1> getPage(Map<String, Object> map);
}