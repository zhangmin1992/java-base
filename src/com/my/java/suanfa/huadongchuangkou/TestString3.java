package com.my.java.suanfa.huadongchuangkou;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;

/**
 * minWindow
 * 功能描述:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class TestString3 {
    public static void main(String args[]) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int cost = 4;
        System.out.println(JSONObject.toJSONString(maxSlidingWindow(arr, cost)));
    }

    // 滑动窗口
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int right = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        // 开始构造窗口
        while (right < nums.length) {
            // 这里的list的首位必须是窗口中最大的那位
            while (!list.isEmpty() && nums[right] > list.peekLast()) {
                list.removeLast();
            }
            // 不断添加
            list.addLast(nums[right]);
            right++;
            // 构造窗口完成，这时候需要根据条件做一些操作
            if (right >= k) {
                res[index++] = list.peekFirst();
                // 如果发现第一个已经在窗口外面了，就移除
                if (list.peekFirst() == nums[right - k]) {
                    list.removeFirst();
                }
            }
        }
        return res;
    }
}



