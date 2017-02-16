package com.zte.html5.sysman.test1;

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
public class Test1Service implements ITest1Service{
	
	@Autowired
	private Test1Mapper test1DAO = null;
	
	public void setTest1DAO(Test1Mapper test1DAO) 
	{
		this.test1DAO = test1DAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Test1 get(java.lang.Long id) throws Exception
	{
		return test1DAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Test1> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Test1> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = test1DAO.getList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return test1DAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Test1 entity) throws Exception
	{
		return test1DAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Test1 entity) throws Exception
	{
		return test1DAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = test1DAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Test1> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Test1> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = test1DAO.getPage(map);
        
        return list;	
	}
	
}