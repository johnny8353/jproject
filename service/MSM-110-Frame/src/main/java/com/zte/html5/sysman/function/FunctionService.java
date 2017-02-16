package com.zte.html5.sysman.function;

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
public class FunctionService implements IFunctionService{
	
	@Autowired
	private FunctionMapper functionDAO = null;
	
	public void setFunctionDAO(FunctionMapper functionDAO) 
	{
		this.functionDAO = functionDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public Function get(java.lang.Long id) throws Exception
	{
		return functionDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Function> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Function> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = functionDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<Function> getFunctionList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<Function> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = functionDAO.getFunctionList(map);
        
        return list;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return functionDAO.delete(id);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(Function entity) throws Exception
	{
		return functionDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(Function entity) throws Exception
	{
		return functionDAO.update(entity);
	}
	
	/**
	 * 修改状态
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int updateState(Function entity) throws Exception
	{
		return functionDAO.updateState(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = functionDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<Function> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<Function> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = functionDAO.getPage(map);
        
        return list;	
	}
	
}