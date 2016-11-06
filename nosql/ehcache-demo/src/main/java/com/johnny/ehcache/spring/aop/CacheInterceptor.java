package com.johnny.ehcache.spring.aop;

import java.lang.reflect.Method;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheInterceptor implements MethodInterceptor {
    
    private Cache cache;

    /**
     * @see  org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        String methodName = method.getName();
        Object[] arguments = invocation.getArguments();
        Object result = invocation.proceed();

        String targetName = method.getDeclaringClass().getName();
        String key = getCacheKey(targetName, methodName, arguments);

        Element element = cache.get(key);

        if (element == null) {
            result = invocation.proceed();
            System.out.println("第一次调用方法并缓存其值:" + result);
            cache.put(new Element(key, result));
        } else {
            result = element.getValue();
            System.out.println("从缓存中取得的值为：" + result);
        }
        return result;

    }

    /**
     * 生成缓存中的KEY值。
     */
    protected String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName).append(".").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sb.append(".").append(arguments[i]);
            }
        }
        return sb.toString();
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

}