package com.my.java.suanfa.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 功能描述: 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 */
public class longestPalindrome {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        set.add(3);
        System.out.println(new ArrayList<>(set));


//        System.out.println(longestPalindromeV3("babad"));
//        System.out.println(longestPalindromeV4("bb"));
//        System.out.println(longestPalindrome2("babad"));

//        String str = "kksbabad";
//        for(int i=0;i<str.length();i++) {
//            System.out.println(str.charAt(i));
//        }
//        System.out.println(str.length() + "---" + str.substring(0,8));
    }

    public static String longestPalindrome2(String s) {
        int slen = s.length();
        int maxlen = 0;
        String ans = "";
        boolean[][] p = new boolean[slen][slen];
        for (int len = 1; len <= slen; len++) {
            for (int start = 0; start < slen; start++) {
                int end = start + len - 1;
                if (end >= slen) {
                    break;
                }
                p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1]) && (s.charAt(start) == s.charAt(end));
                if (p[start][end] && len > maxlen) {
                    maxlen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 功能描述: 中心发射法求最长回文子串
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        //数组的长度
        int strLen = s.length();
        //left表示当前字母s.charAt(i)的左边的元素
        int left = 0;
        //表示当前字母的s.charAt(i)的右边的元素
        int right = 0;
        //上一次的长度
        int len = 1;
        //最大回文自串的长度和开始的左边位置
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            //"kks"的情况
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            //"skk"的情况
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            //"sks"的情况
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            //标记最大len和开始的left标记位置
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            //重新设之，因为之后会对len++
            len = 1;
        }
        System.out.println(maxStart + "---" + maxLen);
        //一开始就是回文的子串的开始元素位置为-1，因此需要maxStart + 1
        return s.substring(maxStart + 1, maxStart + 1 + maxLen);
    }

    /**
     * 功能描述: 动态规划求最长子串
     */
    public static String longestPalindromeV3(String s) {
        //只有一个字符的是最长子串
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //最大长度
        int maxLen = 1;
        //最大长度开始的位置
        int begin = 0;
        //存储是否是回文串，dp[ i ][ j ]表示字符串第 i 个字符到 第 j 个字符是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        //单个字符一定是回文，第1个字符到第1个字符只有1个字符一定是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //只考虑右上角部分
                System.out.println(i + "--" + j + "--" + chars[i] + "--" + chars[j]);
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //长度为2或3是，肯定是回文。即除去chars[i]和 chars[j]后，只要1个或0个字符。防止出现例如 i=2 j=3情况下 查看dp[3][2]。
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        //头尾元素相同呢，排除头尾元素后，是否是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

    /**
     * 功能描述: 暴力破解法则
     */
    public static String longestPalindromeV4(String s) {
        String result = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                //substring的方式是左闭右开，也就是substring是可以向右边溢出1位，所以这边为了去到全部字符是j < s.length() + 1
                System.out.println(i + "--" + j + s.substring(i, j));
                String str = s.substring(i, j);
                if (isPalindromes(str) && (j - i) > maxLen) {
                    maxLen = j - i;
                    result = str;
                }
            }
        }
        return result;
    }

    public static boolean isPalindromes(String str) {
        if (str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
