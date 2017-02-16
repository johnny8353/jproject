package com.zte.html5.sysman.user;

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
import com.zte.html5.sysman.role.Role;


/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/sysman/User")
public class UserController{
	//日志对象
	private static final Logger log = Logger.getLogger(UserController.class);
	
	//服务对象，SPRING自动装配
	@Autowired
	IUserService userService = null;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/get.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody User entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		User user = userService.get(entity.getId());
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(user);		    
        
        return ret;
	}
	
	/**
	 * 登陆校验 
	 */
	@RequestMapping(value="/login.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData login(HttpServletRequest request, @RequestBody User entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		User user = userService.getByAccount(entity.getAccount());
		if(user != null && user.getPwd() != null){
			if(user.getPwd().equals(entity.getPwd())){
				ret.setCode(request,ServiceData.RetCode.Success);
				user.setPwd(null);
				ret.setBo(user);	
				
				return ret;
			}
		}
		
		ret.setCode(request,ServiceData.RetCode.AuthFailed);
		ret.setBo(null);		    
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getList(HttpServletRequest request, @RequestBody FormData<User>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", from.getBo().getId());
	    List<User> list = userService.getList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getRoleUserList.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getRoleUserList(HttpServletRequest request, @RequestBody FormData<Role>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("roleId", from.getBo().getId());
	    List<User> list = userService.getRoleUserList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}	
		
	/**
	 * 删除指定记录
	 */
	@RequestMapping(value="/delete.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody User entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		int count = userService.delete(entity.getId());
		
        ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insert.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody User entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = userService.insert(entity);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改指定记录
	 */
	@RequestMapping(value="/update.serv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody User entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = userService.update(entity);
			
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
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<User>  form) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", form.getBo().getId());
		map.put("account", form.getBo().getAccount());
		map.put("name", form.getBo().getName());
	    long total = userService.getCount(map,form.getSort(),form.getOrder());
	    List<User> list = userService.getPage(map,form.getSort(),form.getOrder(),form.getPage(),form.getRows());
	        
	    PageRows<User> page = new PageRows<User>();
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
		log.error("UserController 捕获到异常：", e);
	
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