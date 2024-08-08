package com.my.java.suanfa;

/**
 * 功能描述: binaryToDecimal 求一个数的二进制字符串
 */
public class test {

    public static void main(String[] args) {
        System.out.println(binaryToDecimal(15));
        System.out.println(binaryToDecimal(8));
    }

    public static String binaryToDecimal(int n) {
        int yu = 0;
        int t = 0;
        int result = 0;
        while (n != 0) {
            yu = n % 2;
            n = n / 2;
            //计算10的密次方
            result = result +  yu * (int) Math.pow(10,t);
            t++;
        }
        return "" + result;
    }

}
