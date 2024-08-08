package com.my.java.suanfa.huadongchuangkou;

/**
    equalSubstring
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大子串
 */
public class TestString2 {
    public static void main(String args[]) {
        String s = "aabcdabcdqa";
        String t = "afcdqdcdeqg";
        int cost = 4;
        System.out.println(minWindow(s, t, cost));
    }

    // 窗口
    public static String minWindow(String s, String t, int cost) {
        int left = 0;
        int right = 0;
        int len = 0;
        int start = 0;
        while (right < s.length()) {
            int charCost = t.charAt(right) - s.charAt(right);
            cost = cost - charCost;
            right++;

            while (cost < 0) {
                int leftCharCost = t.charAt(left) - s.charAt(left);
                cost = cost + leftCharCost;
                left++;
            }

            if (right - left > len) {
                start = left;
                len = right - left;
            }
        }
        return len == 0 ? "" : s.substring(start,start + len);
    }
}



