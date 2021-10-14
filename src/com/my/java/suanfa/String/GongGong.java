package com.my.java.suanfa.String;

public class GongGong {
    public static void main(String args[]) {
        String[] str = new String[]{"flower","flow","flight"};

        System.out.println(getGongGongQianZhui(str));

    }

    /**
     * 功能描述: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
     * 输入
     * :
     * ["flower","flow","flight"]
     * 输出
     * :
     * "fl
     */
    public static String getGongGongQianZhui(String[] str) {
        if (str == null || str.length <1) {
            return "";
        }
        StringBuffer temp = new StringBuffer(str[0]);
        int num = str[0].length();
        int i=1;
        while (i<str.length) {
            if (str[i] != "" && !str[i].contains(temp)) {
                num--;
                temp.deleteCharAt(num);
                continue;
            }
            i++;
        }
        return temp.toString();
    }
}
