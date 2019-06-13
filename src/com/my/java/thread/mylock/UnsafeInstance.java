package com.my.java.thread.mylock;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 *  使用Unsafe直接操作内存
	* @author zhangmin 
	* @date Jun 3, 2019 2:11:17 PM
 */
public class UnsafeInstance {

	static Unsafe unsafe;
	
	private long state = 0;
	
	public long getState() {
		return state;
	}

	public void setState(long state) {
		this.state = state;
	}

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		long offeset = unsafe.objectFieldOffset(UnsafeInstance.class.getDeclaredField("state"));
		System.out.println("state 在UnsafeInstance对象中的偏移量是 " + offeset);
		
		UnsafeInstance object = new UnsafeInstance();
		boolean result = unsafe.compareAndSwapLong(object, offeset, 0, 13);
		System.out.println("cas 替换结果是 result=" + result);
		
		System.out.println(object.getState());
	}
}
