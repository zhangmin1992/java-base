package com.my.java.suanfa.erweishuzu;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

/**
 * 功能描述:计算岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 力扣第 1020 题「飞地的数量」，这题不让你求封闭岛屿的数量，而是求封闭岛屿的面积总和
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 * <p>
 * <p>
 * 力扣第 694 题「不同的岛屿数量：还是输入一个二维矩阵，0表示海水，1表示陆地，求不同岛屿的数量
 * 怎么判断是相同岛屿呢？
 * 假设它们的遍历顺序是：
 * 下，右，上，撤销上，撤销右，撤销下
 * 如果我用分别用1, 2, 3, 4代表上下左右，用-1, -2, -3, -4代表上下左右的撤销，那么可以这样表示它们的遍历顺序：
 * 2, 4, 1, -1, -4, -2
 * 你看，这就相当于是岛屿序列化的结果，只要每次使用dfs遍历岛屿的时候生成这串数字进行比较，就可以计算到底有多少个不同的岛屿了。
 * <p>
 * <p>
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 * 示例 1:
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 */
public class daoyu {

    public static void main(String args[]) {
//        int[][] grid  = new int[4][5];
//        grid[0] = new int[] {1,1,1,1,0};
//        grid[1] = new int[] {1,1,0,1,0};
//        grid[2] = new int[] {1,1,1,0,0};
//        grid[3] = new int[] {0,0,0,0,0};
//        System.out.println(numIslands(grid));

        //[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
        int[][] grid = new int[5][8];
        grid[0] = new int[]{1, 1, 1, 1, 1, 1, 1, 0};
        grid[1] = new int[]{1, 0, 0, 0, 0, 1, 1, 0};
        grid[2] = new int[]{1, 0, 1, 0, 1, 1, 1, 0};
        grid[3] = new int[]{1, 0, 0, 0, 0, 1, 0, 1};
        grid[4] = new int[]{1, 1, 1, 1, 1, 1, 1, 0};
//        System.out.println(numEnclaves(grid));
//        System.out.println(JSONObject.toJSONString(grid));

//        System.out.println(numDistinctIslands(grid));

        System.out.println(largestIsland(grid));
    }

    //求计算岛屿数量
    public static int numIslands(int[][] grid) {
        int num = grid.length;
        int size = grid[0].length;
        int result = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    //淹没陆地
    public static void dfs(int[][] grid, int i, int j) {
        System.out.println(i + "--" + j);
        int num = grid.length;
        int size = grid[0].length;
        //因为底下有i+1，j+1等，注意这里不能越界，i>=num
        if (i < 0 || j < 0 || i >= num || j >= size) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    //求孤岛
    static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 淹掉靠边的陆地
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // 数一数剩下的陆地
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    //求不同岛屿的数量
    static int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, sb, 666);
                    islands.add(sb.toString());
                }
            }
        }
        System.out.println(JSONObject.toJSONString(islands));
        // 不相同的岛屿数量
        return islands.size();
    }

    static void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n
                || grid[i][j] == 0) {
            return;
        }
        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1); // 上
        dfs(grid, i + 1, j, sb, 2); // 下
        dfs(grid, i, j - 1, sb, 3); // 左
        dfs(grid, i, j + 1, sb, 4); // 右

        // 后序遍历位置：离开 (i, j)
        sb.append(-dir).append(',');
    }

    //最多只能将一格 0 海洋变成 1变成陆地，求最大岛屿
    public static int largestIsland(int[][] grid) {
        int[] map = new int[grid.length * grid[0].length / 2 + 3];
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fullIsland(grid, i, j, index++);
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(grid));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    map[grid[i][j]]++;
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(map));
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int t = 1, t1 = 0, t2 = 0, t3 = 0, t4 = 0;
                    if (i > 0 && (t1 = grid[i - 1][j]) > 1) {
                        t += map[t1];
                    }
                    if (i < grid.length - 1 && (t2 = grid[i + 1][j]) > 1 && t2 != t1) {
                        t += map[t2];
                    }
                    if (j > 0 && (t3 = grid[i][j - 1]) > 1 && t2 != t3 && t1 != t3) {
                        t += map[t3];
                    }
                    if (j < grid[0].length - 1 && (t4 = grid[i][j + 1]) > 1 && t4 != t3 && t2 != t4 && t1 != t4) {
                        t += map[t4];
                    }
                    max = Math.max(max, t);
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(grid));
        return max;
    }

    public static void fullIsland(int[][] grid, int i, int j, int index) {
        grid[i][j] = index;
        if (i > 0 && grid[i - 1][j] == 1) {
            fullIsland(grid, i - 1, j, index);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            fullIsland(grid, i + 1, j, index);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            fullIsland(grid, i, j - 1, index);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            fullIsland(grid, i, j + 1, index);
        }
    }


}
