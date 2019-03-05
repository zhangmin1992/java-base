package com.my.java.thread;

/**
 * @author yp-tc-m-7129
 * 现象：m1.setDaemon(true);  表示守护线程，当主线程运行完毕，并且程序中只剩下守护类线程的时候，守护线程会自动离开，jvm回收
 * m1.setDaemon(true) 执行一段事件后，会结束
 * 
 * m1.setDaemon(false); 表示用户线程，主线程运行完毕后，子线程也不会自动退出，除非运行结束或者异常
 * 执行一段事件后，一直执行
 * 
 * 默认是false，表示用户线程
 * 
 * 守护线程中产生的新线程也是守护线程
 */
public class ThreadStart {

	public static void main(String[] args) {
		MyThread2 m1 = new MyThread2();
//		m1.setDaemon(true); 
//		m1.setDaemon(false); 
		m1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("主方法执行结束");
	}
}
class MyThread2 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("线程方法");
		}
	}
}
