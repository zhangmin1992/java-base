package com.my.java.base;

import java.math.BigDecimal;

public class TestBigdecimal {

	public static void main(String[] args) {
		/**
		 * BigDecimal 初始化使用字符串，否则会有尾差
		 * BigDecimal之间的值比较只能使用compareTo，否则可能会有尾差问题
		 */
		BigDecimal b1 = new BigDecimal("10.511");
		BigDecimal b2 = new BigDecimal(10.511);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
		System.out.println(b1.compareTo(b1) == 0);
		
		/**
		 * 你也看到了BigDecimal转integer因为integer的取值范围问题，算出来得数不准
		 */
		BigDecimal b3 = new BigDecimal("2147483647");
		BigDecimal b4 = new BigDecimal("10");
		BigDecimal result = b3.multiply(b4);
		System.out.println(result);
		Integer resultInteger = result.intValue();
		System.out.println(resultInteger);
		
		/**
		 * 因为BigDecimal的对象不可变性，对BigDecimal的累加操作需要自己赋值
		 */
		BigDecimal price = BigDecimal.ZERO;
		price.add(new BigDecimal(6));
		System.out.println(price);
		
		/**
		 * BigDecimal 的取整数，四舍五入，截断小数点后几位，非0就进一位的写法
		 * 除法直接相除的时候，1/3除不尽的常见写法，会报异常Exception in thread "main" java.lang.ArithmeticException: 
		 * Non-terminating decima    l expansion; no exact representable decimal result.
		 */ 
		BigDecimal num1 = new BigDecimal("10.4855");  
		BigDecimal num2 = new BigDecimal("10.4815");  
		System.out.println("四舍五入取整："+ num1.setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入保留2位小数："+ num1.setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println("保留2位小数其他截断："+ num1.setScale(2, BigDecimal.ROUND_DOWN));
		System.out.println("非0就进一位："+ num2.setScale(2, BigDecimal.ROUND_UP));
		
	     num1 = new BigDecimal("10");  
		//System.out.println(num1.divide(new BigDecimal("3")));  
		//System.out.println(num1.divide(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_HALF_UP)); 
	     System.out.println(num1.divide(new BigDecimal("3"), 2, BigDecimal.ROUND_HALF_UP));
	}

}
