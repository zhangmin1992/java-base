package com.my.java.suanfa.shuzu;

public class getMiddle {
    public static void main(String args[]) {
        int[] arr = {1,3,5,6,7,9};
        System.out.println(getMiddleInArray(arr));
    }

    static int getMiddleInArray(int[] arr) {
        int left = 0;
        int result = -1;
        int right = arr.length -1;
        while (left < right) {
            left++;
            right--;
        }
        result = arr[left];
        return result;
    }
}
