package com.my.java.thread;

/**
 * 线程的调用顺序并非是线程的start声明顺序，我的方法二会在我的快捷写法
 * @author yp-tc-m-7129
 *
 */
public class ThreadStart {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我的快捷写法");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我的方法二");
			}
		}).start();
		System.out.println("程序运行结束");
	}

}
