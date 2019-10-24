package com.my.java.guanxi;

public class MyThreadPoolExecutor extends MyAbstractExecutorService {

	@Override
	public void Hello(String name) {
		System.out.println("MyThreadPoolExecutor hello" + name);
	}

	@Override
	public void IMyExecutorServiceMethod(String name) {
		System.out.println("MyThreadPoolExecutor IMyExecutorServiceMethod " + name);
		String string = MyExecutorMethod("信心");
		System.out.println("我继承了抽象类，我可以用抽象类中的共有方法");
	}
}
