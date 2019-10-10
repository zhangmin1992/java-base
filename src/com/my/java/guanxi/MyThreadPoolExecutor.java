package com.my.java.guanxi;

public class MyThreadPoolExecutor extends MyAbstractExecutorService {

	@Override
	public void Hello(String name) {
		System.out.println("MyThreadPoolExecutor hello" + name);
	}

	@Override
	public void IMyExecutorServiceMethod(String name) {
		System.out.println("MyThreadPoolExecutor IMyExecutorServiceMethod " + name);
	}
	
	@Override
	public void MyExecutorMethod(String name) {
		System.out.println("MyThreadPoolExecutor MyExecutorMethod " + name);
	}

}
