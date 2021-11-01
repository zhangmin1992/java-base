package com.my.java.suanfa.huadongchuangkou;

import java.util.HashMap;

/**
 * 功能描述: 给定一个字符串S1 S2，判断S2中是否包含S1的排列,S1的排列可以理解为不重复的随机排列的字符
 *  输入：ab     cba 返回true
 *  输入：ab     cbca 返回false
 */
public class TestString5 {
    public static void main(String args[]) {
        System.out.println(checkInclusion("ab","cbca"));
        System.out.println(checkInclusion("ab","sbcaaddabrd"));

    }

    public static boolean checkInclusion(String t, String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
