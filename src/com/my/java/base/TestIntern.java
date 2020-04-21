package com.my.java.base;

/**
 * 功能描述: <br>
 * @Param: intern 1。8xia
 * 如果字符串常量池中存在这个字符串对象，就返回字符串常量池中的引用地址
 * 不存在，如果字符串对象存在java堆中，返回堆中的地址，并将对象的引用添加到字符串常量池中
 * 如果堆中不存在此对象， 就在常量池中创建这个字符串对象并返回常量池中的地址
 * @Return:
 * @Author: zhangmin
 * @Date: 2020/4/14 2:51 PM
 */
public class TestIntern {

	public static void main(String[] args) {
	    //s2.intern() 返回的是常量池中的地址，s1也是直接指向常量池
//		String s1 = "abc";
//		String s2 = new String("abc");
//		System.out.println(s1 == s2.intern());

        //s.intern(); 返回的是常量池中的地址,但是并没有赋值给s啊，无任何操作意义，s = s.intern();的话结果会不一样
        //s的引用是在堆中，s2的引用是在方法区中，引用地址不一样
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//        System.out.println(s.intern() == s2);

        //s3引用地址在堆中，创建了一个字符串常量池1，s3.intern();字符串11不在常量池中，创建11并返回11的地址
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
	}

}
