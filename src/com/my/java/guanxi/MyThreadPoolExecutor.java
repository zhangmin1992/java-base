package com.my.java.guanxi;

public class MyThreadPoolExecutor extends MyAbstractExecutorService {

	@Override
	public void Hello(String name) {
		System.out.println("hello" + name);
	}

	@Override
	public void MyExecutorMethod(String name) {
		System.out.println("MyExecutorMethod " + name);
	}

}