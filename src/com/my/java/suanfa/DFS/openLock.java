package com.my.java.suanfa.DFS;

import java.util.*;

/**
 * 功能描述: 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： ‘0’, ‘1’, ‘2’, ‘3’, ‘4’, ‘5’, ‘6’, ‘7’, ‘8’, ‘9’ 。
 * 每个拨轮可以自由旋转：例如把 ‘9’ 变为 ‘0’，‘0’ 变为 ‘9’ 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 ‘0000’ ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 */
public class openLock {
    public static void main(String args[]) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        String initLock = "0000";
        System.out.println(getMinDistance(initLock, deadends, target));
    }

    //转盘上第 i个位置向上滑动加上1
    public static String plusOne(String lockText, int i) {
        char[] charArray = lockText.toCharArray();
        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i] += 1;
        }
        return String.valueOf(charArray);
    }

    //转盘上第 i个位置向下滑动减去1
    public static String minusOne(String lockText, int i) {
        char[] charArray = lockText.toCharArray();
        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i] -= 1;
        }
        return String.valueOf(charArray);
    }

    public static int getMinDistance(String initLock, String[] deadends, String target) {
        //存储需要跳过的死亡密码
        List<String> deadend = new ArrayList<>();
        for (String temp : deadends) {
            deadend.add(temp);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();

        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initLock);
        visited.add(initLock);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //不能旋转
                if (deadend.contains(cur)) {
                    System.out.println("不能旋转了" + cur);
                    continue;
                }
                //找到目标
                if (target.equals(cur)) {
                    return depth;
                }

                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
