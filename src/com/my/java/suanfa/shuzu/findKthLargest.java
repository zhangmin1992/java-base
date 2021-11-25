package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述: 找到数据中第K大的数，因为从0开始排序，所以第K大实际上是K-1大的数字
 */
public class findKthLargest {
    public static void main(String args[]) {
        int[] nums = {13, 9, 5, 9, 5,8, 6, 1, 3};
//        quickSort(nums,0,nums.length-1);
        System.out.println(JSONObject.toJSONString(findKthLargest(nums, 4)));
    }

    /**
     * 功能描述: 快速排序
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            System.out.println(JSONObject.toJSONString(arr));
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void swap(int[] q, int i, int j) {
        int t = q[i];
        q[i] = q[j];
        q[j] = t;
    }

    static int quick_sort(int[] nums, int l, int r, int k) {
        if (l >= r)
            return nums[l];
        int i = l;
        int j = r;
        int mid = l + r >> 1;
        //l+r>>1表示左指针和右指针的中间那个数
        int x = nums[mid];
        System.out.println(i + "--" + j + "--" + mid);
        while (i < j) {
            //先看右边，依次往左递减
            while (x >= nums[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (x <= nums[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j)
            return quick_sort(nums, l, j-1, k);
        else
            return quick_sort(nums, j + 1, r, k);
    }

    /**
     * 功能描述: 找到数据中第K大的数，因为从0开始排序，所以第K大实际上是K-1大的数字
     */
    public static int findKthLargest(int[] nums, int k) {
        return quick_sort(nums, 0, nums.length - 1, k - 1);
    }
}
