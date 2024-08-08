package com.my.java.suanfa.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 功能描述: 会议开始时间和会议结束时间，给定一组整数数组，求至少需求几个会议室
 * 比如 [10,30],[50,60],[20,35]
 * 输出结果2
 *
 * PriorityQueue 即优先队列。优先队列的作用是能保证每次取出的元素都是队列中权值最小的.
 */
public class minMeetingRooms {
    public static void main(String args[]) {
        int[][] intervals = new int[3][];
        intervals[0] = new int[]{10,30};
        intervals[1] = new int[]{50,60};
        intervals[2] = new int[]{20,35};
        System.out.println(minMeetingRooms(intervals));

//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(30);
//        queue.add(50);
//        queue.add(20);
//        queue.add(70);
//        System.out.println(queue.peek());
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[]o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
}
