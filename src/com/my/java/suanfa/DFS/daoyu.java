package com.my.java.suanfa.DFS;

/**
 * 功能描述: 求岛屿数量
 */
public class daoyu {

    public static void main(String[] args) {
        int[][] nums = new int[4][4];
        nums[0] = new int[] {1, 0, 0, 0};
        nums[1] = new int[] {1, 0, 0, 0};
        nums[2] = new int[] {0, 1, 1, 0};
        nums[3] = new int[] {0, 0, 1, 0};
        System.out.println(getDaoYuNum(nums));
    }

    static void dfs(int[][] nums, int i, int j) {
        int m = nums.length;
        int n = nums[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (nums[i][j] == 1) {
            nums[i][j] = 0;
            dfs(nums, i, j + 1);
            dfs(nums, i, j - 1);
            dfs(nums, i + 1, j);
            dfs(nums, i - 1, j);
        }
    }

    static int getDaoYuNum(int[][] nums) {
        if (nums == null) {
            return 0;
        }
        int result = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
