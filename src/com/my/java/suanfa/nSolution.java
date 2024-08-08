package com.my.java.suanfa;

public class nSolution {

    /**
     * 功能描述: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 “PAYPALISHIRING” 行数为 3 时，排列如下： 在这里插入图片描述
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：“PAHN APLSIIG YIR”。
     *
     * 行数为 4 时，结果为：PIN ALSIGYAHR PI
     * 请你实现这个将字符串进行指定行数变换的函数： string convert(string s, int numRows);
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        //一行输出的情况
        if (length <= numRows || numRows == 1) {
            return s;
        }
        //发现第一行的字符每个字符的间距是行数的2倍减去首尾2个
        int d = numRows * 2 - 2;
        StringBuilder res = new StringBuilder();
        //将第一行的字符保存到 res 中
        for (int i = 0; i < length; i += d) {
            res.append(s.charAt(i));
        }
        System.out.println(res);
        //处理中间的字符，行数字是从1到最后倒数第二行
        /**
         * 功能描述: 第 2 行中 (i = 1)，A 与 L、L 与 S、S 与 I、I 与 G 的下标距离分别为 4、2、4、2
         * 第 3 行中 (i = 2)，Y 与 A、A 与 H、H 与 R 的下标距离分别为 2、4、2、4
         * 再通过分析可得出结论，每一行中从第一个字符开始，
         * 相邻 2 个字符之间的下标距离分别为 (numRows - i) * 2 - 2、2 * i、
         * (numRows - i) * 2 - 2、2 * i、
         * (numRows - i) * 2 - 2、2 * i…，所以以此为依据再编写代码即可；
         */
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i; j < length; ) {
                res.append(s.charAt(j));
                j += ((numRows - i) * 2 - 2);
                if (j < length) {
                    res.append(s.charAt(j));
                    j += 2 * i;
                }
            }
        }
        //将最后一行的字符保存到 res 中，最后一行是numRows-1,也是间隔D个间距
        for (int i = numRows - 1; i < length; i += d) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

}
