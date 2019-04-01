package com.my.java.base.deepclone;

public class Student {

	private static String staString = "static";
	
	private String myChineseName;
	
	public volatile int age; 
//	private int age; 
	
	private Addr addr;

	
	public String getMyChineseName() {
		return myChineseName;
	}

	public void setMyChineseName(String myChineseName) {
		this.myChineseName = myChineseName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}
	
	public Student() {}

	public Student(String myChineseName, int age, Addr addr) {
		super();
		this.myChineseName = myChineseName;
		this.age = age;
		this.addr = addr;
	}
	
	public int add() {
		return age ++;
	}
	
	
}
