package com.my.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 功能描述: Exchanger也可以用于校对工作。比如我们需要将纸制银流通过人工的方式录入成电子银行流水，为了避免错误，采用AB岗两人进行录入，录入到Excel之后，
 * 系统需要加载这两个Excel，并对这两个Excel数据进行校对，看看是否录入的一致
 *
 * Exchanger的典型应用场景是：一个任务在创建对象，而这些对象的生产代价很高，耗时比较长
 * 另一个任务在消费这些对象。通过这种方式，可以有更多的对象在被创建的同时被消费。
 */
public class ExchangerThreadDemo {

    public static void main(String[] args) {
        try {
//            test1();
            test2();
        } catch (Exception e) {

        }
    }

    /**
     * 功能描述: 第5个线程因为没有匹配的线程而等待超时
     */
    public static void test1() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() ->  {
                try {
                    String origMsg = RandomStringUtils.randomNumeric(6);

                    // 先到达的线程会在此等待，直到有一个线程跟它交换数据或者等待超时
                    String exchangeMsg = exchanger.exchange(origMsg,5, TimeUnit.SECONDS);

                    System.out.println(Thread.currentThread().getName() + "\t origMsg:" + origMsg + "\t exchangeMsg:" + exchangeMsg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }

            },String.valueOf(i)).start();
        }
        countDownLatch.await();
    }

    private static void test2() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        // 生产者
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                try{
                    cyclicBarrier.await();

                    for (int i = 0; i < 5; i++) {
                        String msg = RandomStringUtils.randomNumeric(6);
                        exchanger.exchange(msg,5,TimeUnit.SECONDS);
                        System.out.println(Thread.currentThread().getName() + "\t producer msg -> " + msg + " ,\t i -> " + i);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        };

        // 消费者
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                try{
                    cyclicBarrier.await();
                    for (int i = 0; i < 5; i++) {
                        String msg = exchanger.exchange(null,5,TimeUnit.SECONDS);
                        System.out.println(Thread.currentThread().getName() + "\t consumer msg -> " + msg + ",\t" + i);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        };

        for (int i = 0; i < 2; i++){
            new Thread(producer).start();
            new Thread(consumer).start();
        }

        countDownLatch.await();
    }
}
