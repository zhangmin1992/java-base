package com.my.java.suanfa.String;

/**
 * 功能描述: 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 */

public class reverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseV2(-120));
        System.out.println(reverseV2(0));
        System.out.println(reverseV2(901000));
        System.out.println(reverse(964632535));
    }

    /**
     * 功能描述: 官方高效率的问题解答
     */
    public static int reverseV2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 功能描述: 我的方案：缺点：新建了临时变量temp，len，isExists，StringBuilder等浪费空间
     * 需要int转string，遍历string判断字符添加
     */
    public static int reverse(int x) {
        String temp = "";
        int len = 0;
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append("-");
            temp = String.valueOf(Math.abs(x));
        } else {
            temp = String.valueOf(x);
        }
        len = temp.length();

        boolean isExists = false;
        for (int i=len-1;i>=0;i--) {
            //字符串整数中的字符用这个来判断
            Integer c = Integer.valueOf(String.valueOf(temp.charAt(i)));
            if (c > 0 || isExists) {
                sb.append(c);
                isExists = true;
            }
        }
        return sb.toString().length() == 0 ? 0 : Integer.valueOf(sb.toString());
    }
}
