package com.my.java.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.meituan.mtrace.thread.pool.TraceExecutors;

import io.netty.util.concurrent.DefaultThreadFactory;

/**
 *  Java8的paralleStream用fork/join框架提供了并发执行能力,但是不是线程安全的
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 30, 2019 12:55:48 PM
 */
public class TestParallelStream {
	
	private static Lock lock = new ReentrantLock();
	
	private static Lock maoyanLock = new ReentrantLock();
	
	public static void main(String[] args) {

		LoadResult loadResult = new LoadResult(true);
		List<Integer> list = new ArrayList<Integer>();
		list.add(81);
		list.add(43);
		list.add(18);
		list.add(17);
		list.add(2);
		list.add(7);
		list.add(22);
		list.add(57);
		list.add(157);
		list.add(368);
		list.add(554);
		list.add(871);
		list.add(171);
		list.add(175);
		list.add(203);
		list.add(247);
		list.add(218);
		list.add(247);
		list.add(249);
		list.add(255);
		list.add(264);
		list.add(262);
		list.add(269);
		list.add(250);
		list.add(252);
		list.add(258);
		list.add(279);
		list.add(242);
		list.add(267);
		list.add(283);
		list.add(282);
		list.add(289);
		list.add(238);
		list.add(240);
		list.add(287);
		list.add(298);
		list.add(268);
		list.add(290);
		list.add(311);
		list.add(289);
		list.add(329);
		list.add(320);
		list.add(363);
		list.add(361);
		list.add(386);
		list.add(434);
		list.add(480);
		list.add(487);
		list.add(511);
		list.add(619);
		list.add(605);
		list.add(658);
		list.add(730);
		list.add(701);
		list.add(728);
		list.add(739);
		list.add(659);
		list.add(679);
		list.add(643);
		list.add(644);
		list.add(3163);
		list.add(2258);
		list.add(992);
		list.add(367);
		LoadResult loadResult2 = new LoadResult(true);
		System.out.println("parallelStream.forEach打印结果如下" + list.size());
		long time2 = System.currentTimeMillis();
		new Thread(new Runnable() {
			public void run() {
				list.parallelStream().forEach(temp->{
					lock.lock();
					loadResult2.setOriginatorDataCount(loadResult2.getOriginatorDataCount() + temp);
					lock.unlock();
				}); 
				System.out.println(loadResult2.getOriginatorDataCount());
			}
		}).start();
		
		LoadResult loadResult3 = new LoadResult(true);
		new Thread(new Runnable() {
			public void run() {
				list.parallelStream().forEach(temp->{
					maoyanLock.lock();
					loadResult3.setReceiver(loadResult3.getReceiver() + temp);
					maoyanLock.unlock();
				}); 
				System.out.println(loadResult3.getReceiver());
			}
		}).start();
		
		System.out.println("stream.forEach打印结果如下" + list.size());
		long time1 = System.currentTimeMillis();
		list.stream().forEach(temp->{
			loadResult.setOriginatorDataCount(loadResult.getOriginatorDataCount() + temp);
		}); 
		System.out.println(loadResult.getOriginatorDataCount());
		
		LoadResult loadResult4 = new LoadResult(true);
		System.out.println("stream.forEach打印结果如下" + list.size());
		list.parallelStream().forEach(temp->{
			loadResult4.setOriginatorDataCount(loadResult4.getOriginatorDataCount() + temp);
		}); 
		System.out.println("--"+ loadResult4.getOriginatorDataCount());
		
		
	}
	
	static class LoadResult {
	    /**
	     * 是否加载成功
	     */
	    private boolean success;
	    /**
	     * 对账发起者数据数量
	     */
	    private int originatorDataCount;
	    
	    private int receiver;
	    
	    public LoadResult(boolean success) {
	        this.success = success;
	    }
	    
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public int getOriginatorDataCount() {
			return originatorDataCount;
		}
		public void setOriginatorDataCount(int originatorDataCount) {
			this.originatorDataCount = originatorDataCount;
		}

		public int getReceiver() {
			return receiver;
		}

		public void setReceiver(int receiver) {
			this.receiver = receiver;
		}
		
	}

}
