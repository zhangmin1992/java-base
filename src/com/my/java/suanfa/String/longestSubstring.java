package com.my.java.suanfa.String;

import java.util.HashMap;

/**
 * 功能描述:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class longestSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("pwwkew"));
        System.out.println(getLongestSubstring(""));
        System.out.println(getLongestSubstring("abcabcbb"));


        System.out.println(getLongestSubstringV2("pwwkew"));
        System.out.println(getLongestSubstringV2(""));
        System.out.println(getLongestSubstringV2("abcabcbb"));
    }

    static int getLongestSubstring(String str) {
        int res = 0;
        int i = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < str.length(); j++) {
            if (map.containsKey(str.charAt(j))) {
                i = map.get(str.charAt(j));
            }
            map.put(str.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    static int getLongestSubstringV2(String str) {
        if(str == null) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int res = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < str.length()) {
            Character rChar = str.charAt(right);
            if (map.getOrDefault(rChar,0) == 0) {
                map.put(rChar,1);
                right++;
                res = Math.max(res,right - left);
            } else {
                Character lChar = str.charAt(left);
                map.put(lChar, 0);
                left++;
            }
        }
        return res;
    }
}
