package com.my.java.suanfa.String;

/**
 * 功能描述: 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class longestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //数组的长度
        int strLen = s.length();
        //left表示当前字母s.charAt(i)的左边的元素
        int left = 0;
        //表示当前字母的s.charAt(i)的右边的元素
        int right = 0;
        //上一次的长度
        int len = 1;
        //最大回文自串的长度和开始的左边位置
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            //"kks"的情况
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            //"skk"的情况
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            //"sks"的情况
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            //标记最大len和开始的left标记位置
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        System.out.println(maxStart + "---" + maxLen);
        //一开始就是回文的子串的开始元素位置为-1，因此需要maxStart + 1
        return s.substring(maxStart + 1, maxStart + 1 + maxLen);
    }
}
