package com.my.java.suanfa.DP;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述: calcStep
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法
 *
 * minPathSum
 * 给你一个数组，求从[0,0]位置到[n-1,m-1]的最短路径。
 * 规定路径只能向右边或者向下边移动
 * 数组如图所示：
 * 1	3	5	9
 * 8	2	3	4
 * 5	0	6	1
 * 8	8	4	1
 *
 *
 * 给定两个字符串s1和s2，长度分别为m和n，要求找出它们最长的子序列，并返回其长度。如：
 * s1 = “HelloWorld”
 * s2 = “loop”
 * 它们的最长公共子序列为“loo”，长度为3。
 *
 * caculMaxVaule
 * 一个背包有一定的承重capacity，有n件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 *
 *
 * maxProfit
 * 买卖股票的最佳时机
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * lengthOfLIS
 *
 * minDistance
 * 求两个字符串的最短编辑距离
 *
 * getMaxZiXuHe
 * 给定一个整数数组 nums 找到一个具有最大和的连续子数组
 *
 *
 *
 */
public class DPTest {
    public static void main(String args[]) {
//        System.out.println(calcStep(5));
//
//        int[][] matrix = new int[4][4];
//        matrix[0] = new int[]{1,3,5,9};
//        matrix[1] = new int[]{8,1,3,4};
//        matrix[2] = new int[]{5,0,6,1};
//        matrix[3] = new int[]{8,8,4,1};
//
//        System.out.println(minPathSum(matrix));

//        int[] w = new int[]{16, 36, 25, 19, 26, 23};
//        int[] v = new int[]{619, 363, 582, 163, 487, 344};
//        int n = 6;
//        int cap = 35;
//        int res = caculMaxVaule(w, v, n, cap);
//        System.out.println(res);

//        int[] arr = new int[] {7,1,5,8,3,4};
//        System.out.println(maxProfit(arr));

//        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(arr));
//        System.out.println(JSONObject.toJSONString(arr));

//        String s1 = "kitten";
//        String s2 = "sitting";
//        System.out.println(minDistance(s1,s2));

//          int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
//          System.out.println(getMaxZiXuHe(arr));

//          int[] arr = new int[] {10,9,2,5,3,7,101,18};
//          System.out.println(lengthOfLIS(arr));

          int[][] arr = new int[4][4];
          arr[0] =  new int[]{2};
          arr[1] =  new int[]{3,4};
          arr[2] =  new int[]{6,5,7};
          arr[3] =  new int[]{4,1,8,3};
          System.out.println(getMinDistance2(arr));
    }

    public static int calcStep(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        int[] count = new int[n+1];
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i < n+1; i++) {
            count[i] = count[i-1]+count[i-2];
        }
        return count[n];
    }

    //时间复杂度O(M*N),空间复杂度O(M*N)
    public static int minPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        //初始化数组
        dp[0][0] = matrix[0][0];

        //因为规定路径只能向右边或者向下边移动，向下边的，初始化0列每行的dp，row为1，for是1到3
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        System.out.println(JSONObject.toJSONString(dp));

        //因为规定路径只能向右边或者向下边移动，向右边的，初始化0行每列的dp
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        System.out.println(JSONObject.toJSONString(dp));

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                System.out.println(dp[i - 1][j] + "---" + dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println(JSONObject.toJSONString(dp));
        return dp[row-1][col-1];
    }

    public static int caculMaxVaule(int[] w, int[] v, int n, int cap) {
        return 0;
    }

    // 买卖股票的最佳时机
    public static int maxProfit(int[] arr){
        if (arr.length < 2) // 天数小于2等于0收益
            return 0;
        int[] dp = new int[arr.length]; // 存放到每天的最大收益
        /**
         *  输入:
         * [7,1,5,8,3,4]
         * dp:
         * [0, 0, 4, 7, 7, 8]
         */
        dp[0] = 0; // 第一个时机的最大收益为0（这时你只能买入所以最大收益为0）
        for (int i = 1; i < arr.length; i++){
            int m = arr[i] - arr[i - 1]; // 存放当前股票价格减去前一天股票价格的值（当天的收益）
            if (m > 0){ // 不为负数则卖出
                dp[i] = dp[i - 1] + m; // 前一天的最大收益加上当天的收益（连续上升等于两天直接的差值相加）
            }else {
                dp[i] = dp[i - 1]; // 负数则不买入既当前的最大收益为昨天的最大收益
            }
        }
        return dp[arr.length - 1]; // 返回最后一天的最大收益
    }

    /**
     * 功能描述: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public static int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[i+1]=nums[j];
                i++;
                j++;

            }
        }
        return i+1;
    }

    /**
     * 功能描述: 编辑距离，又称Levenshtein距离，是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。俄罗斯科学家Vladimir Levenshtein在1965年提出这个概念。
     *
     * 例如将kitten一字转成sitting：总计需要3步
     * sitten (k→s)
     * sittin (e→i)
     * sitting (→g)
     */
    public static int minDistance(String word1, String word2) {

        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            // 从i个字符变成0个字符，需要i步（删除），kitten变为"",删除总共需要6步
            dp[i][0] = i;
        }
        System.out.println(JSONObject.toJSONString(dp));

        for (int i = 0; i < word2.length() + 1; i++) {
            // 当从0个字符变成i个字符，需要i步(增加)，""变为""sitting，新增总共需要7步
            dp[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                //当相同的时，dp[i][j] = dp[i - 1][j - 1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    System.out.println(i + "***" + j + "***"+ dp[i][j]);
                } else {
                    //当不同的时候，我们需要求三种操作的最小值
                    //其中dp[i - 1][j - 1]表示的是替换，dp[i - 1][j]表示删除字符，do[i][j - 1]表示的是增加字符
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    System.out.println(i + "---" + j + "----"+ dp[i][j]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * 功能描述: 给定一个整数数组 nums 找到一个具有最大和的连续子数组（子数组最少包含一个元素）返回 其最大和
     */
    public static int getMaxZiXuHe(int[] str) {
        if (str == null || str.length == 0) {
            return 0;
        }
        int[] dp = new int[str.length];
        dp[0] = str[0];
        for (int i=1;i<str.length;i++) {
            if(dp[i-1] >= 0) {
                dp[i] = dp[i-1] + str[i];
            } else {
                dp[i] = str[i];
            }
        }
        int max = str[0];
        for (int k=0;k<str.length;k++) {
            max = dp[k] > max ? dp[k] : max;
        }
        return max;
    }

    /**
     * 功能描述
     *  给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * :输入: [10,9,2,5,3,7,101,18]
     * 	输出: 4
     * 	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。[2,3,7,18]他的长度也是4
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            //将所有数字初试状态置为1
            dp[i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    System.out.println(i + "---" + j + "---" + dp[i]);
                }

            }
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static int getMinDistance2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        int min = dp[arr.length - 1][0];
        for (int k = 0; k < arr.length; k++) {
            min = Math.min(dp[arr.length - 1][k], min);
        }
        return min;
    }
}
