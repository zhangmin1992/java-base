package com.my.java.suanfa.shuzu;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述: 无序数组中找到最长连续子序列的长度
 */
public class longestConsecutive {
    public static void main(String args[]) {
        int[] nums = {44,42,41,40};
        System.out.println(longestConsecutive(nums));
    }

    /*要求在o(n)时间复杂度  用hashSet 空间换时间*/
    public static int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }

        int max = 0;

        for(int i=0; i<num.length; i++){
            if(set.contains(num[i])){
                int next = num[i] - 1;		// 找比num[i]小一个的值
                int count = 1;
                set.remove(num[i]);			// 及时的移除，减少之后的查找时间
                while(set.contains(next)){
                    set.remove(next);
                    next--;
                    count++;
                }
                next = num[i] + 1;		// 找比num[i]大一个的值
                while(set.contains(next)){
                    set.remove(next);
                    next++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
