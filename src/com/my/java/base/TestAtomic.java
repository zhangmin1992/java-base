package com.my.java.base;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

import com.alibaba.fastjson.JSONObject;
import com.my.java.base.deepclone.Addr;
import com.my.java.base.deepclone.DetailAddr;
import com.my.java.base.deepclone.Student;

public class TestAtomic {

	public static void main(String[] args) {
		int a[] = {3,6,8};
		AtomicIntegerArray atomicIntegerArray = new java.util.concurrent.atomic.AtomicIntegerArray(a);
		/**
		 * addAndGet getAndAdd 都表示在第参数个1的位置加上2
		 */
//		atomicIntegerArray.addAndGet(1, 2);
//		atomicIntegerArray.getAndAdd(1, 2);
		System.out.println(JSONObject.toJSONString(atomicIntegerArray));
		
		/**
		 * getAndIncrement incrementAndGet 都表示在第参数个位置加1
		 * 区别在于getAndIncrement 是先获取返回值之后加1，因此这里返回的是旧值
		 * incrementAndGet 是先加1后获取，因此这里获取的是新值，最终的结果都是加1的
		 */
//		System.out.println(atomicIntegerArray.getAndIncrement(1));
		System.out.println(atomicIntegerArray.incrementAndGet(1));
		System.out.println(JSONObject.toJSONString(atomicIntegerArray));
		
		atomicIntegerArray.compareAndSet(2,9,10);
		System.out.println(JSONObject.toJSONString(atomicIntegerArray));
		
		/**
		 * AtomicIntegerFieldUpdater 更新实例的属性值，的使用要求修改的实例的属性是公有的，并且是volatile的
		 */
		DetailAddr detailAddr = new DetailAddr("xiangxidizhi");
		Addr addr = new Addr("city", "dizhi",detailAddr);
		Student student = new Student("name", 11, addr);
		AtomicIntegerFieldUpdater<Student> old = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");
		old.getAndAdd(student, 10);
		System.out.println(JSONObject.toJSONString(student));
		
		/**
		 * AtomicReference是作用是对"对象"进行原子操作
		 */
		Integer cc = new Integer(1000);
		AtomicReference<Integer> ref = new AtomicReference<>(cc);
		new myThread(ref).start(); 
		new myThread(ref).start(); 
		System.out.println(ref.get());
		System.out.println(cc);
	 }

}
class myThread extends Thread {
	
	private AtomicReference<Integer> ref;

	myThread(AtomicReference<Integer> ref) {
        this.ref = ref;
    }
    
	@Override
	public void run() {
		for (; ; ) {    //自旋操作
			Integer oldV = ref.get();   
            if (ref.compareAndSet(oldV, oldV+1)) // CAS操作 
            	System.out.println("---"+ref.get());
                break;
        }
	}
}

