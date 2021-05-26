package com.my.java.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger();
		/**
		 * 功能描述:
         * CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
         * 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做.
         * atomicInteger 的安全性原理是使用UNSAFE类操作cpu的CAS指令，更新失败就自旋
		 */
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.incrementAndGet());
		System.out.println(atomicInteger.get());
		
		System.out.println(atomicInteger.decrementAndGet());
		System.out.println(atomicInteger.get());

        int workCount = 50000;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < workCount; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    atomicInteger.addAndGet(1);
                }
            };
            executor.execute(runnable);
        }
        // 关闭启动线程，执行未完成的任务
        executor.shutdown();
        // 等待所有线程完成任务，完成后才继续执行下一步
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (Exception e) {

        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("执行结果：count=" + atomicInteger.get());
    }

}
