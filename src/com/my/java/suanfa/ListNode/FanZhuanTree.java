package com.my.java.suanfa.ListNode;

public class FanZhuanTree {
    public static void main(String args[]) {
        MyListNode head = new MyListNode(4);
        head.left = new MyListNode(1);
        head.right = new MyListNode(4);
        head.left.right = new MyListNode(2);
        head.left.right.right = new MyListNode(3);
        head.right.left = new MyListNode(2);

    }

    public static void fanZhuan(MyListNode root) {
        if (root == null) {
            return;
        }
    }
}
