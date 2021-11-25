package com.my.java.suanfa.shuzu;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static void main(String args[]) {
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
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
}
