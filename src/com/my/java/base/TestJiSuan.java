package com.my.java.base;

import sun.java2d.cmm.kcms.CMM;

/**
 * 功能描述: float bfloat = 3.31F; double aDouble = 9.8; 相加会变成double 类型，这个值有尾差13.109999942779542
 * @Author: zhangmin
 * @Date: 2020/4/21 9:43 AM
 */
public class TestJiSuan {
    public static  void main(String[] args) {
        /**
         * 3.327358，精度为6-7位
         * 3.327357891927496，精度位15-16位
         * float 4个字节,32位,float：1bit（符号位）+8bits（指数位+23bits（尾数位）
         * float：2^23 = 8388608，共七位，意味着最多能有7位有效数字，但绝对能保证的为6位，也即float的精度为6~7位有效数字；
         * double 8个字节,64位,double：1bit（符号位）+ 11bits（指数位）+ 52bits（尾数位）
         * double：2^52 = 4503599627370496，一共16位，同理，double的精度为15~16位。
         */
        float jingdufloat = 3.327357891F;
        System.out.println(jingdufloat);
        double jingdudouble = 3.327357891927495768D;
        System.out.println(jingdudouble);

        /**
         * 单独执行结果8，9
         */
        int aInt = 3;
        int bInt = 5;
        System.out.println(bInt + aInt++);
        System.out.println(bInt + (++aInt));

        /**
         * 功能描述:127的二进制是1111111,128超过有符号数最大值，二进制是10000000
         */
        char char1 = 128;
        System.out.println(Integer.toBinaryString(char1));

        /**
         * 功能描述: float afloat = 3; float bfloat = 3.0F 比较是相等的
         */
        float afloat = 3;
        float bfloat = 3.0F;
        System.out.println(bfloat == 3);
        System.out.println(afloat == bfloat);

        Float aafloat = new Float(3);
        Float bbfloat = new Float(3.0);
        System.out.println(bbfloat == 3);
        System.out.println(aafloat == bbfloat);
        System.out.println(aafloat.equals(bbfloat));


        /**
         * 功能描述: float bfloat = 3.31F; double aDouble = 9.8; 相加会变成double 类型，
         * 这个值有尾差13.109999942779542
         */
        bfloat = 3.31F;
        double aDouble = 9.8;
        System.out.println(bfloat + aDouble);

        /**
         * 功能描述: int占位32位，正数的源码和补码一样，负数是按位取反，末尾加1
         * 17的二进制是10001
         * -17的二进制是 10001 取反01110，加1，01111，也就是111111111111111111111111111 01111
         *
         * << 3; 正数左移几位，就是在原数的基础上生意2的几次方
         * 11111111111111111111111111101111 << 3;就是左边移动3位，末尾补0
         * 11111111111111111111111101111000
         *
         * 10001  >> 3; 变成10
         * 11111111111111111111111111101111 >> 3; 就是右边移动3位，负数高位补1
         */
        int aint = -17;
        System.out.println(Integer.toBinaryString(aint));
        aint = aint << 3;
        System.out.println(Integer.toBinaryString(aint));
        aint = -17;
        aint = aint >> 3;
        System.out.println(Integer.toBinaryString(aint));

        /**
         * 功能描述: float double基本类型的数据在强制转化int的时候，会丢失精度
         * Math.round(afloat3) >0.5就会计算位1
         */
        float afloat2 = 2.7F;
        float afloat3 = 2.5F;
        System.out.println((int)afloat2);
        System.out.println((int)afloat3);
        System.out.println(Math.round(afloat3));

    }
}
