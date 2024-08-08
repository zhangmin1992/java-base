package com.my.java.suanfa;

import java.util.Stack;

public class zhengshufanzhuan {

    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.add(2);
//        stack.add(1);
//        stack.add(3);
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());

//        System.out.println(reverse(1147483649));
        System.out.println(reverseV2(1147483649));
    }

    /**
     * 功能描述: 这是我写的方法， 用到了栈，还要考虑正负数 还用到了字符之间的各种转换比较麻烦 还没有考虑整数越界的情况
     */
    public static int reverse(int x) {
        int result = 0;
        StringBuffer sb = new StringBuffer();
        if (x == 0) {
            return result;
        } else if (x < 0) {
            sb.append("-");
            x = -x;
        }
        Stack<Integer> stack = new Stack<>();
        for (Character temp : String.valueOf(x).toCharArray()) {
            //这里要写temp.toString()，注释的写法是不对的，插入的是1的字节码49而不是1
//            stack.add(Integer.valueOf(temp));
            stack.add(Integer.valueOf(temp.toString()));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.toString());
    }

    public int reverseV3(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static int reverseV2(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            //每次取末尾数字，x % 10就是末尾数字
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            //判断整数溢出
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
