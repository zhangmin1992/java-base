package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

public class sumEvenAfterQueries {
    public static void main(String args[]) {
        int[] nums = new int[] {1,2,3,4};
        int[][] queries = new int[4][2];
        queries[0] = new int[] {1,0};
        queries[1] = new int[] {-3,1};
        queries[2] = new int[] {-4,0};
        queries[3] = new int[] {2,3};
        System.out.println(JSONObject.toJSONString(sumEvenAfterQueries(nums,queries)));

    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[nums.length];
        int num = queries.length;
        for (int i=0;i<num;i++) {
            int[] temp = queries[i];
            int val = temp[0];
            int index = temp[1];
            nums[index] = nums[index] + val;
            int sum = 0;
            for (int j : nums) {
                if (j % 2 == 0) {
                    sum += j;
                }
            }
            result[i] = sum;
        }
        return result;
    }
}
