package com.my.java.thread;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TestWaitNotify {

	public static void main(String[] args) {
		Object myLock = "";
		List<String> list = new ArrayList<String>();
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					synchronized (myLock) {
						list.add("mmm");
						if(list.size() == 5) {
							myLock.notify();
							System.out.println("准备发出通知");
						}
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				synchronized (myLock) {
					if(list.size()!=5) {
						try {
							System.out.println("我一直等待被唤醒");
							myLock.wait();
							System.out.println("wait后面的代码永远不会执行");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
		System.out.println(JSONObject.toJSONString(list));
	}

}
