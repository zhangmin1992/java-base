package com.my.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原理是使用到了Unsafe,网传是cas乐观锁,cas就是比较并交换
 * 方法中采用了CAS操作，每次从内存中读取数据然后将此数据和+1后的结果进行CAS操作，如果成功就返回结果，否则重试直到成功为止,
 * 而compareAndSet利用JNI来完成CPU指令的操作
 * Unsafe他是直接操作计算机cpu的，sun并不希望程序员来用他，因为对内存不是足够了解使用起来会造成不安全,所以标记为不安全
 * @author yp-tc-m-7129
 *
 */
public class TestAutomicInteger {

	public static AtomicInteger count = new AtomicInteger();
	public static AtomicInteger count2 = new AtomicInteger();
	
	public static void main(String[] args) {
		for(int i=0;i<10000;i++) {
			new Thread(new Runnable() {
				public void run() {
					count.incrementAndGet();
					count2.incrementAndGet();
					//count.getAndSet(22);
				}
			}).start();
		}
		
		System.out.println(count);
		System.out.println(count2);
	}

}
