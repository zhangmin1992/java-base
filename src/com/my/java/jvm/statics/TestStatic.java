package com.my.java.jvm.statics;

public class TestStatic {

	private static TestStatic instance = new TestStatic();
	
	private static int num;
	
	public final static int cc = 10;
	
	private static int age = 0;
	
	private TestStatic() {
		num++;
		age++;
		System.out.println(age + "---" + num);
	}
	
	public  static TestStatic getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("直接触发初始化操作");
	}

}
