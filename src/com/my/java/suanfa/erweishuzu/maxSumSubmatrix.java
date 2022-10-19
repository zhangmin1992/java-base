package com.my.java.suanfa.erweishuzu;

import java.util.TreeSet;

/**
 * 功能描述:
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 *  
 *
 * 示例 1：
 * {1, 0,1}
 * {0,-2,3}
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，
 * 且 2 是不超过 k 的最大数字（k = 2）。
 *
 */
public class maxSumSubmatrix {


    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        matrix[0] = new int[] {1, 0,1};
        matrix[1] = new int[] {0,-2,3};
        int k =2;
        System.out.println(maxSumSubmatrix2(matrix,k));
    }

    public static int maxSumSubmatrix2(int[][] matrix, int k) {
        int[][] s = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + matrix[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){

                for(int ii = 0; ii < i; ii++){
                    for(int jj = 0; jj < j; jj++){

                        int sum = s[i][j] - s[ii][j] - s[i][jj] + s[ii][jj];
                        if(sum <= k) {
                            ans = Math.max(ans, sum);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
