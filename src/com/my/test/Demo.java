package com.my.test;

public class Demo {
	
	public void sayHello(Parent p) {
		System.out.println("Parent");
	}
	
	public void sayHello(Child1 p) {
		System.out.println("Child1");
	}
	
	public void sayHello(Child2 p) {
		System.out.println("Child2");
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		Parent p1 = new Child1();
		Parent p2 = new Child2();
		d.sayHello(p1);
		d.sayHello(p2);
	}
	
	static class Parent {}

	static class  Child1 extends Parent {
	}

	static class Child2 extends Parent {}

}



