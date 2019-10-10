package com.my.java.thread;

import java.util.concurrent.atomic.AtomicReference;

public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		Integer cc = new Integer(1000);
		AtomicReference<Integer> ref = new AtomicReference<>(cc);
		Thread t1 = new TestJoinThread(ref); 
		Thread t2 = new TestJoinThread(ref); 
		Thread t3 = new TestJoinThread(ref); 
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(ref.get());
		System.out.println(cc);
	}

}
class TestJoinThread extends Thread {
	
	private AtomicReference<Integer> ref;

	TestJoinThread(AtomicReference<Integer> ref) {
        this.ref = ref;
    }
    
	@Override
	public void run() {
		while (true)  {//自旋操作
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.currentThread().getName());
			break;
        }
	}
}
