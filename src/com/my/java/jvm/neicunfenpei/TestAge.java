package com.my.java.jvm.neicunfenpei;

/**
 * 功能描述: 不到指定年龄15岁，在Survivor空间中相同年龄所有对象大小的总
 * 和大于Survivor空间的一半， 年龄大于或等于该年龄的对象就可以直接进入老年代， 无须等到MaxTenuringThreshold中要求的年龄就会进入老年代
 * @Author: zhangmin
 * @Date: 2020/4/17 10:18 AM
 */
public class TestAge {

    /**
     * 内存设置参数是： -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param args
     * @return void    返回类型
     * @throws
     */
    private static int size = 1024 * 1024;

    public static void main(String[] args) {

        byte[] one = new byte[size /4];
        byte[] two = new byte[size /4];
        //three加入后年轻代，占比：eden space 8192K, 88% used
        byte[] three = new byte[4 * size];
        //four 直接进入老年代，占比：object space 10240K, 40% used
        byte[] four = new byte[4 * size];
        four = null;
        System.gc();
        /**
         * 年轻代变化：eden space 8192K, 85% used     -》  eden space 8192K, 54% used
         * 老年代变化：object space 10240K, 40% used  -》  object space 10240K, 49% used
         * 老年代多了9%，年轻代少了30%，说明对象1和对象2进入了老年代
         */
        four = new byte[4 * size];
    }
}
