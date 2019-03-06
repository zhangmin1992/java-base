package com.my.java.jvm.statics;

public class test {

	public static void main(String[] args) {
		
		/**
		 * static 的执行是有顺序的
		 * private static TestStatic instance = new TestStatic(); 执行后就回去执行TestStatic 对静态变量做赋值操作，显示1-1
		 * 但是之后继续执行类的加载，static继续执行，age重新赋值为0，num没有变化
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
		
		/**
		 * 调用类的静态变量-final类型的不会触发类的初始化
		 */
		System.out.println(TestStatic.cc);
		
		
	}

}
