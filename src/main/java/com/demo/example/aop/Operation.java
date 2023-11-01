package com.demo.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Operation {
	public void task1() {
		System.out.println("Executing task one!");
	}
	public void task2() {
		System.out.println("Executing task two!");
	}
	public void task3() {
		System.out.println("Executing task three!");
	}

}
