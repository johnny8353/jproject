package com.johnny.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP 的 helloWorld
 * 1. 加入 jar 包
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 * 
 * 2. 在 Spring 的配置文件中加入 aop 的命名空间。 
 * 
 * 3. 基于注解的方式来使用 AOP
 * 3.1 在配置文件中配置自动扫描的包: <context:component-scan base-package="com.johnny.spring.aop"></context:component-scan>
 * 3.2 加入使 AspjectJ 注解起作用的配置: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * 为匹配的类自动生成动态代理对象. 
 * 
 * 4. 编写切面类: 
 * 4.1 一个一般的 Java 类
 * 4.2 在其中添加要额外实现的功能. 
 *
 * 5. 配置切面
 * 5.1 切面必须是 IOC 中的 bean: 实际添加了 @Component 注解
 * 5.2 声明是一个切面: 添加 @Aspect
 * 5.3 声明通知: 即额外加入功能对应的方法. 
 * 5.3.1 前置通知: @Before("execution(public int com.johnny.spring.aop.ArithmeticCalculator.*(int, int))")
 * @Before 表示在目标方法执行之前执行 @Before 标记的方法的方法体. 
 * @Before 里面的是切入点表达式: 
 * 
 * 6. 在通知中访问连接细节: 可以在通知方法中添加 JoinPoint 类型的参数, 从中可以访问到方法的签名和方法的参数. 
 * 
 * 7. @After 表示后置通知: 在方法执行之后执行的代码. 
 * 
 * 各个通知点具体代码位置可以看动态代理ArithmeticCalculatorLoggingImpl.java
 */

//通过添加 @Aspect 注解声明一个 bean 是一个切面!
/**
 * 可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	/**
	 * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 
	 * 使用 @Pointcut 来声明切入点表达式. 
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式. 
	 */
	@Pointcut("execution(public int com.johnny.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}
	/**
	 	execution(aspect表达式)
	 	Before("execution(* *.*(..))")
		标识这个方法是个前置通知,  切点表达式表示执行任意类的任意方法. 第一个 * 代表匹配任意修饰符及任意返回值,  第二个 * 代表任意类的对象,第三个 * 代表任意方法, 
		参数列表中的 ..  匹配任意数量的参数
	 */
	@Before("execution(public int com.johnny.spring.aop.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	//后置通知是在连接点完成之后执行的, 即连接点返回结果或者抛出异常的时候,
	@After("execution(* com.johnny.spring.aop.impl.*.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * 在方法法正常结束受执行的代码
	 * 返回通知是可以访问到方法的返回值的!
	 * 必须在通知方法的签名中添加一个同名参数. 在运行时, Spring AOP 会通过这个参数传递返回值.
	 */
	@AfterReturning(value="execution(* com.johnny.spring.aop.impl.*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * 在目标方法出现异常时会执行的代码.
	 * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
	 * 将 throwing 属性添加到 @AfterThrowing 注解中, 也可以访问连接点抛出的异常. Throwable 是所有错误和异常类的超类. 所以在异常通知方法可以捕获到任何错误和异常.
		如果只对某种特殊的异常类型感兴趣, 可以将参数声明为其他异常的参数类型. 然后通知就只在抛出这个类型及其子类的异常时才被执行.
		afterThrowing(JoinPoint joinPoint, NullPointerException e) 只会执行空指针异常
	 */
	@AfterThrowing(value="declareJointPointExpression()",
			throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}
	
	/**
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数. 
	 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值 ;
	 * 
	 * 环绕通知是所有通知类型中功能最为强大的, 能够全面地控制连接点. 甚至可以控制是否执行连接点.
	 * 对于环绕通知来说, 连接点的参数类型必须是 ProceedingJoinPoint . 它是 JoinPoint 的子接口, 允许控制何时执行, 是否执行连接点.
	 * 在环绕通知中需要明确调用 ProceedingJoinPoint 的 proceed() 方法来执行被代理的方法. 
	 * 如果忘记这样做就会导致通知被执行了, 但目标方法没有被执行.
	 * 注意: 环绕通知的方法需要返回目标方法执行之后的结果, 即调用 joinPoint.proceed(); 的返回值, 否则会出现空指针异常
	 */
	/*
	@Around("declareJointPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
	*/
}
