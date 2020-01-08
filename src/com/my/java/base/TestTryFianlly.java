package com.my.java.base;

import com.alibaba.fastjson.JSONObject;

/**
 * 主要是TestTryFinally2 TestTryFinally4 TestTryFinally5的结果
 * finally 一定会执行，当finally中没有return的时候，返回的是try或者catch中return的值
 *                   当finally中有return的时候，返回的一定是finally中return的值
 *                   
 * TestTryFinally4 返回基本类型，在异常情况下，没有打印最后一句输出，然后执行catch中缓存的值（在栈中存放的值）
 * TestTryFinally5 返回类对象数组等值引用的类型，在异常情况下，没有打印最后一句输出，但是执行了finally语句，已经对变量重新赋值了，返回堆中引用地址处的值
 * @author yp-tc-m-7129
 *
 */
public class TestTryFianlly {

	public static void main(String[] args) {
//		System.out.println(TestTryFinally());
//		System.out.println(TestTryFinally1());
//		System.out.println(TestTryFinally2());
//		System.out.println(TestTryFinally4());
//		System.out.println(TestTryFinally3());
//		System.out.println(JSONObject.toJSONString(TestTryFinally5()));
		System.out.println(JSONObject.toJSONString(TestTryFinally6()));
	}
	
	public static int TestTryFinally() {
		int result = 10;
		try {
		} catch (Exception e) {
			System.out.println("catch");
			result = 20;
		}finally {
			System.out.println("finally");
			result =30;
		}
		return result;
	}
	
	public static int TestTryFinally1() {
		int result = 10;
		try {
			int i=0/0;
		} catch (Exception e) {
			System.out.println("catch");
			result = 20;
		}finally {
			System.out.println("finally");
			result =30;
		}
		return result;
	}
	
	public static int TestTryFinally2() {
		int result = 10;
		try {
			int i=0/0;
			return result;
		} catch (Exception e) {
			System.out.println("catch");
			result = 20;
			return result;
		}finally {
			System.out.println("finally");
			result =30;
			return result;
		}
	}
	
	public static int TestTryFinally4() {
		int result = 10;
		try {
		    int i=0/0;
		} catch (Exception e) {
			System.out.println("catch");
			result = 20;
			return result;
		}finally {
			System.out.println("finally");
			result =30;
		}
		System.out.println(result+"----");
		return result;
	}
	
	public static int TestTryFinally3() {
		int result = 10;
		try {
		} catch (Exception e) {
			System.out.println("catch");
			result = 20;
			return result;
		}finally {
			System.out.println("finally");
			result =30;
			return result;
		}
	}
	
	public static A TestTryFinally5() {
		A a = new A("cp");
		try {
		    int i=0/0;
		} catch (Exception e) {
			a.setName("cp1");
			return a;
		}finally {
			a.setName("cp2");
		}
		System.out.println("----");
		return a;
	}
	
	public static A TestTryFinally6() {
		A a = new A("cp");
		try {
		   return new A("cp2");
		} catch (Exception e) {
			a.setName("cp1");
		}
		System.out.println("----");
		return a;
	}
}

class A {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A(String name) {
		super();
		this.name = name;
	}
	
}
