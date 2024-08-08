package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 比如：
 *
 * 输入：[2,3,6,7]；输出：[[7], [2, 2, 3]]
 *
 * 输入：[3,4,5,6,7,8,9]；输出：[[8], [4, 4], [3, 5]]
 */
public class combinationSum {
    public static void main(String args[]) {
        int[] candidates = new int[] {2,3,6,7};
        List<List<Integer>> result = combinationSum(candidates,7);
        System.out.println(JSONObject.toJSONString(result));
    }

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        //定义list<List<Integer>>的ans返回结果
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
//        return ans;
//    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     *
     * @param list
     *            总的输出 list
     * @param tempList
     *            存放的 list
     * @param nums
     *            数组
     * @param remain
     *            剩余值
     * @param index
     *            数组下标
     */
    private static void recursive(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int index) {
        if (remain < 0) {
            // return 或者进行 add 操作后就开始执行弹出尾部元素 塞入下个元素
            return;
        }
        else if (remain == 0) {
            list.add(new ArrayList<>(tempList)); // 这里需要注意不能直接 list.add(tempList),最终 tempList 所指向的对象是空的,
            // 所以需要 new 一个新对象，将值复制进去
        }
        else {
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]); // 挨个塞入
                recursive(list, tempList, nums, remain - nums[i], i); // 由于元素可重复 所以是 i
                tempList.remove(tempList.size() - 1); // 挨个弹出
            }
        }
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            //combine记录路径上的结果将我们需要的结果写入ans
            return;
        }
        // 直接跳过，不选择当前的值
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
            //combine要存储每一次的可能结果，所以每次都要进行移除操作，让combine为空
        }
    }

    //不允许元素重复使用考虑+1即可
    private void recursive2(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int index) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) // 说明两个值相等且之前一个值已经返回
                    continue;
                tempList.add(candidates[i]);
                recursive2(list, tempList, candidates, remain - candidates[i], i + 1); // 规定数组中每个数字在每个组合中只能使用一次
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
