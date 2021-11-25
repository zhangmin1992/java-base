package com.my.java.suanfa.shuzu;

import java.util.HashSet;
import java.util.List;

/**
 * 功能描述: 给定一个数组{1, 2, 2, 3}，求他的所有子数组
 *          给定一个字符串1234，求他的所有子集
 */
public class GetSet {

    static HashSet<List> set = new HashSet<>();

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String arr = "1234";
        boolean[] booleans = new boolean[arr.length()];
        find(arr, 0, booleans,set);
        System.out.println(set);
        System.out.println(set.size());
    }

    static void find(String str, int position, boolean[] isIns,HashSet<String> set2) {
        if (position == str.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length();i++) {
                if (isIns[i]) {
                    sb.append(str.charAt(i));
                }
            }
            set2.add(sb.toString());
        } else {
            isIns[position] = true;
            find(str, position + 1, isIns,set2);
            isIns[position] = false;
            find(str, position + 1, isIns,set2);
        }
    }

}