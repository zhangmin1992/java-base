package com.my.java.suanfa.huadongchuangkou;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Vector;

/**
 * 功能描述: 给定一个字符串S和非空的字符串t，找到S中所有是T的字母异位词的子串的索引位置
 * 字母异位词的意思是字符相同，排列不同，不包含其他字符
 */
public class TestString6 {
    public static void main(String args[]) {
        System.out.println(JSONObject.toJSONString(findAnagrams("cbaebabacd","abc")));

    }

    public static Vector<Integer> findAnagrams(String s, String t) {
        Vector<Integer> result = new Vector<>();
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
                if (valid == need.size()) {
                    result.add(left);
                }

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
        return result;
    }
}
