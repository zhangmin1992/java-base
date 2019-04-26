package com.my.shejimoshi.one;

public class PersonTwo implements Person {

	private String name;
	
	public PersonTwo(String name) {
		this.name = name;
	}
	
	public void sayHello(String name) {
		System.out.println("我叫"+name + "我来找对象");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
