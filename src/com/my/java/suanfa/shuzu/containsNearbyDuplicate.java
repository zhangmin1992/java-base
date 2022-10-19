package com.my.java.suanfa.shuzu;

import java.util.HashSet;
import java.util.Set;

public class containsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
