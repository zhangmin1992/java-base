package com.my.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 的原理解析
 * 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Mar 5, 2019 6:48:59 PM
 */
public class TestSynchronized {
	
	public static void main(String[] args) {
	}
	
	private int num = 0;
	
	/**
	 * 字节码
	 * public synchronized int getNext();
    descriptor: ()I
    flags: ACC_PUBLIC, ACC_SYNCHRONIZED
    Code:
      stack=4, locals=1, args_size=1
         0: aload_0
         1: dup
         2: getfield      #2                  // Field num:I
         5: dup_x1
         6: iconst_1
         7: iadd
         8: putfield      #2                  // Field num:I
        11: ireturn
      LineNumberTable:
        line 22: 0
	 */
	public synchronized int getNext() {
		return num++;
	}
	
	/**
	 * 字节码
	 * public int getNext2();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=4, locals=3, args_size=1
         0: aload_0
         1: dup
         2: astore_1
         3: monitorenter
         4: aload_0
         5: dup
         6: getfield      #2                  // Field num:I
         9: dup_x1
        10: iconst_1
        11: iadd
        12: putfield      #2                  // Field num:I
        15: aload_1
        16: monitorexit
        17: ireturn
        18: astore_2
        19: aload_1
        20: monitorexit
        21: aload_2
        22: athrow
	 */
	public int getNext2() {
		synchronized(this) {
			return num++;
		}
	}
	
	public int getNext3() {
		synchronized(TestSynchronized.class) {
			return num++;
		}
	}
	
	public int getNext4() {
		Object a = "3";
		synchronized(a) {
			return num++;
		}
	}
}

