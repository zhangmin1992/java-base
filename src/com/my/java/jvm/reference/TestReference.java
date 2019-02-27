package com.my.java.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestReference {

	public static void main(String[] args) {
		
		/**
		 * 强引用，obj = null; 后再合适的时间点回收
		 */
		String obj = new String("333");
		
		/**
		 * 软引用，非必须引用，内存溢出之前进行回收
		 */
		SoftReference<Object> sf = new SoftReference<Object>(obj);
		System.out.println(sf.get());
		obj = null;
		System.out.println(sf.get());//有时候会返回null
		
		/**
		 * 弱引用,只能生存到下一次垃圾收集之前，当垃圾收集器工作时，无论内存是否足够都会回收
		 */
		obj = new String("333");
		WeakReference<Object> wf = new WeakReference<Object>(obj);
		System.out.println(wf.get());
		obj = null;
		System.out.println(wf.get());
		System.out.println(wf.isEnqueued());//返回是否被垃圾回收器标记为即将回收的垃圾
		
		
		/**
		 * 虚引用，每次垃圾回收的时候都会被回收
		 */
		obj = new String("333");
		PhantomReference<Object> pf = new PhantomReference<Object>(obj, null);
		System.out.println(pf.get());//永远返回null
		System.out.println(pf.isEnqueued());//返回是否从内存中已经删除
		
	}

}
