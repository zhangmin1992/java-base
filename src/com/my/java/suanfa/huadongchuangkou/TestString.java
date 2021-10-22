package com.my.java.suanfa.huadongchuangkou;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * minWindow
 * 功能描述: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 示例：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class TestString {
    public static void main(String args[]) {
        String s = "DADAOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    // 滑动窗口
    public static String minWindow(String s, String t) {
        // 窗口的左边界
        int l = 0;
        // 窗口的右边界
        int r = 0;
        // 记录窗口中符合字符的个数
        int valid = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 窗口里符合的字符
        HashMap<Character,Integer> window = new HashMap<>();
        // 需要的字符
        HashMap<Character,Integer> needs = new HashMap<>();

        // 记录t中字符出现的次数 needs保持不变，{"A":1,"B":1,"C":1}
        for (char c : t.toCharArray()) {
            needs.put(c,needs.getOrDefault(c, 0) + 1);
        }
        System.out.println(JSONObject.toJSONString(needs));

        while (r < s.length()) {
            // 扩大窗口
            char c = s.charAt(r);
            r++;

            // 更新窗口的数据
            if (needs.containsKey(c)) {
                // 若当前字符是满足条件的，则更新窗口window中字符出现的次数，
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 若遇到了存在的字符则窗口中字符的总次数加一
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // 满足条件（出现了需要的全部的字符即valid满足了），则缩小窗口
            while (valid == needs.size()) {
                // 计算窗口的长度
                //首次出现的满足子串DADAOBEC l=0,r=8，len=8，记录满足条件之后的start和len
                if (r - l < len) {
                    //比较当前窗口的长度和上一个窗口的最小长度，若当前窗口的长度更小则更新最小长度，否则不更新
                    start = l;
                    len = r - l;
                    System.out.println(r + "---" + start + "---" + len + "----" + s.substring(start,start+len));
                }

                // 开始缩小窗口
                char lChar = s.charAt(l);
                l++;

                // 更新窗口内的值
                if (needs.containsKey(lChar)) {
                    // 若左边的字符是needs中的，则窗口的window中字符出现的次数减一，因为要移除左边的字符
                    if (needs.get(lChar).equals(window.get(lChar))){
                        //依靠最小窗口内仍抛弃一个必需字符来跳出while循环
                        valid--;
                    }
                    // 移除窗口中window的字符出现次数
                    window.put(lChar,window.getOrDefault(lChar, 0) - 1);
                }
            }
        }
        // len 判断是否存在，不存在返回空，存在则截取s
        return len == Integer.MAX_VALUE ? "": s.substring(start, start + len);
    }
}



