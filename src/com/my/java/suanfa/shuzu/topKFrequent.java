package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 功能描述: 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。 你可以按 任意顺序 返回答案。
 *   1 <= nums.length <= 105 k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 示例 1: 输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2]
 */
public class topKFrequent {

    public static void main(String[] args) {
        /**
         * 功能描述: 首先测试最小堆的功能
         */
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.add(3);
        qu.add(7);
        qu.add(5);
        System.out.println(qu.poll());
        System.out.println(qu.poll());
        System.out.println(qu.peek());

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        queue.offer(new int[] {1, 13});
        queue.offer(new int[] {12, 5});
        queue.offer(new int[] {3, 6});
        System.out.println(JSONObject.toJSONString(queue.peek()));

//        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        System.out.println(JSONObject.toJSONString(topKFrequent(nums, k)));
    }


    //优先级队列好简单
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //1.countMap 存储每个元素出现的次数
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //2.构建最小堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                //这里写1是因为int[]{num,count},1存储的是count，比较的是count值
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            //堆的数量已经到了K
            if (priorityQueue.size() == k) {
                //堆中最小的元素没有当前元素的count大，所以弹出堆中最小的元素，继续放入当前元素到堆中
                if (priorityQueue.peek()[1] < count) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[] {num, count});
                }
            } else {
                //否则，直接加入堆中
                priorityQueue.offer(new int[] {num, count});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }
}
