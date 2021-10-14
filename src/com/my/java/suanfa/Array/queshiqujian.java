package com.my.java.suanfa.Array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 给定一个排序的整数数据，在区间low和end之内，求不连续的缺失的数组
 * 比如[0,1,3,50,75] low=0,end=99
 * 输出"2,4-49,51-74,76,99
 */
public class queshiqujian {
    public static void main(String args[]) {
        int[] arr = {3,6,7,9,19};
        System.out.println(JSONObject.toJSONString(getQueShiQuJian(arr,0,20)));
    }

    public static List<String> getQueShiQuJian(int[] arr,int low,int end) {
        List<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        if (arr[0] > low) {
            result.add(low + "->" + (arr[0]-1));
        }
        int qiwang = arr[0] + 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] != qiwang) {
                if (qiwang < arr[i]-1){
                    result.add(qiwang + "->" + (arr[i] - 1));
                } else {
                    result.add(qiwang + "");
                }
                qiwang = arr[i] +1;
            }
            qiwang = arr[i] +1;
        }
        if (qiwang < end) {
            result.add(qiwang + "->" + (end-1));
        }
        return  result;
    }
}
