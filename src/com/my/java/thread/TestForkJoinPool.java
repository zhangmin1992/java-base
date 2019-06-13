package com.my.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 利用forkjoin计算1到100的和
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 6, 2019 2:00:56 PM
 */
public class TestForkJoinPool {

	//2个拆分，（1，50）（51，100）拆分成（1，25）（26，50）（51，75）（76，100）等
	private static final Integer MAX = 20;
	 
    static class MyForkJoinTask extends RecursiveTask<Integer> {
       
    	// 子任务开始计算的值
        private Integer startValue;
 
        // 子任务结束计算的值
        private Integer endValue;
 
        public MyForkJoinTask(Integer startValue , Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }
 
        @Override
        protected Integer compute() {
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了，可以正式进行累加计算了
            if(endValue - startValue < MAX) {
                System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
                Integer totalValue = 0;
                for(int index = this.startValue ; index <= this.endValue  ; index++) {
                    totalValue += index;
                }
                return totalValue;
            }
            // 否则再进行任务拆分，拆分成两个任务
            else {
            	System.out.println("拆分成两个任务:startValue= "+startValue+" endValue= "+endValue + " -- "+ (startValue + endValue) / 2);
                MyForkJoinTask subTask1 = new MyForkJoinTask(startValue, (startValue + endValue) / 2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((startValue + endValue) / 2 + 1 , endValue);
                subTask2.fork();
                //使用join方法会等待子任务执行完并得到其结果
                return subTask1.join() + subTask2.join();
            }
        }
    }
 
    public static void main(String[] args) {
        // 这是Fork/Join框架的线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture =  pool.submit(new MyForkJoinTask(1,100));
        try {
        	//ForkJoinTask继承了，所以我们可以等待get结果
            Integer result = taskFuture.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }

}
