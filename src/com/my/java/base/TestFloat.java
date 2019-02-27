package com.my.java.base;

public class TestFloat {

	public static void main(String[] args) {
		/**
		 * Integer、Short、Byte、Character、Long 是相似的valueOf的实现，因此可以直接比较
		 * Double Float 是相似的实现
		 */
		Float f1 = 12.33F;
		Float f2 = 12.33F;
		float f3 = 12.33F;
		System.out.println(f1 == f2);
		System.out.println(f1 == f3);
	}

}
