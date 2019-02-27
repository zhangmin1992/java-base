package com.my.java.jvm;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println(SupClass.a);
//    	SupClass.a="3";
//    	
//    	SupClass.test();
		
		//Class.forName(SupClass.class.getName());
		TestMain.class.getClassLoader().loadClass(SupClass.class.getName());
		
		
		
		//System.out.println(SupClass.class);
	}
	
}
