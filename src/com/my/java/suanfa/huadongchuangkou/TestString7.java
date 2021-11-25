package com.my.java.suanfa.huadongchuangkou;

import java.util.HashMap;

/**
 * 功能描述: 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t
 */
public class TestString7 {

    public static void main(String args[]) {
//        System.out.println(getMaxLengthOf2ZiFu("ccaabbb"));
        System.out.println(getMaxLengthOfKZiFu("ccaabbb",1));
    }

    public static int getMaxLengthOf2ZiFu(String s) {
        int valid = 0;
        int max = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (window.getOrDefault(c,0) == 0) {
                valid++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (valid >2) {
                char leftChar = s.charAt(left);
                left++;
                window.put(leftChar,window.get(leftChar) -1);
                if (window.get(leftChar) == 0) {
                    valid--;
                }
            }

            //这里是收缩后符合的窗口或者还没满足valid==2的窗口
            if (right -left > max) {
                System.out.println(left + "---" + right + "--" + s.substring(left,right));
                max = right -left;
            }
        }
        return max;
    }

    public static int getMaxLengthOfKZiFu(String s,int K) {
        int valid = 0;
        int max = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (window.getOrDefault(c,0) == 0) {
                valid++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (valid > K) {
                char leftChar = s.charAt(left);
                left++;
                window.put(leftChar,window.get(leftChar) -1);
                if (window.get(leftChar) == 0) {
                    valid--;
                }
            }

            //这里是收缩后符合的窗口或者还没满足valid==2的窗口
            if (right -left > max) {
                System.out.println(left + "---" + right + "--" + s.substring(left,right));
                max = right -left;
            }
        }
        return max;
    }
}
