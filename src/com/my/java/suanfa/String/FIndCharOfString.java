package com.my.java.suanfa.String;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * 功能描述: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回-1
 */
public class FIndCharOfString {
    public static void main(String args[]) {
        System.out.println(FindCharOfString("lovelovec"));
        System.out.println(FindCharOfStringV2("lovelovec"));
    }

    public static int FindCharOfString(String str) {
        int pos = -1;
        if (StringUtils.isEmpty(str)) {
            return pos;
        }
        HashMap<String, Integer> map = Maps.newHashMap();
        for (int i = str.length() - 1; i >= 0; i--) {
            String key = String.valueOf(str.charAt(i));
            if (!map.containsKey(key)) {
                map.put(key, i);
                //str.indexOf(key) 表示查找第一个字符出现的位置
                if (i == str.indexOf(key)) {
                    return i;
                }
            }
        }
        return pos;
    }

    public static int FindCharOfStringV2(String s) {
        int index = -1;
        //反过来，只有26个字符
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }

}
