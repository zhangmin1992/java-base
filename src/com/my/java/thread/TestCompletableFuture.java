package com.my.java.thread;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {

    public static void main(String[] args) throws Exception {

        CompletableFuture.supplyAsync(()->{
            System.out.println("A-" + "女神开始化妆了");
            try {
                Thread.sleep(5);
            } catch (Exception e) {

            }
            return "ok";
        }).whenComplete((returnStr,exception) ->{
            System.out.println("女神跟我说话：" + returnStr);
        });

        System.out.println("等女神的时候，我干点自己的事情吧");
        Thread.currentThread().join();
    }

}
