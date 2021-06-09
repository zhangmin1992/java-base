package com.my.java.suanfa.ListNode;

public class MyListNode {
    int val;
    MyListNode left;
    MyListNode right;
    MyListNode(int val) {
        this.val = val;
    }
    MyListNode(int val,MyListNode left,MyListNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
