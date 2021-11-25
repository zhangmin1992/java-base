package com.my.java.suanfa.shuzu;

/**
 * 功能描述: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 例：输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 */
public class removeDuplicates {
    public static void main(String args[]) {
        int[] arr = {1,3,5,6,7,9};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int i = 1,j = 1;
        while(i < len)
        {
            if(nums[i] != nums[i-1])
            {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
