package com.my.java.suanfa.String;

/**
 * 功能描述: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(22));
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x <0) {
            return false;
        }
        int left = 0;
        String temp = String.valueOf(x);
        int len = temp.length();
        for (int right=len-1;right>left;right--) {
            if (temp.charAt(right) != temp.charAt(left)) {
                return false;
            }
            left++;
        }
        return true;
    }
}
