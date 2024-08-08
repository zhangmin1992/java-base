package com.my.java.suanfa;

/**
 * 功能描述: n个人参加派对，其中有且仅有一名名人，名人的特征是所有人都认识他，但是他不认识任何人，找这个名人
 * 有就返回 没有就返回-1
 */
public class findCelebrity {

    public static boolean knows(int celebrity, int i) {
        if (celebrity == 9) {
            return false;
        }
        return true;
    }

    public static int findCelebrity(int n) {
        int celebrity = 0;  // 先假定 0 就是名人
        for (int i = 1; i < n; i++) {
            // knows(celebrity, i) 为 false，说明 celebrity 可能是名人
            if (knows(celebrity, i)) {
                // knows(celebrity, i) 为 true,celebrity 认识 i，celebrity 肯定不是名人，i 可能是名人
                celebrity = i;
            }
        }
        // 检验一下这个 celebrity 是否真的是名人
        for (int i = 0; i < n; i++) {
            if (celebrity == i) continue;
            if (knows(celebrity, i) || !knows(i, celebrity)) {
                return -1;
            }
        }
        return celebrity;
    }

    public static void main(String args[]) {
        System.out.println(findCelebrity(10));
    }
}
