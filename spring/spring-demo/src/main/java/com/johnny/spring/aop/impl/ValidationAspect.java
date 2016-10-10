package com.johnny.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {
//	@Pointcut("execution(public int com.johnny.spring.aop.impl.ArithmeticCalculator.*(..))")
//	public void declareJointPointExpression(){}
	
	/**
	 * 如果切入点要在多个切面中共用, 最好将它们集中在一个公共的类中. 在这种情况下, 它们必须被声明为 public. 在引入这个切入点时, 
	 * 必须将类名也包括在内. 如果类没有与这个切面放在同一个包中, 还必须包含包名
	 * @param joinPoint
	 */
	@Before("LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
	}
	
}
