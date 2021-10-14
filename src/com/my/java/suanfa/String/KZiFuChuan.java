package com.my.java.suanfa.String;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 给定一个字符串，求包含K个不同字符的最长字串的长度
 * 比如 字符串"qeceba"
 * K =3
 * 那么最长子串"qece" 长度为4
 *
 * 比如 字符串"cvbnteeeeqeee" K=3 ,最长子串长度为"teeee"
 *
 * 这种类似滑动窗口，利用map做一个删除和增加
 */
public class KZiFuChuan {
    public static void main(String args[]) {
        String str = "eebecccqccnt";
        System.out.println(lengthOfLongestSubstringKDistinct(str,2));
    }

    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        int result = 0;
        if (StringUtils.isEmpty(str) || k == 0) {
            return result;
        }
        StringBuffer resultStr = new StringBuffer();
        //map key存储的是字符，value存储的是字符在字符串中出现的最后一次的索引位置
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            //重复出现会覆盖
            map.put(str.charAt(right),right);
            //字符串的递归
            right ++;
            //map中存储的字符个数超过K
            if (map.size() > k) {
                //从map的value中获取最小的那个字符
                int min = Collections.min(map.values());
                //str.charAt(min)表示的是字符，在map中是key，从map中删除这个最小字符的key
                map.remove(str.charAt(min));
                //窗口滑动到min之后
                left = min + 1;
                StringBuffer tempStr = new StringBuffer();
                tempStr.append(str.substring(left,right));
                if (tempStr.length() > result) {
                    resultStr = tempStr;
                }
            } else {
                resultStr.append(str.charAt(right));
            }
            //map中存储的字符个数超过或者不超过都会走这一段，result=4-0=4
            result = Math.max(result,right -left);
        }
        System.out.println("最长字符串" + resultStr.toString());
        return result;
    }
}
