package com.my.java.thread.tongxin;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 3个线程分别打印ABC，
 *
 */
public class test {
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

    public static void main(String[] args) {

        //存储线程的返回值
        List<Future<String>> results = new LinkedList<>();

        //提交线程池执行任务，存储结果
        for (int i = 0; i < 3; i++) {
            ThreadA task = new ThreadA();
            Future<String> result = threadPool.submit(task);
            results.add(result);
        }

        //打印结果
        for (int i = 0; i < 3; i++) {
            try {
                String result = results.get(i).get();
                System.out.println("----" + result);
            }catch (Exception e) {

            }
        }

        System.out.println("线程继续执行");
    }
}

class ThreadA implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        return "1";
    }
}
