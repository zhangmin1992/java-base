package com.my.java.suanfa.huadongchuangkou;

import java.util.HashMap;

/**
 * 功能描述: 给定一个字符串，求其中不含重复字符的最长字串的长度 比如PWWAEEPCWQ 结果EPCWQ
 */
public class TestString4 {
    public static void main(String args[]) {
        String str = "PWWAEEPCWQ";
//        System.out.println(getNoRepeatString(str));
        System.out.println(getNoRepeatStringV2(str));
    }

    public static int getNoRepeatString(String str) {
        //左右指针和结果
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();

        while (right < str.length()) {
            //有指针移动，窗口更新
            char rChar = str.charAt(right);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);
            right++;

            //有重复字符W就缩小窗口
            while (window.get(rChar) > 1) {
                char leftChar = str.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(leftChar, window.get(leftChar) - 1);
            }

            //无重复字符了
            System.out.println(left + "--" + right + "--" + str.substring(left, right));
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static String getNoRepeatStringV2(String str) {
        //左右指针和结果
        int left = 0;
        int right = 0;
        int max = 0;
        String result = "";
        HashMap<Character, Integer> window = new HashMap<>();

        while (right < str.length()) {
            //有指针移动，窗口更新
            char rChar = str.charAt(right);
            window.put(rChar, window.getOrDefault(rChar, 0) +1);
            right++;

            //有重复字符W就缩小窗口
            while (window.get(rChar) > 1) {
                char leftChar = str.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(leftChar, window.get(leftChar) -1);
            }

            //无重复字符了
            System.out.println(left + "--" + right + "--" +str.substring(left,right));
            if (right - left > max) {
                result = str.substring(left,right);
                max = right -left;
            }
        }
        return result;
    }
}
