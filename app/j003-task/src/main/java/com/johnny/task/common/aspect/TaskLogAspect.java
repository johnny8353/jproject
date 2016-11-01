package com.johnny.task.common.aspect;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.johnny.common.util.DateUtil;
import com.johnny.common.util.ExceptionUtil;
import com.johnny.task.access.vo.TaskVO;
import com.johnny.task.business.service.TaskService;
import com.johnny.task.common.data.SysDataDictionary;

public class TaskLogAspect {
	protected Log log = LogFactory.getLog(getClass());
	@Autowired
	private TaskService taskService;
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
		TaskVO sTaskVO = null;
		Object result = null;
		String methodName = pjd.getSignature().getName();
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
			log.info("The method--- " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			log.info("The method " + methodName + " ends with " + result);
			//成功
			sTaskVO.setStatus(SysDataDictionary.THREAD_STATUS_SUCCESS);
			sTaskVO.setActlEndDt(new Date());
			sTaskVO.setDuration(DateUtil.getDiffDate(sTaskVO.getActlStartDt(), sTaskVO.getActlEndDt()));
log.info(sTaskVO);			
			taskService.saveOrUpdate(sTaskVO);
log.info("--"+sTaskVO);
		} catch (Throwable e) {
			//异常通知
			log.info("The method " + methodName + " occurs exception:" + e);
			sTaskVO.setStatus(SysDataDictionary.THREAD_STATUS_ERROR);
			sTaskVO.setCompletionText(ExceptionUtil.getExceptionMessage(e));
			sTaskVO.setActlEndDt(new Date());
			sTaskVO.setDuration(DateUtil.getDiffDate(sTaskVO.getActlStartDt(), sTaskVO.getActlEndDt()));
log.info(sTaskVO);
			taskService.saveOrUpdate(sTaskVO);
log.info("--"+sTaskVO);
			throw new RuntimeException(e);
		}
		//后置通知
		log.info("The method " + methodName + " ends");
		
		return result;
	}
	
	/**
	 * 控制执行时间
	 */
	public void executeControl() {
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable<String> call = new Callable<String>() {
			public String call() throws Exception {
				// 开始执行耗时操作
				return "";
			}
		};
		try {
			Future<String> future = exec.submit(call);
			String obj = future.get(10000 * 1, TimeUnit.MILLISECONDS); // 任务处理超时时间设为
																		// 1 秒
		} catch (TimeoutException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭线程池
			exec.shutdown();
		}
	}
	
}