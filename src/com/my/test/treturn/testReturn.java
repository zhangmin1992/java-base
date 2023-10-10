package com.my.test.treturn;

public class testReturn {
    public static void main(String[] args) {
        testReturn testReturn = new testReturn();
        testReturn.test2(3);
    }

    public String autoRelevance(int age) {
        if (age >1) {
            return "2";
        }
        return "3";
    }

    public void test2(int age) {
        test(age);
        System.out.println(autoRelevance(age));
    }

    public void test(int age) {
        if (age >1) {
            return;
        }
        System.out.println(age);
    }
}
