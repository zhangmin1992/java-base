package com.my.java.thread.tongxin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述: 启动三个线程，按照如下要求：
 * 循环打印ABC
 */
public class waitandnotify2 {


    public static  void main(String[] args) {
        accurateSignal accurateSignal = new accurateSignal();
        new Thread(new Runnable() {
            @Override
            public void run() {
                accurateSignal.printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                accurateSignal.printB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                accurateSignal.printC();
            }
        }).start();

        System.out.println("---");
    }
}
class accurateSignal {
    Lock lock = new ReentrantLock();
    Condition a1 = lock.newCondition();
    Condition b1 = lock.newCondition();
    Condition c1 = lock.newCondition();
    int num = 1;


    void printA() {
        lock.lock();
        try {
            while (num != 1) {
                a1.await();
            }
            System.out.println("A");
            num = 2;
            b1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    void printB() {
        lock.lock();
        try {
            while (num != 2) {
                b1.await();
            }
            System.out.println("B");
            num = 3;
            c1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            while (num != 3) {
                c1.await();
            }
            System.out.println("C");
            num =1;
            a1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}



