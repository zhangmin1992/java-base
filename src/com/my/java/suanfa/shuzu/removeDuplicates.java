package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

/**
 * removeDuplicates
 * 功能描述: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 例：输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class removeDuplicates {
    public static void main(String args[]) {
//        int[] arr = {1,6,5,6,6,9};
//        System.out.println(removeDuplicates(arr));

//        System.out.println(removeElement(arr,6));
//        System.out.println(JSONObject.toJSONString(arr));

        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(isValidSudoku(board));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int i = 1, j = 1;
        while (i < len) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while (i < len) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    static boolean isValidSudoku(char[][] board) {
        int[][] x = new int[9][9];
        int[][] y = new int[9][9];
        int[][][] s = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int sx = i / 3;
                int sy = j / 3;
                if (x[i][num] == 1 || y[num][j] == 1 || s[sx][sy][num] == 1) {
                    return false;
                }
                x[i][num] = 1;
                y[num][j] = 1;
                s[sx][sy][num] = 1;
                System.out.println(JSONObject.toJSONString(x) + "--" + JSONObject.toJSONString(y) + "---" + JSONObject.toJSONString(s));
            }
        }
        return true;
    }
}
