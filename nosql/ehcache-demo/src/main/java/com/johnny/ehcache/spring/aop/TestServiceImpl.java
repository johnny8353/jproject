package com.johnny.ehcache.spring.aop;

public class TestServiceImpl implements TestService {
	/*
	 * @see org.mango.cache.ehcache.TestService#getUserName(java.lang.String)
	 */
	public String getUserName(String userId) {
		return userId;
	}
}