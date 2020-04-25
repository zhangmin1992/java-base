package com.my.java.base;

public class TestLong {


	public static void main(String[] args) {
		/**
		 * 和integer一样，Long也有一个缓冲区，值在-127到128之间的数==是相等的，超过不相等
		 */
		long ee = -123;
		long eee = -ee;
		System.out.println(eee);

		Long id1 = 123L;
		Long id2 = 123L;
		System.out.println(id1 == id2);
		System.out.println(id1.equals(id2));
		
		id1 = 200L;
		id2 = 200L;
		System.out.println(id1 == id2);
		System.out.println(id1.equals(id2));
		
		/**
		 * 基本类型==包装类型，比较的是数值是否相等
		 */
		String[] strArray = new String[200];
		Long id3 = 200L;
		System.out.println(id3 == strArray.length);
		System.out.println(id1 >= id2);

		
		/**
		 * 装箱就是  自动将基本数据类型转换为包装器类型；
		 * 拆箱就是  自动将包装器类型转换为基本数据类型
		 * int或者long 与包装类型的比较，==比较的是数值是否相等
		 */
		int id3int = 200;
		long id3long = 200;
		System.out.println(id3int == id3);
		System.out.println(id3long == id3);
		System.out.println(id3.equals(id3long));
		System.out.println(id3.equals(id3int));
		 System.out.println("--------------------------------------------------------------------");
		
		/**
		 * 这些解释都可以反编译一下，在线反编译地址是:http://www.javadecompilers.com/
		 * g == (a+b)的解释：a+b会触发拆箱操作，就像是:
		 * int aint = a.intValue();
	       int bint = a.intValue();
	       int result = aint + bint;然后 判断result == g
		 * 因为 int或者long 与包装类型的比较，==比较的是数值是否相等，所以相等
		 * 
		 * 对于g.equals((a+b)的解释：a+b会触发拆箱操作，就像是:
		 * int aint = a.intValue();
	       int bint = a.intValue();
	       int result = aint + bint;然后equals会触发自动装箱操作，便调用Integer.valueOf(result)方法，这时候装箱的类型是Integer
		 * 看下equals的源码就知道，只要传过去的参数类型不是Long的会直接返回false，因此不相等
		 * long 的equals的源码是：
		 * public boolean equals(Object obj) {
        	 if (obj instanceof Long) {
                return value == ((Long)obj).longValue();
        	 }
        	 return false;
    		}
		 * 
		 * 对于g.equals(h+a)的解释：反编译后的结果是g.equals(Long.valueOf(h.longValue() + a.intValue()))
		 * h+a会触发拆箱操作，就像是:
		 * long hlong = h.longValue();
		 * int aint = a.intValue();
		 * long temp = aint + hlong;
		 * 然后long 和Long == 比较数值是相等的
		 * 然后 equals也会出发装箱操作Long.valueOf(temp),然后进行equals的数值比较，相等
		 */
		Integer a = 1;
        Integer b = 2;
        Long g = 3L;
        Long h = 2L;
        int aint = a.intValue();
        int bint = b.intValue();
        int result = aint + bint;
        System.out.println(g == (a+b));
        System.out.println(g.equals((a+b)));
        System.out.println(g == result);
        System.out.println(g.equals(result));
        
        long hlong = h.longValue();
        long temp = aint + hlong;
        System.out.println(g == (h+a));
        System.out.println(g.equals(h+a));
        System.out.println(g.equals(temp));
        System.out.println(g == temp);
        
        /**
         * 不同类型比较，equals直接返回false
         */
        Long storeidLong = new Long("22222");
        Integer stInteger = 22222;
        System.out.println(storeidLong.equals(stInteger));
        
        String aaString = "7500.0000";
        String[] aaStr  = aaString.split("\\.");
        System.out.println(Long.valueOf(aaStr[0]));
        
        /**
         * Long 可以是null，long不能是null
         */
        Long id33 = null;
        //long id332 = null;
        
	}

}
