package com.my.java.suanfa.shuzu;
/**
 * 功能描述: 一个包含正数、负数的数组,如何找第一个缺失的正数
 * 比如
 * {0,9,8,6,4,1,-6,2,3,-5,7};
 * 这里缺失了正数5
 */
public class firstMisPosition {
    public static void main(String args[]) {
        int[] nums = {0,9,8,6,4,1,-6,2,3,-5,7};
        System.out.println(firstMissingPositive(nums));
    }
    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //这里，首先将不再范围内的元素x，置换为n+1
        for(int i = 0; i < n; i++) {
            int num = nums[i];

            if(num < 1 || num > n) {
                nums[i] = n + 1;
            }
        }

        //取对应的元素x，若在[1,n]范围内，且nums[x-1]大于0，有可能会出现重复的元素，那么置位负值
        for(int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);

            if(x >= 1 && x <= n && nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            }
        }

        int m = -1;

        //这里负数标记时存在的意思，否则是不存在的意思
        for(int i = 0; i < n; i++) {
            int x = nums[i];

            if(x > 0) {
                m = i + 1;
                break;
            }
        }

        //若没找到，则返回n+1
        return m != -1 ? m : n + 1;
    }
}
