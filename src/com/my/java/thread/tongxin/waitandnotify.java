package com.my.java.thread.tongxin;

import java.util.concurrent.Semaphore;

/**
 * 功能描述: 启动三个线程，按照如下要求：
 * AA打印5此，BB打印10次，CC打印15次，一共进行10轮
 */
public class waitandnotify {
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(new  MyThreadA()).start();
        new Thread(new  MyThreadB()).start();
        new Thread(new  MyThreadC()).start();

        System.out.println("---");
    }

    static class MyThreadA implements Runnable {
        @Override
        public void run() {
            try {
                //A获取信号执行,A信号量减1
                A.acquire();
                for (int i=0;i<5;i++) {
                    System.out.println("A");
                }
                //B释放信号，B信号量加1（初始为0）
                B.release();
            } catch (Exception e) {

            }
        }
    }

    static class MyThreadB implements Runnable {
        @Override
        public void run() {
            try {
                B.acquire();
                for (int i=0;i<8;i++) {
                    System.out.println("B");
                }
                C.release();
            } catch (Exception e) {

            }
        }
    }

    static class MyThreadC implements Runnable {
        @Override
        public void run() {
            try {
                C.acquire();
                for (int i=0;i<10;i++) {
                    System.out.println("C");
                }
                A.release();
            } catch (Exception e) {

            }
        }
    }

}

