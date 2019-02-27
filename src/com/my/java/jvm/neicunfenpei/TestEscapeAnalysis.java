package com.my.java.jvm.neicunfenpei;

import java.io.IOException;

/**
 *    jvm 参数-XX:-DoEscapeAnalysis 关闭逃逸分析
 *    整个参数是 -XX:+UseSerialGC -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8 -XX:-DoEscapeAnalysis
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Feb 22, 2019 1:44:27 PM
 */
/**
 * 现象：
 *  test 关闭逃逸分析参数-XX:-DoEscapeAnalysis 会出现大量的gc jmap堆中的内存比较大 
 *       关闭                                不会          jmap堆中的内存比较小，也就是差几百K
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Feb 22, 2019 3:46:44 PM
 */
public class TestEscapeAnalysis {
		
	private  static int LENGTH = 1024;
	
	private Object bytes;
	
	public static void main(String[] args) throws IOException {
		TestEscapeAnalysis testEscapeAnalysis = new TestEscapeAnalysis();
	    testEscapeAnalysis.test();
		System.out.println(TestEscapeAnalysis.LENGTH);
		System.in.read();
	}
	
	public void test() {
		for(int i = 0 ; i < LENGTH ;i++){
//			Person person = new Person(i);
			byte[] b = new byte[1024];
			b[1] = 1;
		}
	}
	
	public void test2() {
		LENGTH = LENGTH + 1000;
		System.out.println(LENGTH);
		for(int i = 0 ; i < LENGTH ;i++){
			Person person = new Person(i);
//			byte[] b = new byte[ 1 * 1024];
//			b[1] = 1;
		}
	}
	
	public void test3() {
		bytes = new Person();
	}

}
class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public Person() {}

	public Person(int age) {
		super();
		this.age = age;
	}
}
