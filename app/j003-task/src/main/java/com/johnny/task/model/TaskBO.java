package com.johnny.task.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.johnny.task.common.run.BaseTask;

/**
 * 
 * 类 编 号：
 * 类 名 称：TaskBO
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月31日
 * 编码作者：JohnnyHuang 黄福强
 */
public class TaskBO  implements Serializable{
	private static final long serialVersionUID = 1L;
//  //线程调度基础类，所有线程调度任务继承该基础类进行业务扩展
	private BaseTask baseTask = null;

	public BaseTask getBaseTask() {
		return baseTask;
	}

	public void setBaseTask(BaseTask baseTask) {
		this.baseTask = baseTask;
	}
	
	
} 
