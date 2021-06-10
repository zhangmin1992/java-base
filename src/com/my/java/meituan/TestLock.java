package com.my.java.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.my.java.meituan.TestParallelStream.LoadResult;

public class TestLock {

	private static Lock lock = new ReentrantLock();
    
    private static Lock maoyanLock = new ReentrantLock();
    
    public static void main(String[] args) {

    	List<Integer> list = new ArrayList<Integer>();
		LoadResult loadResult = new LoadResult(true);
		list.parallelStream().forEach(temp->{
			lock.lock();
			loadResult.setOriginatorDataCount(loadResult.getOriginatorDataCount() + temp);
			lock.unlock();
		}); 
		System.out.println(loadResult.getOriginatorDataCount());
		
		LoadResult loadResult2 = new LoadResult(true);
		list.parallelStream().forEach(temp->{
			maoyanLock.lock();
			loadResult2.setOriginatorDataCount(loadResult2.getOriginatorDataCount() + temp);
			maoyanLock.unlock();
		}); 
		System.out.println(loadResult2.getOriginatorDataCount());
	}
}
