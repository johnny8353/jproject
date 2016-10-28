package com.johnny.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 类 编 号：
 * 类 名 称：FutureUtil
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月28日
 * 编码作者：JohnnyHuang 黄福强
 */
public class FutureUtil {
	/**
	 * 控制执行时间
	 */
	public static void execute(Callable<String> call,int second) {
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Future<String> future = null;
		try {
			future = exec.submit(call);
			future.get(second * 1000L, TimeUnit.MILLISECONDS); // 任务处理超时时间设为
		}catch (InterruptedException e) {  
			future.cancel(true);  
		} catch (ExecutionException e) {  
			future.cancel(true);  
		} catch (TimeoutException e) {  
			future.cancel(true);  
		} finally {  
			// 关闭线程池
			exec.shutdown();  
		}  
	}

}
