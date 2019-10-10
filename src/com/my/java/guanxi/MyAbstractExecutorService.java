package com.my.java.guanxi;

public abstract class MyAbstractExecutorService implements IMyExecutorService {

	public void Hello(String name) {
		System.out.println("MyAbstractExecutorService hello" + name);
	}
	
	public void MyExecutorMethod(String name) {
		System.out.println("MyAbstractExecutorService MyExecutorMethod " + name);
	}
	
	public void IMyExecutorServiceMethod2(String name) {
		System.out.println("MyAbstractExecutorService MyExecutorMethod2 " + name);
	}
}
