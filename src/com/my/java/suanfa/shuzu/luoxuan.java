package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class luoxuan {
    public static void main(String[] args) {

        int[][] nums = new int[3][4];
        nums[0] = new int[]{1,2,3,4};
        nums[1] = new int[]{10,11,12,5};
        nums[2] = new int[]{9,8,7,6};
        System.out.println(JSONObject.toJSONString(luoxuan(nums)));
    }
    static void show(int[][] nums,int start, int i,int j,List<Integer> res) {
        for(int temp=start;temp<j;temp++) {
            res.add(nums[start][temp]);
        }
        for(int temp=start;temp<i;temp++) {
            res.add(nums[temp][j]);
        }
        for(int temp=j;temp>start;temp--) {
            res.add(nums[i][temp]);
        }
        for(int temp=i;temp>start;temp--) {
            res.add(nums[temp][start]);
        }
    }

    static List<Integer> luoxuan(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums[0].length == 0) {
            return res;
        }
        int m = nums.length;
        int n = nums[0].length;
        int min = Math.min(m,n);
        int len = (min +1) /2;
        for(int i =0;i<len;i++) {
            int idex = m-1-i;
            int j = n-1-i;
            int start = i;
            for(int temp=start;temp<j;temp++) {
                res.add(nums[start][temp]);
            }
            for(int temp=start;temp<idex;temp++) {
                res.add(nums[temp][j]);
            }
            for(int temp=j;temp>start;temp--) {
                res.add(nums[idex][temp]);
            }
            for(int temp=idex;temp>start;temp--) {
                res.add(nums[temp][start]);
            }
        }
        return res;
    }
}
