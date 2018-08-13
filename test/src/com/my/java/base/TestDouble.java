package com.my.java.base;

import java.math.BigDecimal;

public class TestDouble {

	public static void main(String[] args) {
		Double double1 = new Double("122.335");
		double double2 = 122.335;
		System.out.println(double2 == double1);
		System.out.println(double1.equals(double2));
		
		/**
		 * double小数转bigdecimal后四舍五入计算有误差
		 */
		BigDecimal bigG=new BigDecimal(double2).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bigG.doubleValue()); 
		
		/**
		 * float和double做四则运算误差
		 */
		double double3 = 32.669;
		System.out.println(double2-double3);
		System.out.println(0.05+0.01);
		//我们组产品可真牛逼，一天天的没需求，这一个月可该怎么办啊，周报都不知道
		
	}

}
