package com.johnny.common.observer;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 类 编 号：
 * 类 名 称：CacheSubject
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月27日
 * 编码作者：JohnnyHuang 黄福强
 */
public class CacheSubject extends Observable{
	private Log log = LogFactory.getLog(this.getClass());
	public static CacheSubject CACHE_SUBJECT = new CacheSubject();
	

	@Override
	public synchronized void addObserver(Observer o) {
		log.info("==add a observer "+ o );
		super.addObserver(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		log.info("==delete a observer "+ o );
		super.deleteObserver(o);
	}

	@Override
	public void notifyObservers() {
		log.info("==notify all Observers begin==" );
		super.notifyObservers();
		log.info("==notify all Observers finished==" );
	}

	@Override
	public void notifyObservers(Object arg) {
		log.info("==notify a Observer begin=="+ arg );
		super.notifyObservers(arg);
		log.info("==notify a Observer finished=="+ arg );
	}
	
	public void change(){
		super.setChanged();
	}
}
