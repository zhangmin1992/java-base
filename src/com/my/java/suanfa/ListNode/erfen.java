package com.my.java.suanfa.ListNode;

public class erfen {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 4};
        System.out.println(search(nums, 2));
//        System.out.println(binarySearch1(nums, 0,nums.length-1,4));
//        System.out.println(binarySearch(nums,4));

    }

    //非递归
    public static int binarySearch(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            int midVal = a[mid];
            if (a[mid] < value)
                left = mid + 1;
            else if (midVal > value)
                right = mid - 1;
            else return mid;
        }
        return -1;
    }

    //二分查找的递归写法
    public static int binarySearch1(int[] a, int fromIndex, int toIndex, int value) {
        if (fromIndex > toIndex) {
            return -1;
        }
        int mid = (fromIndex + toIndex) >>> 1;
        System.out.println(mid);
        if (a[mid] < value) {
            return binarySearch1(a, mid + 1, toIndex, value);
        } else if (a[mid] > value) {
            return binarySearch1(a, fromIndex, mid - 1, value);
        } else {
            return mid;
        }
    }

    //二分查找的变形，返回数数组中最后一次出现target的位置
    public static int search(int[] nums, int target) {
        //加了一些边界，target比有序数组目标值的第一个还小，或者比最后一个还大的时候返回-1
        if (nums == null || nums.length == 0
                || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (target == nums[mid]) {
                if (mid < min) {
                    min = mid;
                }
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
