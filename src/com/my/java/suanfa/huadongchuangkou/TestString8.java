package com.my.java.suanfa.huadongchuangkou;

import java.util.HashMap;

/**
 * 功能描述: 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 *
 */
public class TestString8 {

    public static void main(String args[]) {
        System.out.println(getMaxLengthOfKZiFu("havefunonleetcode",5));
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
            while (valid == K) {
                //不重复的判断在这里，满足窗口并且大小等于K说明不重复
                if (right -left == K) {
                    System.out.println(left + "---" + right + "--" + s.substring(left,right));
                    max++;
                }

                char leftChar = s.charAt(left);
                left++;
                window.put(leftChar,window.get(leftChar) -1);
                if (window.get(leftChar) == 0) {
                    valid--;
                }
            }
        }
        return max;
    }
}
