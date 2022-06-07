package com.my.java.base;

public class TestDouble {

	public static void main(String[] args) {

	    double d = 0.0000000000;
	    if (d == Double.valueOf("0")) {
	        System.out.println("---");
        }

//		/**
//		 * Double 和 double 的比较 跟Integer的比较相似，在任何情况 == equals 下都是相等的
//		 * 这里不是源码，而是涉及到装箱和拆箱的操作
//		 * 反编译class文件后得到的java内容为如下，因此实际上比较的是double的值是否相等
//		 *
//		 *  Double localDouble = new Double("122.365");
//    		double d = 122.365D;
//    		System.out.println(d == localDouble.doubleValue());
//		 *
//		 */
//		Double double1 = new Double("122.365");
//		double double2 = 122.365;
//		System.out.println(double2 == double1);
//		System.out.println(double1.equals(double2));
//
//
//		/**
//		 * 看valueOf源码可知,返回的是new Double，因此地址是不想等的
//		 * public static Double valueOf(double d) {
//                return new Double(d);
//           }
//		 * Integer、Short、Byte、Character、Long 是相似的valueOf的实现，因此可以直接比较
//		 * Double Float 是相似的实现
//		 */
//		Double double3 =  100.0;
//		Double double4 = 100.0;
//		System.out.println(double3 == double4);
//
//		/**
//		 * double小数转bigdecimal后四舍五入计算有误差
//		 * 因为System.out.println(new BigDecimal(double2)); 这句话得到的有尾差的BigDecimal，再取精度有误差
//		 * 可以转化为字符串然后做取精度
//		 */
//		BigDecimal bigG = new BigDecimal(double2).setScale(2, BigDecimal.ROUND_HALF_UP);
//		System.out.println(bigG.doubleValue());
//		BigDecimal bigG2 = new BigDecimal(String.valueOf(double2)).setScale(2, BigDecimal.ROUND_HALF_UP);
//		System.out.println(bigG2);
//
//		/**
//		 * float和double做四则运算误差
//		 */
//		double double5 = 32.669;
//		System.out.println(double2-double5);
//
//		/**
//		 * double 类型的数据是不能直接做加减法的
//		 */
//		System.out.println(0.05+0.01);
		
	}

}
