package com.my.java.jvm;

public class TestLoaderMain {

	public static void main(String[] args) {
		String string = new String("aaa");
		System.out.println(string.getClass().getClassLoader());
	}

}
