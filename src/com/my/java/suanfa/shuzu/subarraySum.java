package com.my.java.suanfa.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数
 */
public class subarraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(subarraySum(nums,5));
    }

    public static int subarraySum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i=0;i<nums.length;++i) {
            sum += nums[i];
            count += map.getOrDefault(sum-target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
