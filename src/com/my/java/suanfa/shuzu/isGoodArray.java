package com.my.java.suanfa.shuzu;

public class isGoodArray {
    public static void main(String args[]) {
        int[] nums = new int[]{29,9,5,10};
//        System.out.println(gcd(29,3));
        System.out.println(isGoodArray(nums));
    }

    //求2个数的最大公约数
    public static int gcd(int num1, int num2) {
        int temp = num1 % num2;
        while (temp != 0) {
            num1 = num2;
            num2 = temp;
            temp = num1 % num2;
        }
        return num2;
    }

    static boolean isGoodArray(int[] nums) {
        int n = nums.length;
        if (n == 1 && nums[0] == 1) {
            return true;
        }
        if (n == 0 || (n == 1)) {
            return false;
        }
        int g = nums[0];
        int temp;
        for (int i = 1; i < n; i++) {
            temp = gcd(g, nums[i]);
            if (temp == 1){
                return true;
            }
            g = temp;
        }
        return false;
    }
}
