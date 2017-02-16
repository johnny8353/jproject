package com.test.student;

import java.util.*;
import java.io.Serializable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *数据访问接口类 
 */
public interface StudentMapper{

	public Student get(@Param("classno")java.lang.String classno,@Param("stuid")java.lang.String stuid);
	
	public List<Student> getList(Map<String, Object> map);
	
	public int delete(@Param("classno")java.lang.String classno,@Param("stuid")java.lang.String stuid);
	
	public int insert(Student entity);
	
	public int update(Student entity);
	
	public long getCount(Map<String, Object> map);
	
	public List<Student> getPage(Map<String, Object> map);
}