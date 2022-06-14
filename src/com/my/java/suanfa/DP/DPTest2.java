package com.my.java.suanfa.DP;

import java.util.Vector;

/**
 * 功能描述: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class DPTest2 {

    public static void main(String args[]) {
        Vector<Integer> coins = new Vector<>();
        coins.add(1);
        coins.add(5);
        coins.add(10);
        coins.add(20);
        System.out.println(coinChange(coins,11));
    }

    public static int coinChange(Vector<Integer> coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount +1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount +1;
        }

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
