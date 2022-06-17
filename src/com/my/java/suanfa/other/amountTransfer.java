package com.my.java.suanfa.other;

/**
 * 功能描述: 转化数字变为大写字母
 */
public class amountTransfer {

    public static String[] units = {"元", "十", "百", "千", "万", "十万", "百万", "千万"};
    public static String[] nums = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static void main(String[] args) {
        String str = "201";
        System.out.println(amountTransfer(str));
    }

    public static String amountTransfer(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.valueOf(String.valueOf(str.charAt(i)));
            if (num != 0) {
                result.append(nums[num - 1]);
                result.append(units[len - 1 - i]);
            } else {
                if (!result.toString().substring(result.toString().length() - 1).equals("零")) {
                    if (i != str.length() - 1) {
                        result.append("零");
                    } else {
                        result.append("元");
                    }
                }
            }
        }
        return result.toString();
    }
}
