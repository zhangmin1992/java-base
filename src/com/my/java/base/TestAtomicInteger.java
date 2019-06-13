package com.my.java.base;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger();
//		System.out.println(atomicInteger.incrementAndGet());
//		System.out.println(atomicInteger.get());
		
		//-1
		System.out.println(atomicInteger.decrementAndGet());
		System.out.println(atomicInteger.get());
	}

}
