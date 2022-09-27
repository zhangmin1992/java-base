package com.my.java.thread.tongxin;

/**
 * 功能描述: 启动三个线程，按照如下要求：
 * 循环打印ABC
 */
public class waitandnotify3 {

    private static final Object obj = new Object();

    private static int count = 1;


    public static void main(String[] args) {
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
        new Thread(new Task3()).start();
        System.out.println("---");
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    System.out.println("A");
                    count++;
                    obj.notifyAll();
                }
            }
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    System.out.println("B");
                    count++;
                    obj.notifyAll();
                }
            }
        }
    }


    static class Task3 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    System.out.println("C");
                    count++;
                    obj.notifyAll();
                }
            }
        }
    }
}



