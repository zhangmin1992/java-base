package com.my.java.suanfa.String;

/**
 * 功能描述: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（
 * 例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class zixulie {

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace","abcde"));
    }


    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
