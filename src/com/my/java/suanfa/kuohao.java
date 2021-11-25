package com.my.java.suanfa;

import java.util.Stack;

/**
 * isValida
 * 功能描述: 输入一个字符串，其中包含[](){}六种括号，请你判断这个字符串组成的括号是否合法
 *
 *
 * 给你输入一个字符串s，你可以在其中的任意位置插入左括号(或者右括号)，请问你最少需要几次插入才能使得s变成一个合法的括号串
 * 比如说输入s = "())("，算法应该返回 2，因为我们至少需要插入两次把s变成"(())()"，
 * 这样每个左括号都有一个右括号匹配，s是一个合法的括号串
 *
 */
public class kuohao {
    public static void main(String args[]) {
//        System.out.println(isValida("[{}()({}]"));
//        System.out.println(getNumForValida("]{}()({]]"));
//        System.out.println(minInsertions("()("));

    }

    /**
     * 功能描述: 功能描述: 输入一个字符串，其中包含[](){}六种括号，请你判断这个字符串组成的括号是否合法
     */
    public static boolean isValida(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && getLeftChar(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 功能描述: 给你输入一个字符串s，你可以在其中的任意位置插入左括号(或者右括号)，请问你最少需要几次插入才能使得s变成一个合法的括号串
     */
    public static int getNumForValida(String str) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && getLeftChar(c) == stack.peek()) {
                    stack.pop();
                } else {
                    result ++;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = result + stack.size();
        }
        return result;
    }

    /**
     * 功能描述: 假设 1 个左括号需要匹配 2 个右括号才叫做合法的括号组合，
     * 那么给你输入一个括号串s，请问你如何计算使得s合法的最小插入次数呢
     */
    public static int minInsertions(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }

    /**
     * 功能描述: 对于给定的 x 对左右括号，请设计出一个函数打印出所有的括号组合形式，
     *   举个例子，当 x = 2 时，括号形式为 ()()，(())
     * ，当 x = 3 时，括号形式为 （(())），()()(), ()(())，(())()，（()()）
     */

    public static char getLeftChar(char c) {
        char result = ')';
        if (c == '}') {
            result = '{';
        } else if (c == ']') {
            result = '[';
        } else if (c == ')') {
            result = '(';
        }
        return result;
    }
}
