package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class getZiji {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
//        System.out.println(JSONObject.toJSONString(subsets(nums)));
//        System.out.println(JSONObject.toJSONString(permute(nums)));
        System.out.println(JSONObject.toJSONString(permuteV2(nums)));
    }

    public static List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backtrace(perm, res, used, nums, 0);

        return res;
    }

    public static void backtrace(List<Integer> perm, List<List<Integer>> res, boolean[] used, int[] nums, int depth){
        // 判断结束条件
        if(depth == nums.length){
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        // 对每个元素进行判断，如果没有使用则进入回溯
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;
                backtrace(perm, res, used, nums, depth + 1);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }

    }

    /**
     * 功能描述: 求数组的全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();

        for(int num : nums){
            perm.add(num);
        }

        int len = nums.length;
        backtrace(len, perm, res, 0);
        return res;
    }

    public static void backtrace(int len, List<Integer> perm, List<List<Integer>> res, int first){
        // 判断结束条件
        if(first == len){
            res.add(new ArrayList<Integer>(perm));
            return;
        }

        for(int i = first; i < len; i ++){
            // 动态维护数组
            Collections.swap(perm, first, i);
            // 递归进行下一个数的选择
            backtrace(len, perm, res, first + 1);
            // 撤销操作
            Collections.swap(perm, first, i);
        }
    }

    /**
     * 功能描述:求数组的子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer l = nums.length;
        //结果集个数
        int n = (int) Math.pow(2, l);

        for (int i = 0; i < n; i++) {
            //二进制字符串
            String s = Integer.toBinaryString(i);
            System.out.println("---"+ s);
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
                    temp.add(nums[s.length() - 1 - j]); //索引数组下标
                }
            }
            result.add(temp);
        }
        return result;
    }
}
