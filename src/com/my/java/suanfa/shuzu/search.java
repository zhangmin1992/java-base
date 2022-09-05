package com.my.java.suanfa.shuzu;

public class search {
    public static void main(String[] args) {
        int[] nums = new int[] {6,7,8,9,0,1,2,3,4,5};
        System.out.println(search(nums,3));
    }
    public static int search(int[] nums, int target) {
        int k =-1;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] > min) {
                if (nums[i] == target) {
                    return i;
                }
                k++;
            }
        }
        //没有螺旋
        if (k == nums.length-1) {
            return  -1;
        }
        int left = k+1;
        int right = nums.length-1;
        while (left <right) {
            int mid = (left + right ) >> 1;
            if (mid == target) {
                return mid;
            } else if (mid > target){
                right=mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
