package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
	


	@After("allGetters()")
	public void afterAdvice() {
		System.out.println("Logging Message from After Advice");
	}


	@AfterReturning("allGetters()")
	public void afterRunningAdvice() {
		System.out.println("Logging Message from After Running Advice");
	}


	@AfterThrowing(value="execution(public void throwException())",throwing="e")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception e){
		System.out.println("Method Signature: "  + joinPoint.getSignature());
		System.out.println("Exception: "+e);
	}

	@Around("allGetters()")
	public void aroundAdvice() {
		System.out.println("Around Advice");
	}
}
