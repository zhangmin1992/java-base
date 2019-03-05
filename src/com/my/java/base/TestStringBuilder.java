package com.my.java.base;

/**
 * !!!!!!!!!!!不懂
 * @author yp-tc-m-7129
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

	}

}
