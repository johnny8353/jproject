package com.test.student;

import java.util.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *服务类 
 */
@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentMapper studentDAO = null;
	
	public void setStudentDAO(StudentMapper studentDAO) 
	{
		this.studentDAO = studentDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Student get(java.lang.String classno,java.lang.String stuid) throws Exception
	{
		return studentDAO.get(classno,stuid);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Student> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Student> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = studentDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.String classno,java.lang.String stuid) throws Exception
	{
		return studentDAO.delete(classno,stuid);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Student entity) throws Exception
	{
		return studentDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Student entity) throws Exception
	{
		return studentDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = studentDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Student> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Student> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = studentDAO.getPage(map);
        
        return list;	
	}
	
}