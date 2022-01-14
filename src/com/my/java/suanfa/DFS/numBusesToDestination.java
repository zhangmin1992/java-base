package com.my.java.suanfa.DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 功能描述: 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 */
public class numBusesToDestination {
    public static void main(String args[]) {
        int[][] routes = new int[3][];
        routes[0] = new int[]{1, 2, 7};
        routes[1] = new int[]{3, 6, 7};
        routes[2] = new int[]{7, 5, 1};

//        System.out.println(getNextStop(routes,1));
//        System.out.println(getLastStop(routes,1));

        System.out.println(getnumBusesToDestination(routes,1,6));
    }

    //找到下一个索引的索引值
    public static int getNextIndex(int index, int length) {
        int result = -1;
        if (index == length - 1) {
            result = 0;
        } else {
            result = index + 1;
        }
        return result;
    }

    //找到下一个索引的值
    public static int getNextStop(int[] router, int target) {
        int size = router.length;
        for (int index = 0; index < size; index++) {
            if (router[index] == target) {
                int nextIndex = getNextIndex(index, size);
                return router[nextIndex];
            }
        }
        return -1;
    }

    //找到上一个索引的索引值
    public static int getLastIndex(int index, int length) {
        int result = -1;
        if (index == 0) {
            result = length - 1;
        } else {
            result = index - 1;
        }
        return result;
    }

    //找到上一个索引的值
    public static int getLastStop(int[] router, int target) {
        int size = router.length;
        for (int index = 0; index < size; index++) {
            if (router[index] == target) {
                int nextIndex = getLastIndex(index, size);
                return router[nextIndex];
            }
        }
        return -1;
    }

    public static int getnumBusesToDestination(int[][] routes, int souce, int target) {
        int depth = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(souce);
        visited.add(souce);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int cur = queue.poll();

                if (cur == target) {
                    return depth;
                }
                for (int i = 0; i < routes.length; i++) {
                    //找当前数在数组中的下一个顺序
                    int nextStop = getNextStop(routes[i], cur);
                    if (nextStop != -1) {
                        if (!visited.contains(nextStop)) {
                            visited.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                    //找当前数在数组中的上一个顺序
                    int lastStop = getLastStop(routes[i], cur);
                    if (lastStop != -1) {
                        if (!visited.contains(lastStop)) {
                            visited.add(lastStop);
                            queue.offer(lastStop);
                        }
                    }
                }

            }
            depth++;
        }
        return -1;
    }
}
