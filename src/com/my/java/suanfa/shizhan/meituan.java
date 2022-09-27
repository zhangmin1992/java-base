package com.my.java.suanfa.shizhan;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述: {0,0,1,0,2,3,0,0}
 * 变成结果{1,2,3,0,0,0,0}
 */
public class meituan {

    public static void main(String[] args) {
        int[] str = new int[]{0,0,1,0,2,3,0,0};
//        System.out.println(JSONObject.toJSONString(getResult(str)));
        System.out.println(JSONObject.toJSONString(getResult2(str)));
    }

    //方法1：构建新的int[]结果
    public static int[] getResult(int[] str) {
        if (str == null || str.length <0) {
            return null;
        }
        int[] result = new int[str.length-1];
        int i = 0;
        for(int j=0;j<str.length;j++) {
            if(str[j] != 0) {
                result[i] = str[j];
                i++;
            }
        }
        return result;
    }

    public static int[] getResult2(int[] str) {
        if (str == null || str.length <0) {
            return null;
        }
        int i = 0;
        for(int j=0;j<str.length;j++) {
            if(str[j] != 0) {
                str[i] = str[j];
                str[j] = 0;
                i++;
            }
        }
        return str;
    }

}
