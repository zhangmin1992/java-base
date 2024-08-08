package com.my.java.suanfa;

import java.util.Arrays;

public class huisu {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(canPartitionKSubsets(nums, 3));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {//比均分的数目还小就肯定不能均分
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {//想要均分成k个区间，那么每个区间的值一定相等，因此sum一定能被k整除
            return false;
        }
        int len = sum / k;//每个区间要满足的大小
        //桶
        int[] bucket = new int[k];
        //剪枝：倒序效率更高
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return dfs(nums, bucket, len, k, 0);
    }

    private static boolean dfs(int[] nums, int[] bucket, int len, int k, int index) {
        if (nums.length == index) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (bucket[i] + nums[index] > len) {//装不下，就放到下一个桶中去
                continue;
            }
            bucket[i] += nums[index];
            if (dfs(nums, bucket, len, k, index + 1)) {
                return true;
            }
            bucket[i] -= nums[index];
            if (bucket[i] == 0)
                return false;//到了这儿，若为0，说明没有合适的值等于len
        }
        return false;
    }

}
