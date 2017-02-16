package com.zte.html5.sysman.test1;

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


/**
 * spring mvc控制类
 */
@Controller
@RequestMapping("/sysman/Test1")
public class Test1Controller{
	//日志对象
	private static final Logger log = Logger.getLogger(Test1Controller.class);
	
	//服务对象，SPRING自动装配
	@Autowired
	ITest1Service test1Service = null;

	public void setTest1Service(ITest1Service test1Service) {
		this.test1Service = test1Service;
	}
	
	/**
	 * 根据主键获取实体对象 
	 */
	@RequestMapping(value="/get.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData get(HttpServletRequest request, @RequestBody Test1 entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理 
		Test1 test1 = test1Service.get(entity.getId());
		    
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(test1);		    
        
        return ret;
	}
	
	/**
	 * 获取符合条件的实体列表,按指定属性排序,参数已post+json方式传递,
	 这样的优势是提交的数据可以根据实体里面声明的格式自动进行格式转换,比如格式化的String传转换为Date
	 */
	@RequestMapping(value="/getList.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData  getList(HttpServletRequest request, @RequestBody FormData<Test1>  from) throws Exception
	{	    
        //返回统一的服务端数据
		ServiceData ret = new ServiceData();
       	
       	Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", from.getBo().getId());
	    List<Test1> list = test1Service.getList(map,from.getSort(),from.getOrder());
	        
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(list);
        
        return ret;
	}
	
	/**
	 * 删除指定记录
	 */
	@RequestMapping(value="/delete.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData delete(HttpServletRequest request, @RequestBody Test1 entity) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		int count = test1Service.delete(entity.getId());
		
        ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 新增指定记录
	 */
	@RequestMapping(value="/insert.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData insert(HttpServletRequest request, @Valid @RequestBody Test1 entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = test1Service.insert(entity);
		
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 修改指定记录
	 */
	@RequestMapping(value="/update.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData update(HttpServletRequest request, @Valid @RequestBody Test1 entity, BindingResult result) throws Exception
	{
		//检查数据效验结果,如果有验证错误,抛出数据验证异常       
		if(result != null && result.hasErrors()){
			throw new ValidationException(result);
		}
		
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		//业务操作可以不捕获异常,由统一的异常处理方法处理
		int count = test1Service.update(entity);
			
		ret.setCode(request,ServiceData.RetCode.Success);
		ret.setBo(new Integer(count));
        
        return ret;
	}
	
	/**
	 * 获取符合条件的分页记录，包括当页数据/记录总数,
	 * 先按指定属性排序,再分页
	 */
	@RequestMapping(value="/getPage.do",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ServiceData getPage(HttpServletRequest request, @RequestBody FormData<Test1>  form) throws Exception
	{
		//返回统一的服务端数据
		ServiceData ret = new ServiceData();
		
		Map<String,Object> map = new HashMap<String,Object>();
        	
        //设置查询条件
		map.put("id", form.getBo().getId());
	    long total = test1Service.getCount(map,form.getSort(),form.getOrder());
	    List<Test1> list = test1Service.getPage(map,form.getSort(),form.getOrder(),form.getPage(),form.getRows());
	        
	    PageRows<Test1> page = new PageRows<Test1>();
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
		log.error("Test1Controller 捕获到异常：", e);
	
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