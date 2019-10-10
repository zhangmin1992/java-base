package com.my.java.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Java8的paralleStream用fork/join框架提供了并发执行能力,但是不是线程安全的
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 30, 2019 12:55:48 PM
 */
public class TestParallelStream {
	
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {

		LoadResult loadResult = new LoadResult(true);
		List<Integer> i= Arrays.asList(1,2,3,4,5,6,7,8,11,12,13,15,18,19,23,0,13,56,47,10,90,99,100,4,3,6,5,7,8);
		System.out.println("stream.forEach打印结果如下");
		long time1 = System.currentTimeMillis();
		i.stream().forEach(temp->{
			loadResult.setOriginatorDataCount(loadResult.getOriginatorDataCount() + temp);
		}); 
		System.out.println((time1 - System.currentTimeMillis()) + "--"+ loadResult.getOriginatorDataCount());
		
		LoadResult loadResult2 = new LoadResult(true);
		System.out.println("parallelStream.forEach打印结果如下");
		long time2 = System.currentTimeMillis();
		i.parallelStream().forEach(temp->{
			lock.lock();
			loadResult2.setOriginatorDataCount(loadResult2.getOriginatorDataCount() + temp);
			lock.unlock();
		}); 
		System.out.println((time2 - System.currentTimeMillis()) + "---" + loadResult2.getOriginatorDataCount());
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
	}

}
