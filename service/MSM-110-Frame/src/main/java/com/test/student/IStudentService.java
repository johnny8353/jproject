package com.test.student;

import java.util.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *服务接口类 
 */
public interface IStudentService{
	
	public Student get(java.lang.String classno,java.lang.String stuid) throws Exception;
	
	public List<Student> getList(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public int delete(java.lang.String classno,java.lang.String stuid) throws Exception;
	
	public int insert(Student entity) throws Exception;
	
	public int update(Student entity) throws Exception;
	
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception;
	
	public List<Student> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception;
	
}