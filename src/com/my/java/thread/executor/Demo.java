package com.my.java.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

	public static void main(String[] args) {
		/**
		 * ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(3),new ThreadPoolExecutor.AbortPolicy());
		 * 的情况下：
		 * 第19个请求开始会拒绝直接抛出异常，15个最大线程数目，3个在队列中，
		 * 即使在抛出拒绝异常后也总共会有18个请求被执行，其他请求被拒绝。观察打印日志可知pool-1-thread打印了18次
		 * java.util.concurrent.RejectedExecutionException: 
		 * Task com.my.java.thread.executor.Demo$1@135fbaa4 rejected from java.util.concurrent.ThreadPoolExecutor@45ee12a7
		 * pool size = 15, 最大线程数
		 * active threads = 15,  活跃线程数
		 * queued tasks = 3, 队列中等待线程数
		 * completed tasks = 0,完成线程数]
		 * 
		 * 分析下拒绝策略源码看怎么打印出来活跃 完成等线程数的？：
		 * public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
         }ThreadPoolExecutor重写了toString()方法，所以才打印出来活跃和完成数目
         *
         * 饱和策略：
		 * CallerRunsPolicy 只用调用者线程main来执行任务，CallerRunsPolicy能确保请求100个被执行完毕
		 * AbortPolicy 宝异常，处理请求是18个
		 * DiscardPolicy 不处理丢弃掉，处理的请求也是18个
		 * DiscardOldestPolicy 丢弃队列里最近的一个任务，并执行当前任务
		 * 当然也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录日志或持久化不能处理的任务
         *
		 */
//		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(3));
//		AtomicInteger count = new AtomicInteger();
//		for(int i = 0; i < 100 ;i ++) {
//			threadPool.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					count.getAndIncrement();
//				}
//			});
//		}
//		
//		threadPool.shutdown();
//		
//		//当线程中的活跃线程数>1表示线程还没有执行完毕，就一直死循环等待线程执行结束
//		while(Thread.activeCount() > 1) {
//		}
//		//执行完后就打印count数目
//		System.out.println(count.get());
		
		/**
		 * ThreadPoolExecutor 源码测试
		 */
		ctlTest ctlTest = new ctlTest();
		int c = ctlTest.ctl.get();
		System.out.println(c);
		int workercount = ctlTest.workerCountOf(c);
		System.out.println(workercount);
		System.out.println(ctlTest.isRunning(c));
		System.out.println(ctlTest.runStateOf(c));
	}
	
}
class ctlTest {
	int SIZE = 32;
	int COUNT_BITS = Integer.SIZE - 3;
	int CAPACITY   = (1 << COUNT_BITS) - 1;
	int RUNNING    = -1 << COUNT_BITS;
	int SHUTDOWN   =  0 << COUNT_BITS;
	AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
	
	public int ctlOf(int rs, int wc) { return rs | wc; }
	public int workerCountOf(int c)  { return c & CAPACITY; }
	public boolean isRunning(int c) { return c < SHUTDOWN;}
	public int runStateOf(int c)     { return c & ~CAPACITY; }
}
