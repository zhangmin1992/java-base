package com.my.java.thread;

/**
 * volatile 关键字的作用:具有线程可见性和防止指令重排序，注意不具有原子性不可以计数
 * 
 * 具有可见性：可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
 * 每个线程都有一个线程工作区，当线程访问一个对象值的时候，首先通过对象的引用找到对应在堆内存中的变量的值，
 * 然后把堆内存变量的具体值load到线程工作区，建立一个变量副本，
 * 之后线程就不在和堆内存中的对象值有任何关系，而是直接修改副本变量的值，
 * 在修改完线程退出之前，自动把线程变量副本的值写到堆内存中区。
 * volatile 关键字是因为能够保证每次读取前都能从主内存刷新最新值，每次写入后必须立即会写到主内存。
 * 指令重排序和在变量读写前插入内存屏障有关系，内存屏障的功能是:
 * 1.他确保指令重排序时不会将后面的执行排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面，也就是说在执行到内存屏障的这句指令时，前面的操作已完成
 * 2.他会强制将工作区变量副本的修改操作立即写入主内存
 * 
 * voliate变量的应用场景
 * 1.懒加载的doubble check
 * class Singleton{
 *  private Singleton() {}
 *  private volatile static Singleton instance = null;
 *  public static Singleton getInstance() {
 *    if(instance == null) {
 *      sychorized(Singleton.class) {
 *         if(instance == null) {
 *           return new Singleton();
 *         }
 *      }
 *    }
 *    return instance;
 *  }
 *  
 * }
 * 2.主内存变量状态判断，看下面例子
 * volatile和sychnorized的比较
 * 前置只能用于变量，后置用于方法，代码段
 * 前置只要可见性，没有原子性，后者有原子性
 * 多线程访问前置不会阻塞，性能较好，后者会被阻塞
 * 
 * @author yp-tc-m-7129
 *
 */
public class Testvolatile extends Thread {

	volatile boolean flag = false;
    int i = 0;
    
    public void run() {
        while (!flag) {
            i++;
        }
    }
    
    public static void main(String[] args) throws Exception {
    	/**
    	 * 主内存变量状态判断
    	 */
    	/*Testvolatile vt = new Testvolatile();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stope" + vt.i);*/
    	
    	/**
    	 * 原子性错误用法,一次性定义10个线程，并启动
    	 */
    	Testvolatile2[] array = new Testvolatile2[10];
    	for(int i=0;i<10;i++) {
    		array[i] = new Testvolatile2();
    	}
    	for(int i=0;i<10;i++) {
    		array[i].start();
    	}
    }

}

class Testvolatile2 extends Thread {
	public static volatile int count;
	
	@Override
	public void run() {
		addCount();
	}
	
	public /**synchronized*/ static void addCount() {
		for(int i = 0;i < 10000;i++) {
			count ++;
		}
		System.out.println(count);
	}
}
