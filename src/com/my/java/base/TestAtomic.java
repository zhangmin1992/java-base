package com.my.java.base;

import com.alibaba.fastjson.JSONObject;
import com.my.java.base.deepclone.Addr;
import com.my.java.base.deepclone.DetailAddr;
import com.my.java.base.deepclone.Student;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TestAtomic基本功能：
 * 原子更新数组类顾名思义，通过原子的方式更新数组里的某个元素
 * AtomicIntegerArray：原子更新整型数组里的元素。
 * AtomicLongArray：原子更新长整型数组里的元素。
 * AtomicReferenceArray：原子更新引用类型数组里的元素。
 * AtomicIntegerFieldUpdater 原子更新字段类。
 *
 * @author zhangmin
 * @date Oct 10, 2019 4:11:13 PM
 */
public class TestAtomic {

    public static void main(String[] args) throws InterruptedException {
        int a[] = {3, 6, 8};
        AtomicIntegerArray atomicIntegerArray = new java.util.concurrent.atomic.AtomicIntegerArray(a);

        /**
         * 以原子方式将位置 i 的元素设置为给定值，并返回旧值。
         * 对atomicIntegerArray对象的任何修改都不会影响原有对象a的值
         *
         */
        atomicIntegerArray.getAndSet(1, 8);
        System.out.println(JSONObject.toJSONString(atomicIntegerArray));
        System.out.println(JSONObject.toJSONString(a));


        /**
         * addAndGet getAndAdd 都表示在第1个参数的位置加上2（起始位置0）
         * addAndGet 是6先加2返回8
         * getAndAdd 是先返回6再加2，最终值是8
         */
        System.out.println(atomicIntegerArray.addAndGet(1, 2));
        System.out.println(atomicIntegerArray.getAndAdd(1, 2));
        System.out.println(JSONObject.toJSONString(atomicIntegerArray));


        /**
         * getAndIncrement incrementAndGet 都表示在第1个参数位置加1
         * 区别在于getAndIncrement 是先获取返回值之后加1，因此这里返回的是旧值
         * incrementAndGet 是先加1后获取，因此这里获取的是新值，最终的结果都是加1的
         *
         * System.out.println(atomicIntegerArray.getAndIncrement(1));
         System.out.println(atomicIntegerArray.incrementAndGet(1));
         System.out.println(JSONObject.toJSONString(atomicIntegerArray));
         */

        /**
         * compareAndSet 数组的第1个位置是6，就更新为新的值10，返回更新失败或成功
         * atomicIntegerArray.compareAndSet(1, 6, 10);
         System.out.println(JSONObject.toJSONString(atomicIntegerArray));
         */

        /**
         * AtomicIntegerFieldUpdater 更新实例的属性值
         * 属性的使用要求修改的实例的属性是公有的，
         * 并且是volatile的
         * 并且只能是实例变量，不能是类变量，也就是说不能加static关键字
         * 并且只能是可修改变量，不能是final变量，
         */
        DetailAddr detailAddr = new DetailAddr("xiangxidizhi");
        Addr addr = new Addr("city", "dizhi", detailAddr);
        Student student = new Student("name", 11, addr);
        AtomicIntegerFieldUpdater<Student> old = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");
        old.getAndAdd(student, 10);
        System.out.println(JSONObject.toJSONString(student));


        /**
         * AtomicReference是作用是对"对象"进行原子操作
         * System.out.println(this.currentThread().getName() + "--- 修改值："+ref.get());
         * 这句话不是线程安全的，但是最终值是1003
         */
		Integer cc = new Integer(1000);
		AtomicReference<Integer> ref = new AtomicReference<>(cc);
		Thread t1 = new myThread(ref);
		Thread t2 = new myThread(ref);
		Thread t3 = new myThread(ref);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
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
        while (true) {//自旋操作
            Integer oldV = ref.get();
            if (ref.compareAndSet(oldV, oldV + 1)) {
                System.out.println(this.currentThread().getName() + "--- 修改值：" + ref.get());
                break;
            }
        }
    }
}

