package com.my.java.suanfa.DP;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述: 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 *
 */
public class numDistinct {

    //"babgbag","bag"
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++)
            dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
                System.out.println(i + "---" + j + "----"  + dp[i][j] + "---" + t.charAt(i - 1) + "---" + s.charAt(j - 1));
            }
        }
        return dp[t.length()][s.length()];
    }

    // 滑动窗口
    public static int minWindow(String s, String t) {
        // 窗口的左边界
        int l = 0;
        // 窗口的右边界
        int r = 0;
        // 记录窗口中符合字符的个数
        int valid = 0;
        // 需要的字符
        Queue<Character> queue = new LinkedList<>();
        // 记录t中字符出现的次数 needs保持不变，{"B":1,"A":1,"G":1}
        for (char c : t.toCharArray()) {
            ((LinkedList) queue).push(c);
        }

        while (r < s.length()) {
            // 扩大窗口
            char c = s.charAt(r);
            r++;

            // 更新窗口的数据
            if (c == queue.peek()) {
                // 若当前字符是满足条件的，则真正弹出队列内容
                Character text = queue.peek();
                ((LinkedList<Character>) queue).pop();
                // 若遇到了存在的字符则窗口中字符的总次数加一
                valid++;
                //忽略最后一个字符，继续寻找最后一个字符
                if (queue.isEmpty()) {
                    ((LinkedList<Character>) queue).push(text);
                }
            }

            //队列中只剩下最后一个字符
            while (r == s.length()-1) {
                t = t.substring(0,t.length()-1);
                ((LinkedList<Character>) queue).pop();
                for (char lc : t.toCharArray()) {
                    ((LinkedList) queue).push(lc);
                }

                // 开始缩小窗口
                char lChar = s.charAt(l);
                l++;
                if (lChar == queue.peek()) {}
            }
        }
        return valid;
    }

    public static void main(String args[]) {
        System.out.println(numDistinct("babgbag","bag"));
//        System.out.println(minWindow("babgbag","bag"));
    }
}
