package com.demo.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Operation op = (Operation)context.getBean("operation");
		op.task1();
		op.task2();
		op.task3();
	}

}
