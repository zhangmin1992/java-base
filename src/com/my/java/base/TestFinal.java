package com.my.java.base;

public class TestFinal {

	static class MyClass { 
	    public int i = 0; 
	} 
	
	public static StringBuffer changeValue(final StringBuffer buffer){
        //buffer重新指向另一个对象
        //buffer = new StringBuffer("hi");
        buffer.append("world");
        return buffer;
    }
	
	public static void main(String[] args) {
		/**
		 * 只有在编译期间能确切知道final变量值的情况下，编译器才会进行这样的优化
		 */
		String a = "hello2";   
        String d = "hello"; 
        final String b = "hello";
        String c = b + 2;   
        String e = d + 2; 
        System.out.println((a == c)); 
        System.out.println((a == e));
        
        /**
         * 这说明引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的
         */
        final MyClass myClass = new MyClass(); 
        System.out.println(++myClass.i);
        
        /**
         * 注释的位置会报错！，可以修改对象的内容，但是不能修改对象指向另一个对象
         */
        StringBuffer buffer = new StringBuffer("hello");
        StringBuffer sb = TestFinal.changeValue(buffer);
        System.out.println(sb);
	}
	
	

}
