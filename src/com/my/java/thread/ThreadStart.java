package com.my.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yp-tc-m-7129
 * 现象：m1.setDaemon(true);  
 * 表示守护线程，当主线程运行完毕，并且程序中只剩下守护类线程的时候，守护线程会自动离开，jvm回收
 * m1.setDaemon(true) 执行一段事件后，会随着main方法的结束而结束
 * 
 * m1.setDaemon(false); 
 * 表示用户线程，主线程运行完毕后，子线程也不会自动退出，除非运行结束或者异常
 *
 * 默认是false，表示用户线程
 * 守护线程中产生的新线程也是守护线程
 * 
 * 创建线程的3中方式
 */
public class ThreadStart {

	public static void main(String[] args) {
		/**MyThread2 m1 = new MyThread2("AA");
		m1.setDaemon(true); //m1.setDaemon(false); 
		m1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主方法执行结束");**/ 
		
		/**MyThread3 m1 = new MyThread3("AA");
		Thread thread = new Thread(m1);
		thread.setDaemon(true); 
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主方法执行结束");**/
		
		FutureTask<String> futureTask = new FutureTask<String>(new MyThread4("AA"));
		new Thread(futureTask).start();
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class MyThread2 extends Thread {
	private String name;
	
	MyThread2(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(this.currentThread().getName() + " 线程方法");
		}
	}
}
class MyThread3 implements Runnable {

	private String name;
	
	MyThread3(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " 线程方法");
		}
	}
	
}
class MyThread4 implements Callable<String> {

	private String name;
	
	MyThread4(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		return name;
	}
	
}
