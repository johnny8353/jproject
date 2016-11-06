package com.johnny.ehcache.spring.aop;

public interface TestService {
	/**
	 * 根据userId取得用户名。
	 * 
	 * @param userId
	 * @return
	 */
	public String getUserName(String userId);
}
