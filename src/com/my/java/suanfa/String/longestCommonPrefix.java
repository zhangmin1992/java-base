package com.my.java.suanfa.String;

/**
 * getGongGongQianZhui
 * 功能描述: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 输入
 * :
 * ["flower","flow","flight"]
 * 输出
 * :
 * "fl
 */
public class longestCommonPrefix {
    public static void main(String args[]) {
        StringBuffer temp = new StringBuffer("flower");
        System.out.println(temp.deleteCharAt(temp.length()));

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
        //temp元素从flower开始
        StringBuffer temp = new StringBuffer(str[0]);
        int num = str[0].length();
        int i=1;
        while (i<str.length) {
            //看后面的元素是不是包含temp，如果不包含，就把temp的大小缩小1，公共个数减去1
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
