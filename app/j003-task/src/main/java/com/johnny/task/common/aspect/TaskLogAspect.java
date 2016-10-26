package com.johnny.task.common.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.business.service.TaskService;
import com.johnny.task.common.data.SysDataDictionary;

public class TaskLogAspect {
	@Autowired
	private TaskService taskService;
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result = null;
		String methodName = pjd.getSignature().getName();
		TaskVO sTaskVO = null;
		Object[] args = pjd.getArgs();
		for (int i = 0; i < args.length; i++) {
			if(args[i] instanceof TaskVO){
				sTaskVO = (TaskVO) args[i];
				break;
			}
		}
		try {
			//活动状态
			sTaskVO.setStatus(SysDataDictionary.THREAD_STATUS_ACTIVE);
			sTaskVO.setActlStartDt(new Date());
			taskService.saveOrUpdate(sTaskVO);
			
			//前置通知
			System.out.println("The method--- " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("The method " + methodName + " ends with " + result);
			//成功
			sTaskVO.setStatus(SysDataDictionary.THREAD_STATUS_SUCCESS);
			taskService.saveOrUpdate(sTaskVO);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception:" + e);
			sTaskVO.setStatus(SysDataDictionary.THREAD_STATUS_ERROR);
			sTaskVO.setCompletionText(ExceptionUtil.getExceptionMessage(e));
			sTaskVO.setActlEndDt(new Date());
			taskService.saveOrUpdate(sTaskVO);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
	
}