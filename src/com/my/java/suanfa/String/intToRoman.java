package com.my.java.suanfa.String;

/**
 * 功能描述: 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class intToRoman {
    static int[] nums = {1, 5, 10, 50, 100, 500, 1000};
    static char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static int getlen(int num) {
        int len = 0;
        while (len < nums.length) {
            if (num > nums[len]) {
                len++;
            } else {
                break;
            }
        }
        return len -1;
    }

    public static String intToRoman(int num) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while (len >= 0 && num>0) {
            len = getlen(num);
            int temp = nums[len];
            int chu = num / temp;
            while (chu > 0) {
                sb.append(chars[len]);
                chu--;
            }
            num = num % temp;
        }
        return sb.toString();
    }
}
