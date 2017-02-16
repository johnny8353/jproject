package com.zte.html5.sysman.function;

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
@RequestMapping("/sysman/Function")
public class FunctionController{
	//日志对象
	private static final Logger log = Logger.getLogger(FunctionController.class);
	
	//服务对象，SPRING自动装配
	@Autowired
	IFunctionService functionService = null;

	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/get.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody Function entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		Function function = functionService.get(entity.getId());
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(function);		    
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getList(HttpServletRequest request, @RequestBody FormData<Function>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", from.getBo().getId());
	    List<Function> list = functionService.getList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getFunctionList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getFunctionList(HttpServletRequest request, @RequestBody FormData<Function>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		//map.put("id", from.getBo().getId());
		
		// 获取登陆用户对象
		//if (request.getAttribute("loginUser") != null) {
			//User user = (User) request.getAttribute("loginUser");
			
			//if (request.getAttribute("orgId") != null) {
				//map.put("orgId", request.getAttribute("orgId"));
			//} else {
				//map.put("orgId", user.getOrgId());
			//}			
		//} 
		
	    List<Function> list = functionService.getFunctionList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 删除指定记录
	 */
	@RequestMapping(value="/delete.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody Function entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		int count = functionService.delete(entity.getId());
		
        ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insert.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody Function entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			entity.setCreatedBy(user.getId());
		}
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = functionService.insert(entity);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改指定记录
	 */
	@RequestMapping(value="/update.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody Function entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		if (request.getAttribute("loginUser") != null) {
			User user = (User) request.getAttribute("loginUser");
			entity.setLastUpdatedBy(user.getId());
		}
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = functionService.update(entity);
			
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改状态
	 */
	@RequestMapping(value="/updateState.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData updateState(HttpServletRequest request, @Valid @RequestBody Function entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = functionService.updateState(entity);
			
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
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<Function>  form) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", form.getBo().getId());
	    long total = functionService.getCount(map,form.getSort(),form.getOrder());
	    List<Function> list = functionService.getPage(map,form.getSort(),form.getOrder(),form.getPage(),form.getRows());
	        
	    PageRows<Function> page = new PageRows<Function>();
	    page.setCurrent(form.getPage());
	    page.setTotal(total);
	    page.setRows(list);
	    
	    ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(page);
        
        return ret;	
	}
	
	//异常处理方法
	@ResponseBody
	@ExceptionHandler    
	public ServiceData exception(HttpServletRequest request,Exception e){  
		//添加自己的异常处理逻辑，如日志记录　
		log.error("FunctionController 捕获到异常：", e);
	
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