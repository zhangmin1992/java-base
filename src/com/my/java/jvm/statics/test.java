package com.my.java.jvm.statics;

public class test {

	public static void main(String[] args) {
		
		/**
		 * static 的执行是有顺序的
		 */
//		System.out.println(TestStatic.getInstance().num);
//		System.out.println(TestStatic.getInstance().age);
		
		/**
		 * 调用类的静态变量触发初始化操作
		 */
//		System.out.println(TestStatic.age);
		
		/**
		 * 给类的静态变量赋值导致初始化操作
		 */
//		TestStatic.age = 3;
//		System.out.println(TestStatic.getInstance().age);
		
		System.out.println(TestStatic.cc);
	}

}
