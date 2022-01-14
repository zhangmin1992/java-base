package com.my.java.base.queue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 功能描述:
 * ArrayBlockingQueue 基于数组的有节阻塞队列，按照先进先出的顺序排序
 * LinkedBlockingQueue 基于链表的无界阻塞队列，按照先进先出的顺序排序,LinkedBlockingQueue不接受null值传入
 *   add方法在添加元素的时候，若超出了度列的长度会直接抛出异常
 *   put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素
 *   offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false
 *
 *   remove:若队列为空，抛出NoSuchElementException异常。
 *   take:若队列为空，发生阻塞，等待有元素。
 *   poll: 若队列为空，返回null。
 * priorityBlockingQueue是一个无界队列，它没有限制，在内存允许的情况下可以无限添加元素；
 * 它又是具有优先级的队列，是通过构造函数传入的对象来判断，传入的对象必须实现comparable接口
 * 每次添加一个元素，PriorityBlockingQueue中的person都会执行compareTo方法进行排序，但是只是把第一个元素排在首位，其他元素按照队列的一系列复杂算法排序。
 * 这就保障了每次获取到的元素都是经过排序的第一个元素,但是遍历的时候会发现这个顺序并不是排好序的顺序
 */
public class TestQueue {
    public static void main(String args[]) {
        //ArrayBlockingQueue 有节阻塞队列，按照先进先出的顺序排序
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        try {
            queue.put("3");
            queue.put("93");
            queue.put("83");
            queue.put("63");
            queue.put("0");
            System.out.println(queue.take());
            System.out.println(queue.take());
        }catch (Exception e) {

        }
//        Iterator<String> iterator = queue.iterator();
//        while(iterator.hasNext()) {
//           System.out.println((String)iterator.next());
//        }

        //按照先进先出的顺序排序
        LinkedBlockingQueue<String> queue1 = new LinkedBlockingQueue();
        try {
            //queue1.put(null);
            queue1.put("3");
            queue1.put("93");
            queue1.put("83");
            queue1.put("63");
            queue1.put("0");
            System.out.println(queue1.take());
            System.out.println(queue1.take());
        }catch (Exception e) {
            System.out.println("---" + e);
        }
//        Iterator<String> iterator1 = queue1.iterator();
//        while(iterator1.hasNext()) {
//            System.out.println((String)iterator1.next());
//        }

        //PriorityBlockingQueue 每次取出最小值
        PriorityBlockingQueue<String> queue3 = new PriorityBlockingQueue();
        try {
            queue3.put("3");
            queue3.put("93");
            queue3.put("83");
            queue3.put("63");
            queue3.put("0");
            System.out.println("--"+queue3.take());
            System.out.println("--"+queue3.take());
        }catch (Exception e) {
            System.out.println("---" + e);
        }
        //iterator1遍历的顺序并没有排序，只能保证queue3.take()的时候每次取出的都是当前最小的值
        Iterator<String> iterator1 = queue3.iterator();
        while(iterator1.hasNext()) {
            System.out.println((String)iterator1.next());
        }

        try {
            System.out.println(queue3.take());
            System.out.println(queue3.take());
            System.out.println(queue3.take());
            System.out.println(queue3.take());
            System.out.println(queue3.take());
        }catch (Exception e) {

        }
    }
}
