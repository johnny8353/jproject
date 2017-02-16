package com.zte.html5.sysman.functionserve;

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
public class FunctionServeService implements IFunctionServeService{
	
	@Autowired
	private FunctionServeMapper FunctionServeDAO = null;
	
	public void setFunctionServeDAO(FunctionServeMapper FunctionServeDAO) 
	{
		this.FunctionServeDAO = FunctionServeDAO;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	public FunctionServe get(java.lang.Long id) throws Exception
	{
		return FunctionServeDAO.get(id);
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<FunctionServe> getList(Map<String, Object> map,String orderField,String order) throws Exception
	{
		List<FunctionServe> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = FunctionServeDAO.getList(map);
        
        return list;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	public List<FunctionServe> getFunctionServeList(Map<String, Object> map,
			String orderField, String order) throws Exception {
		List<FunctionServe> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
        
        list = FunctionServeDAO.getFunctionServeList(map);
		return list;
	}

	public int updateState(FunctionServe entity) throws Exception {
	 
		return 0;
	}
	
	/**
	 * 删除指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int delete(java.lang.Long id) throws Exception
	{
		return FunctionServeDAO.delete(id);
	}
	
	/**
	 * 删除按钮功能对应的服务
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int deleteServe(java.lang.Long functionId) throws Exception
	{
		return FunctionServeDAO.deleteServe(functionId);
	}
	
	/**
	 * 新增指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int insert(FunctionServe entity) throws Exception
	{
		return FunctionServeDAO.insert(entity);
	}
	
	/**
	 * 修改指定记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS,isolation=Isolation.READ_UNCOMMITTED)
	public int update(FunctionServe entity) throws Exception
	{
		return FunctionServeDAO.update(entity);
	}
	
	/**
	 * 获取符合条件的记录数量
	 */
	public long getCount(Map<String, Object> map,String orderField,String order) throws Exception
	{
		long count = 0L;

		//map.put("orderField", orderField);
		//map.put("order", order);
        
        count = FunctionServeDAO.getCount(map);
        
        return count;
	}
	
	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	public List<FunctionServe> getPage(Map<String, Object> map,String orderField,String order,Long page,Long rows) throws Exception
	{
		List<FunctionServe> list = null;
        
		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page-1)*rows);
        map.put("rowSize", rows);
        
        list = FunctionServeDAO.getPage(map);
        
        return list;	
	}


	
}