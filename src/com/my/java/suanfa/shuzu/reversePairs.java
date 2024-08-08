package com.my.java.suanfa.shuzu;

/**
 * 功能描述: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。 输入一个数组，求出这个数组中的逆序对的总数。 示例 : 输入: [7,5,6,4] 输出: 5
 */
public class reversePairs {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 5, 6, 4};
        System.out.println(reversePairs(arr));

    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int x1 = mergeSort(nums, left, mid);
        int x2 = mergeSort(nums, mid + 1, right);
        int x3 = merge(nums, left, mid, mid + 1, right);
        return x1 + x2 + x3;
    }

    static int merge(int[] nums, int l1, int r1, int l2, int r2) {
        int[] temp = new int[r2 - l1 + 1];
        int count = 0;
        int i = l1, j = l2, k = 0;
        while (i <= r1 && j <= r2) {
            if (nums[i] > nums[j]) {
                count = count + (l2 - i);
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= r1) {
            temp[k++] = nums[i++];
        }
        while (j <= r2) {
            temp[k++] = nums[j++];
        }
        // 把临时数组复制回原数组
        k = 0;
        for (i = l1; i <= r2; i++) {
            nums[i] = temp[k++];
        }
        return count;

    }
}
