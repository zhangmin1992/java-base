package com.my.test;

public class Demo2 {

	public static void main(String[] args) {
		Parent p1 = new Child1();
		Parent p2 = new Child2();
		p1.sayHello();
		p2.sayHello();
	}

}

class Parent {
	
	public void sayHello() {
		System.out.println("Parent");
	}
}

class  Child1 extends Parent {
	
	public void sayHello() {
		System.out.println("Child1");
	}
}

class Child2 extends Parent {
	
	public void sayHello() {
		System.out.println("Child2");
	}
	
}

