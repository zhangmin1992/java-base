package com.my.java.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *  有5个线程，全部先打印出hello，再打印出bye
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 18, 2019 3:16:15 PM
 */
public class TestCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
		for(int i=0;i<5;i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println("hello");
					try {
						cyclicBarrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					System.out.println("bye");
				}
			}).start();
		}
	}

}
