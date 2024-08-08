package com.my.java.suanfa;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class kuaishouthread {

    private AtomicInteger i = new AtomicInteger();

    private Object lock = new Object();

    private boolean mark = true;

    public static void main(String[] args) {
        kuaishouthread a = new kuaishouthread();
        //a.test();
          a.test2();
    }

    public void test2() {
        new Thread(new Runnable() {
            @Override public void run() {
                while (mark && i.get() < 100) {
                    synchronized (lock) {
                        lock.notify();
                        System.out.println("A-" + i.incrementAndGet());
                        mark = false;

                        try {
                            lock.wait();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {

                while (!mark && i.get() < 100) {
                    synchronized (lock) {
                        lock.notify();
                        System.out.println("B-" + i.incrementAndGet());
                        mark = true;
                        
                        try {
                            lock.wait();
                        } catch (Exception e) {

                        }

                    }
                }

            }
        }).start();
    }

    public void test() {
        Semaphore semaphore = new Semaphore(1);
        Semaphore bsemaphore = new Semaphore(0);

        new Thread(new Runnable() {
            @Override public void run() {
                while (i.get() < 100) {
                    try {
                        semaphore.acquire();
                        System.out.println("A-" + i.incrementAndGet());
                        bsemaphore.release();
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                while (i.get() < 100) {
                    try {
                        bsemaphore.acquire();
                        System.out.println("B-" + i.incrementAndGet());
                        semaphore.release();
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }
}
