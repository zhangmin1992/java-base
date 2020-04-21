package com.my.java.jvm.neicunfenpei;

/**
 * 功能描述: <br>
 * @Param: 测试逃逸分析后数据分配在堆上，jvm参数是：
 * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
 * @Author: zhangmin
 * @Date: 2020/4/10 4:47 PM
 */
public class TestEscapeAnalysis3 {


    private int obj;

    //1。对成员变量进行赋值，test方法发生了逃逸，会分配在堆上
    public int test() {
        obj = 33;
//        int obj = 11;
        byte[] one = new byte[1024 * 2014 * 4];
        one[1] = 1;
        one[9] = 9;
        return obj;
    }

    public static void main(String[] args) {
        TestEscapeAnalysis2 testEscapeAnalysis2 = new TestEscapeAnalysis2();
        testEscapeAnalysis2.test();
        System.gc();
        System.out.printf("结束了");
    }
}

