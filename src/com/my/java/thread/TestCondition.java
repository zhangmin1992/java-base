package com.my.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印出10个abc 方式一：condition + num + lock unlock方式
 * 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 18, 2019 3:19:36 PM
 */
public class TestCondition {

	private static int num = 1;
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition conditionA = lock.newCondition();
	private static Condition conditionB = lock.newCondition();
	private static Condition conditionC = lock.newCondition();
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new ThreadA().start();
			new ThreadB().start();
			new ThreadC().start();
		}
	}
	
	static class ThreadC extends Thread {
		@Override
		public void run() {
			lock.lock();
			while(num != 3) {
				try {
					conditionC.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("c");
			num = 1;
			conditionA.signal();
			lock.unlock();
		} 
	}
	
	static class ThreadA extends Thread {
		@Override
		public void run() {
			lock.lock();
			while(num != 1) {
				try {
					conditionA.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("a");
			num = 2;
			conditionB.signal();
			lock.unlock();
		} 
	}
	
	static class ThreadB extends Thread {
		@Override
		public void run() {
			lock.lock();
			while(num != 2) {
				try {
					conditionB.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("b");
			num = 3;
			conditionC.signal();
			lock.unlock();
		} 
	}

}
