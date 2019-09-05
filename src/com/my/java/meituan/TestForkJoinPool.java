package com.my.java.meituan;

import java.util.concurrent.ForkJoinPool;

public class TestForkJoinPool {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(5);
		forkJoinPool.submit(() -> {
			try {
				int i = 1/0;
			} catch (Exception e) {
				System.out.println("监测到异常");
			}
		}).join();
	}

}
