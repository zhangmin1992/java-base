package com.my.java.suanfa.ListNode;

public class MyListNode {
    int val;
    MyListNode left;
    MyListNode right;
    MyListNode(int val) {
        this.val = val;
    }
    MyListNode(int val, MyListNode right,MyListNode left) {
        this.right = right;
        this.left = left;
        this.val = val;
    }
}
