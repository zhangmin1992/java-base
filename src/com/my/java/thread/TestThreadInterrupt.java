package com.my.java.thread;

import java.io.IOException;

public class TestThreadInterrupt {

	static class myThread  extends Thread{
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				if(this.isInterrupted()) {
					System.out.println("因为中断标志进入这里");
					System.out.println("第一次调用"+ this.interrupted());
					System.out.println("第二次调用"+ this.interrupted());
					break;
				}
				System.out.println(i);
			}
			System.out.println("跳出处理逻辑");
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		myThread myThread = new myThread();
		myThread.start();
		myThread.sleep(1);
		myThread.interrupt();
		System.out.println("我这里也有");
		System.in.read();
	}

}
