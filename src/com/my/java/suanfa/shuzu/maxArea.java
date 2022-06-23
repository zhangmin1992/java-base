package com.my.java.suanfa.shuzu;

/**
 * 功能描述: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 这个提注意是直线，不要被柱状图误导了{1,7}的最大面积是1不是7
 *
 */
public class maxArea {

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        //max表示最大面积，i从头指针开始，j从尾指针开始
        int i = 0, j = height.length - 1, max = 0;
        while(i < j) {
            int area = 0;
           if (height[i] < height[j]) {
               area = height[i] * (j-i);
               i++;
           } else {
               area = height[j] * (j-i);
               j--;
           }
           if (area > max) {
               max = area;
           }
        }
        return max;
    }

}
