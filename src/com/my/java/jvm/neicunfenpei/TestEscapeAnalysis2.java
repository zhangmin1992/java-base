package com.my.java.jvm.neicunfenpei;

/**
 * 功能描述: <br>
 * @Param: 测试逃逸分析后数据分配在堆上，jvm参数是：
 * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
 * @Author: zhangmin
 * @Date: 2020/4/10 4:47 PM
 */
public class TestEscapeAnalysis2 {


//    private Person2 obj;

    //1。对成员变量进行赋值，test方法发生了逃逸，会分配在堆上
    public static  Person2 test() {
        Person2 obj = new Person2();
//         obj = new Person2();
         return  obj;
    }

    public static void main(String[] args) {
        TestEscapeAnalysis2 testEscapeAnalysis2 = new TestEscapeAnalysis2();
        testEscapeAnalysis2.test();
        System.out.printf("结束了");
    }
}

class Person2 {

    /**
     * 功能描述: <br>
     * @Param: Person2是一个大对象，静态变量one申请了4M内存
     * @Return:
     * @Author: zhangmin
     * @Date: 2020/4/10 4:45 PM
     */
    private static int size = 1024 * 1024;

    static byte[] one = new byte[2 * size];

    private int age;

    public  Person2(){
    }
}
