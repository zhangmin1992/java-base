package com.my.java.suanfa.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数
 */

/**
 * 功能描述: 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 *
 */
public class subarraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(subarraySum(nums,5));

//        int[] nums = {1,2,2,3};
//        System.out.println(JSONObject.toJSONString(twoSum(nums,5)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
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

    public static int subarraySumV2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //用快慢指针老是有问题
    public static int subarraySumV3(int[] nums, int k) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int slow = 0;
        int fast = 1;
        int sum = nums[slow] + nums[fast];
        int ans = 0;
        while (fast<nums.length || slow <nums.length) {
            if (sum == k) {
                ans++;
                int next = fast + 1;
                while (next < nums.length && nums[next] == 0) {
                    fast++;
                    ans++;
                    next = next +1;
                }
                sum -= nums[slow++];

            } else if (sum < k && fast<nums.length) {
                fast++;
                if (fast < nums.length) {
                    sum += nums[fast];
                }
            } else {
                sum-= nums[slow++];
            }
        }
        return ans;
    }
}
