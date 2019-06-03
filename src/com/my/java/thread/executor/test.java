package com.my.java.thread.executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {

	public static void main(String[] args) {
		/**
		 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
		 * new ThreadPoolExecutor(1, 1,0L, 
		 * TimeUnit.MILLISECONDS,
		 * new LinkedBlockingQueue<Runnable>())
		 */
		 
		//ExecutorService executors = Executors.newSingleThreadExecutor();
		
		
		/**
		 * 创建一个定长线程池，可控制线程最大并发数2，超出的线程会在队列中等待
		 * return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
		 */
		//ExecutorService executors = Executors.newFixedThreadPool(2);
		
		
		/**
		 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
		 * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>())
		 */
//		ExecutorService executors = Executors.newCachedThreadPool();
//		Thread t1 = new MyThread("name1");
//		Thread t2 = new MyThread("name2");
//		Thread t3 = new MyThread("name3");
//		executors.execute(t1);
//		executors.execute(t2);
//		executors.execute(t3);
//		executors.shutdown();
	}

}
class MyThread extends Thread { 
	
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	
    @Override
    public void run() {
    	Random random = new Random();
    	try {
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(name + "正在执行....");
    } 
}
