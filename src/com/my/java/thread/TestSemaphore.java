package com.my.java.thread;

import java.util.concurrent.Semaphore;

/**
 * 方式二：只用Semaphore信号量
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 18, 2019 3:25:26 PM
 */
public class TestSemaphore {

	private static Semaphore aSemaphore = new Semaphore(1);
	private static Semaphore bSemaphore = new Semaphore(0);
	private static Semaphore cSemaphore = new Semaphore(0);
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
	
	static class ThreadA extends Thread {
		@Override
		public void run() {
			 for (int i = 0; i < 10; i++) {
				 try {
					aSemaphore.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("A");
				 bSemaphore.release();
			 }
		} 
	}
	
	static class ThreadB extends Thread {
		@Override
		public void run() {
			 for (int i = 0; i < 10; i++) {
				 try {
					bSemaphore.acquire();
				 } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				 System.out.println("B");
				 cSemaphore.release();
			 }
		} 
	}
	
	static class ThreadC extends Thread {
		@Override
		public void run() {
			 for (int i = 0; i < 10; i++) {
				 try {
					 cSemaphore.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("C");
				 aSemaphore.release();
			 }
		} 
	}

}
