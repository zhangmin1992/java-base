package com.my.java.base;

public class TestMZhuangChaiXiang {

	/**
	 *  装箱和拆箱的面试题
	 *  反编译后的源码为：这些的详细解释看
	 *  Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger2 = Integer.valueOf(2);
    Integer localInteger3 = Integer.valueOf(3);
    Integer localInteger4 = Integer.valueOf(3);
    Integer localInteger5 = Integer.valueOf(321);
    Integer localInteger6 = Integer.valueOf(321);
    Long localLong1 = Long.valueOf(3L);
    Long localLong2 = Long.valueOf(2L);
    
    System.out.println(localInteger3 == localInteger4);
    System.out.println(localInteger5 == localInteger6);
    System.out.println(localInteger3.intValue() == localInteger1.intValue() + localInteger2.intValue());
    System.out.println(localInteger3.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
    System.out.println(localLong1.longValue() == localInteger1.intValue() + localInteger2.intValue());
    System.out.println(localLong1.equals(Integer.valueOf(localInteger1.intValue() + localInteger2.intValue())));
    System.out.println(localLong1.equals(Long.valueOf(localInteger1.intValue() + localLong2.longValue())));
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param args
		* @return void    返回类型 
		* @throws
	 */
	public static void main(String[] args) {
		Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
         
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
	}

}
