package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述: 求数组的全排列
 *  给定一个不含重复数字的数组 nums，返回其所有可能的全排列 。你可以按任意顺序返回答案。
 */
public class getZiji {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
//        System.out.println(JSONObject.toJSONString(subsets(nums)));
        System.out.println(JSONObject.toJSONString(permute(nums)));
//        System.out.println(JSONObject.toJSONString(permuteV2(nums)));
    }

    public static List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();

        if (nums.length == 0) {
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
        //计算数组的子集个数，N个数字也就是2的N次方
        //int num = (int) Math.pow(2,nums.length);
        int num = Double.valueOf(Math.pow(2, nums.length)).intValue();

        for (int i = 0; i < num; i++) {
            //str 从0到2的N次方中1的出现顺序也就是取值的顺序,1表示从{1,2,3}中取第一个
            String str = Integer.toBinaryString(i);
            System.out.println(str);

            List<Integer> temp = new ArrayList<>();
            for (int j = str.length() - 1; j >= 0; j--) {
                //1表示从{1,2,3}中取第一个{1}，10表示取{2},11表示{1,2}
                if (String.valueOf(str.charAt(j)).equals("1")) {
                    temp.add(nums[str.length() - 1 - j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
