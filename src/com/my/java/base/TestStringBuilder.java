package com.my.java.base;

/**
 * !!!!!!!!!!!不懂
 * @author yp-tc-m-7129
 * 
 * StringBuffer的坑
 * 1.StringBuffer iStr = new StringBuffer(123); 
 * 123 整数类型是错误写法，值并不是123，也不是null而是空字符串""
 * 2.if(iStr2.equals("")) 错误写法，StringBuffer的equals比较的是地址
 * 需要改为if(iStr2.toString().equals("")) 
 *
 */
public class TestStringBuilder {

	public static void main(String[] args) {
		//TODO 大牛了你就解释下这里
		String s2 = new StringBuilder().append("555").toString();
		System.out.println(s2.intern() == s2); 
		String s1 = new StringBuilder().append("c11").append("bb11").toString(); 
		System.out.println(s1.intern() == s1); 
		
		String s11 = new StringBuilder().append("c11").append("bb11").append("4444").toString(); 
		System.out.println(s11.intern() == s11); 
		
		String s3 = "333";
		String s33 = new String("33") + new String("3");
		System.out.println(s3.intern() == s3); 
		System.out.println(s33.intern() == s3); 
		
		System.out.println("---------------基础坑---------");
		StringBuffer itr = new StringBuffer(9);
		System.out.println("---"+itr);
		StringBuffer iStr = new StringBuffer(123);
		System.out.println("---"+iStr);
		 
		StringBuffer iStr2 = new StringBuffer("123");
		if(iStr2.equals("123")) {
			System.out.println("StringBuffer 不能直接和equals()比较,他的equals比较的是地址");
		}
		

	}

}
