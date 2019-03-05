package com.my.java.thread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 带有返回值的线程
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Mar 5, 2019 11:03:09 AM
 */
public class ThirdThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callable = new MyThread();
		FutureTask<Integer> task = new FutureTask<Integer>(callable);
		new Thread(task).start();
		System.out.println(task.get());
	}
} 

class MyThread implements Callable<Integer> {
	private AtomicInteger num = new AtomicInteger(0);
	
	@Override
	public Integer call() throws Exception {
		return num.getAndIncrement();
	}
}
