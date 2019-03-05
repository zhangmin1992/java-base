package com.my.java.base;

public class TestString {

	public static void main(String[] args) {
		/**
		 * 都知道equals比较的是值，因此相等
		 * string和integer一样，有一个常量缓冲池，常量池存在于方法区中，先在常量池中创建”abc“，并指向s1,
		 * 而后在创建s2时，由于常量池中已经存在”abc“，只需指向s2就可以，而不需要再创建。
		 * ”==”在这里比较的是对象引用，故结果为”true”,
		 * String s3=new String("abc");创建了2个对象，堆中的s3,缓冲池的abc，因此地址不等，值等
		 * String s5=s1+"";先创建StringBuilder（或 StringBuffer）对象，通过append连接得到“abc”,再调用toString()转换得到的地址指向s5，因此地址不等值等
		 * 
		 * String字符串与BufferString的传递问题
		 * string 不改变
		 * BufferString 改变
		 * -------------------------------------------------面试题部分------------------------------
		 * String是否可以被继承? 不可以，因为标记为final
		 * 
		 * java的String，StringBuffer，StringBuilder有什么区别？
           那就是：String是不可变类（immutable），每次在String对象上的操作都会生成一个新的对象；
           StringBuffer和StringBuilder则允许在原来对象上进行操作，而不用每次增加对象；
           StringBuffer是线程安全的，但效率较低，而StringBuilder则不是效率最高。
		 */
		String s1="abc";
		String s2="abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3=new String("abc");
		System.out.println(s3 == s1);
		System.out.println(s3.equals(s1));
		
		String s4="a"+"b"+"c";
		System.out.println(s4 == s1);
		System.out.println(s4.equals(s1));
		
		String s5=s1+"";
		System.out.println(s5==s1);
		System.out.println(s5.equals(s1));
		
		String s = "heima";
	    change(s);
	    StringBuffer sb = new StringBuffer();
        sb.append("heima");
        change(sb);
	    System.out.println(s);
	    System.out.println(sb.toString());
	    
	    String a5 = "abc";
	    StringBuffer s6 = new StringBuffer(a5);
	    System.out.println(a5.equals(s6));
	    
	    System.out.println(reverse("1234567"));
	    
	}
	
	public static void change(String s) {
		s = "444";
	}
	
	public static void change(StringBuffer sb) {
        sb.append("itcast");
    }
	
	/**
	 *  反转字符串
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param s
		* @return void    返回类型 
		* @throws
	 */
	public static String reverse(String s) {
		int num = (s.length() + 1)/2;
		char[] chars = s.toCharArray();
		for (int i = 0; i < num; i++) {
			char temp = chars[i];
			chars[i] = chars[s.length()-1-i];
			chars[s.length()-1-i] = temp;
		}
		return String.valueOf(chars);
	}


}
