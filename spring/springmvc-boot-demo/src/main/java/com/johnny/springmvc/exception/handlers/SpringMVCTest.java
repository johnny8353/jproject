package com.johnny.springmvc.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/exception")
@Controller("exceptionSpringMVCTest")
public class SpringMVCTest {
	/**
	 * 几点异常处理是有顺序的
	 * SimpleMappingExceptionResolver 在后面
	 */
	private static final String SUCCESS = "success";
	
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
		String [] vals = new String[10];
		System.out.println(vals[i]);
		return "success";
	}
	
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		return "success";
	}
	
	@ResponseStatus(reason="测试",value=HttpStatus.NOT_FOUND)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i == 13){
			throw new UserNameNotMatchPasswordException();
		}
		System.out.println("testResponseStatusExceptionResolver...");
		
		return "success";
	}
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleArithmeticException2(Exception ex){
//		System.out.println("[出异常了]: " + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	/**
	 * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
	 * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
	 * 3. @ExceptionHandler 方法标记的异常有优先级的问题. 此候会根据异常的最近继承关系找到继承深度最浅的那个 @ExceptionHandler注解方法
	 * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常, 
	 * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常. 
	 */
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex){
//		System.out.println("出异常了: " + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
		System.out.println("result: " + (10 / i));
		return "success";
	}

}
