package com.zte.html5.sysman.notice;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface NoticeMapper{

	public Notice get(@Param("id")java.lang.Long id);
	
	public List<Notice> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Notice entity);
	
	public int update(Notice entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Notice> getPage(Map<String, Object> map);
}