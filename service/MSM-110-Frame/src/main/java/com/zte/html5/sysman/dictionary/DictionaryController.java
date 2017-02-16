package com.zte.html5.sysman.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zte.html5.frame.common.*;
import com.zte.html5.sysman.user.User;


/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/sysman/Dictionary")
public class DictionaryController{
	//日志对象
	private static final Logger log = Logger.getLogger(DictionaryController.class);
	
	//服务对象，SPRING自动装配
	@Autowired
	IDictionaryService dictionaryService = null;

	public void setDictionaryService(IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/get.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody Dictionary entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		Dictionary dictionary = dictionaryService.get(entity.getId());
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(dictionary);		    
        
        return ret;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/getByOrgId.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData getByOrgId(HttpServletRequest request, @RequestBody Dictionary entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
       	Map<String,Object> map = new HashMap<String,Object>();
    	
        //设置查询条件
		map.put("dictValue", entity.getDictValue());
		map.put("parentDictCode", entity.getDictCode());
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		Dictionary dictionary = dictionaryService.getByOrgId(map);
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(dictionary);		    
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getList(HttpServletRequest request, @RequestBody FormData<Dictionary>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", from.getBo().getId());
		map.put("parentId",from.getBo().getParentId());
		map.put("dictCode", from.getBo().getDictCode());
		map.put("dictName", from.getBo().getDictName());
		map.put("enableFlag", from.getBo().getEnableFlag());
		map.put("parentDictCode", from.getBo().getParentDictCode());
	    List<Dictionary> list = dictionaryService.getList(map,from.getSort(),from.getOrder());
	   
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 删除指定记录
	 */
	@RequestMapping(value="/delete.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody Dictionary entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		int count = dictionaryService.delete(entity.getId());
		
        ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insert.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody Dictionary entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = dictionaryService.insert(entity);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改指定记录
	 */
	@RequestMapping(value="/update.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody Dictionary entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = dictionaryService.update(entity);
			
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 获取符合条件的分页记录，包括当页数据/记录总数,
	 * 先按指定属性排序,再分页
	 */
	@RequestMapping(value="/getPage.serv",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<Dictionary>  form) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", form.getBo().getId());
	    long total = dictionaryService.getCount(map,form.getSort(),form.getOrder());
	    List<Dictionary> list = dictionaryService.getPage(map,form.getSort(),form.getOrder(),form.getPage(),form.getRows());
	        
	    PageRows<Dictionary> page = new PageRows<Dictionary>();
	    page.setCurrent(form.getPage());
	    page.setTotal(total);
	    page.setRows(list);
	    
	    ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(page);
        
        return ret;	
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getMyOrgList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getMyOrgList(HttpServletRequest request, @RequestBody FormData<Dictionary>  form) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			map.put("userId", user.getId());
		}
        //设置查询条件
		map.put("id", form.getBo().getId());
		map.put("parentId",form.getBo().getParentId());
		map.put("dictCode", form.getBo().getDictCode());
		map.put("parentDictCode", form.getBo().getParentDictCode());
		
	    List<Dictionary> list = dictionaryService.getMyOrgList(map,form.getSort(),form.getOrder());
	   
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	//异常处理方法
	@ResponseBody
	@ExceptionHandler    
	public ServiceData exception(HttpServletRequest request,Exception e){  
		//添加自己的异常处理逻辑，如日志记录　
		log.error("DictionaryController 捕获到异常：", e);
	
		ServiceData ret = new ServiceData();
		
		//根据不同的异常类型进行不同处理
	    //包括效验异常\业务异常\服务器异常等
	    if(e instanceof ValidationException) {
	    	ret.setCode(request,ServiceData.RetCode.ValidationError);
	        //ret.setBo(e);
	    	//ret.setBo(((ValidationException) e).getResult().getAllErrors());
	    	ret.setBo(((ValidationException) e).getResultMap());
	    }
	    else if(e instanceof BusiException) {
	    	ret.setCode(request,ServiceData.RetCode.BusinessError);
	        ret.setBo(e);
	    }
	    else{
	        ret.setCode(request,ServiceData.RetCode.ServerError);
	        //ret.setBo(ex);
	        ret.setBo(e.getMessage());
	    }
  
	    //request.setAttribute("exceptionMessage", e.getMessage()); 
	    
	    return ret;
	}  
	
}