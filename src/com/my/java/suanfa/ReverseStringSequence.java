package com.my.java.suanfa;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.util.StringUtils;

public class ReverseStringSequence {

	public static String reverseStringSequence(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        String[] seq = str.split(" ");
        // 定义两个指针，一个从头开始，一个从尾开始，成对交换，当两个指针相遇时则停止
        int start = 0;
        int end = seq.length - 1;
        while (start < end) {
            String temp = seq[start];
            seq[start] = seq[end];
            seq[end] = temp;
            start++;
            end--;
        }
        String result = "";
        for (String temp : seq) {
        	result += temp + " ";
		}
        return result;
    }
 
    public static void main(String[] args) {;
        String result = reverseStringSequence("I am a student.");
        System.out.println(result);
    }

}
