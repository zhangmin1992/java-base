package com.my.java.base;

public class TestInteger {

	public static void main(String[] args) {
		System.out.println("问谁呢好迷茫");
		System.out.println("会被人当作傻子的");
		/**
		 * Integer，String 所有的equals比较的是值 都相等
		 * Integer 也有常量池，值在-128到127是byte的取值范围之间的，==相等，否则false
		 * new Integer(97) 创建的对象地址不相等
		 * 源码可以看
		 * public static Integer valueOf(int i) {
		 * if (i >= IntegerCache.low && i <= IntegerCache.high)
                 return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
           }
		 * 
		 */
		Integer i5 = 97;
	    Integer i6 = 97;
	    System.out.println(i5 == i6);
	    System.out.println(i5.equals(i6));

	    Integer i7 = 197;
	    Integer i8 = 197;
	    System.out.println(i7 == i8);
	    System.out.println(i7.equals(i8));
	    
		Integer i1 = new Integer(97);
	    Integer i2 = new Integer(97);
	    System.out.println(i1 == i2);
	    System.out.println(i1.equals(i2));

	    Integer i3 = new Integer(197);
	    Integer i4 = new Integer(197);
	    System.out.println(i3 == i4);
	    System.out.println(i3.equals(i4));
	    
	    /**
	     * int 和==Integer可以直接比较，不限制范围，==和equals都是相等的
	     * 可以，基本类型==包装类型，比较的是数值是否相等
	     */
	    i3 = 200;
	    int aint = 200;
	    long along = 200;
	    System.out.println(i3.equals(aint));
	    System.out.println(i3 == aint);
	    System.out.println(i3 == along);
	    System.out.println("--------------------------------------------------------------------");
	    
	    /**
	     * 这些解释都可以反编译一下，在线反编译地址是:http://www.javadecompilers.com/
	     * 当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象的地址，
	     * 当 "=="运算符的1个操作数是基本类型，比较的就是基本类型是否相等
	     * 而如果()内包含算数运算的时候（即包含算术运算）则比较的是数值（即有算数运算的时候会触发自动拆箱的过程）
	     * 
	     * 对于c==(a+b)的解释：a+b包含了算术运算，因此触发了自动拆箱，调用各自的intValue，在做累加操作，相当于
	     * int inta = a.intValue();
	     * int intb = b.intValue();
	     * int result = inta + intb;
	     * 属于int和Integer 的==比较,比较的是值
	     * 
	     * 对于c.equals(a+b) 的解释，a+b包含了算术运算，因此触发了自动拆箱，调用各自的intValue，在做累加操作，相当于
	     * int inta = a.intValue();
	     * int intb = b.intValue();
	     * int result = inta + intb;
	     * 然后对于equals，再触发自动装箱过程，便调用Integer.valueOf(result)方法，再进行equals比较
	     * 
	     * System.out.println(c==(a+b)); 反编译的源码是
	     * Integer localInteger1 = Integer.valueOf(100);
    	   Integer localInteger2 = Integer.valueOf(200);
    	   Integer localInteger3 = Integer.valueOf(300);
    	   System.out.println(localInteger3.intValue() == localInteger1.intValue() + localInteger2.intValue());
	     * 
	     * 
	     * System.out.println(c.equals(a+b)); 反编译的源码为
	     * Integer localInteger1 = Integer.valueOf(100);
	     * Integer localInteger2 = Integer.valueOf(200);
    	   Integer localInteger3 = Integer.valueOf(300);
           System.out.println(localInteger3.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
	     */
	    Integer a = 100;
	    System.out.println("连这个都不会怎么好意111思问别人");
        Integer b = 200;
        Integer c = 300;
        Integer d = a + b;
        int result = a.intValue() + b.intValue();
		System.out.println(c==(a+b));
		System.out.println(c==d);
		System.out.println("连这个都不会22怎么好意思问别人");
		System.out.println(c.equals(a+b));
		System.out.println(c == result);
		System.out.println(c.equals(result));
		
		mytest mytest = new mytest();
		System.out.println(mytest.aaa);
		System.out.println(mytest.aaaInteger);
		
		/**
		 * 空不能转Integer
		 */

        Integer aaaInteger = Integer.valueOf(null);
		System.out.println(aaaInteger);
	}
	
	 static class mytest {
		 Integer aaaInteger;
		 int aaa;
	 }

}
