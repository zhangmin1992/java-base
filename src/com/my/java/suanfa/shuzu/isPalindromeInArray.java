package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)， 使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 *
 * 示例 1： 输入：words = ["abcd","dcba","lls","s","sssll"] 输出：[[0,1],[1,0],[3,2],[2,4]] 解释：可拼接成的回文串为
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 */
public class isPalindromeInArray {

    public static void main(String[] args) {
        String[] words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(JSONObject.toJSONString(palindromePairs(words)));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String name = words[i] + words[j];
                if (isPalindrome(name)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    result.add(t);
                }
                String name2 = words[j] + words[i];
                if (isPalindrome(name2)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(j);
                    t.add(i);
                    result.add(t);
                }
            }

        }
        return result;
    }

    public static boolean isPalindrome(String temp) {
        int left = 0;
        int len = temp.length();
        for (int right = len - 1; right > left; right--) {
            if (temp.charAt(right) != temp.charAt(left)) {
                return false;
            }
            left++;
        }
        return true;
    }
}
