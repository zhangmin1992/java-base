package com.my.java.suanfa.DP;

/**
 * 功能描述: <br>
 *     在组合数学中，如果一个排列中所有元素都不在原先的位置上，那么这个排列就被称为错位排列。
 *
 * 给定一个从 1 到 n 升序排列的数组，你可以计算出总共有多少个不同的错位排列吗？
 *
 * 由于答案可能非常大，你只需要将答案对 109+7 取余输出即可。
 *
 * 样例:
 * 输入: 3
 * 输出: 2
 * 解释: 原始的数组为 [1,2,3]。
 * 两个错位排列的数组为 [2,3,1] 和 [3,1,2]。
 *
 * 注释:
 * n 的范围是 [1, 106]。
 */
public class findDerangement {
    public static void main(String args[]) {
        System.out.println(dp(4));
    }

    public static int dp(int n) {
        if (n == 1) {
            return 0;
        }
        if (n ==2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[2]=1;
        for (int i=3;i<=n;i++) {
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
}
