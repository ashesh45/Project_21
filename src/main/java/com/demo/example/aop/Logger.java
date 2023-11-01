package com.demo.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@EnableAspectJAutoProxy
@Aspect
@Component
public class Logger {
	

	@Before("execution(* task*(..))")
	public void startLog() {			//advice
		System.out.println("Task Started!");
	}
	
	
	@After("afterAllTasks()")
	public void endLog() {
		System.out.println("task ended!");
	}
	
	
	@Pointcut("execution(public void task*())")
	void afterAllTasks() {}

}
