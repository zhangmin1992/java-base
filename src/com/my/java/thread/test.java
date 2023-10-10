package com.my.java.thread;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {

    /**
     * 创建线程池，并发量最大为5
     * LinkedBlockingDeque，表示执行任务或者放入队列
     */
    static ThreadPoolExecutor excutor = new ThreadPoolExecutor(5, 10, 0,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    public static void main(String[] args) throws Exception {

        //存储线程的返回值
        List<Future<String>> results = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            Future<String> result = excutor.submit(task);
            results.add(result);
        }

        //输出结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            // 获取返回值
            sb.append(results.get(i).get());
            sb.append(" ");
        }
        System.out.println(JSONObject.toJSONString(sb.toString()));
    }
}

class MyTask implements Callable<String> {

    private String filename;

    public MyTask(String filename) {
        this.filename = filename;
    }

    @Override
    public String call() throws Exception {
       return "返回值" + filename;
    }
}
