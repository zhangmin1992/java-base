package com.my.java.suanfa.String;

import com.alibaba.fastjson.JSONObject;

public class dashusum {

    public static void main(String[] args) {

        String a = "29";
        String b = "92";
//        System.out.println(add(a, b));
        System.out.println(multiply(a, b));
    }

    public static String multiply(String nums1, String nums2) {
        //结果数组
        int[] res = new int[nums1.length() + nums2.length()];
        for (int i = 0; i < nums1.length(); i++) {
            for (int j = 0; j < nums2.length(); j++) {
                //取数字每位
                int value1 = nums1.charAt(i) - '0';
                int value2 = nums2.charAt(j) - '0';
                int multiply = value1 * value2;
                res[i + j + 1] += multiply;
            }
        }
        System.out.println(JSONObject.toJSONString(res));

        //处理进位，由低到高位处理
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] >= 10) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
                System.out.println(JSONObject.toJSONString(res));
            }
        }

        //处理结果
        StringBuilder sb = new StringBuilder();
        //排除首位开始无用的0
        boolean firstZeroFlag = true;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && firstZeroFlag) {
                continue;
            } else {
                sb.append(res[i]);
                firstZeroFlag = false;
            }
        }
        return sb.toString();
    }


    public static String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (carry != 0 || index1 >= 0 || index2 >= 0) {
            int a = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int b = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int tmp = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            index1--;
            index2--;
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
