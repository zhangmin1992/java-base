package com.my.java.suanfa.erweishuzu;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加1
 */
public class PlusOne {
    public static void main(String args[]) {
        int[] arr = {9, 8, 9};
        System.out.println(JSONObject.toJSONString(plusOne(arr)));
    }

    public static int[] plusOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] result = new int[arr.length + 1];
        int addNum = 1;
        int jinWei = 0;
        for (int index = arr.length-1; index>=0; index--) {
            jinWei = (arr[index] + addNum ) /10;
            int num = (arr[index] + addNum) % 10;
            result[arr.length -1 - index] = num;
            addNum = jinWei;
        }
        if (jinWei > 0) {
            result[0] = jinWei;
        }
        return result;
    }
}
