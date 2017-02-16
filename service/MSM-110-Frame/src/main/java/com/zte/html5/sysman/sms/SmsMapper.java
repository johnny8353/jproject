package com.zte.html5.sysman.sms;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface SmsMapper{

	public Sms get(@Param("id")java.lang.Long id);
	
	public List<Sms> getList(Map<String, Object> map);
	
	public int delete(@Param("id")java.lang.Long id);
	
	public int insert(Sms entity);
	
	public int update(Sms entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Sms> getPage(Map<String, Object> map);
}