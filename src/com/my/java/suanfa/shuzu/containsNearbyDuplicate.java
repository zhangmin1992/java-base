package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 */
public class containsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[] {9,7,1,2,3,1,9};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            System.out.println("begin " + JSONObject.toJSONString(set));
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            System.out.println("mid- " + i + "-" + k + "-" + (i - k - 1) + "-" + JSONObject.toJSONString(set));
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
