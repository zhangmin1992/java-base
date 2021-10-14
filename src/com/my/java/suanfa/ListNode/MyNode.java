package com.my.java.suanfa.ListNode;

public class MyNode {
    private MyNode next;

    private int value;

    public MyNode(MyNode pre, MyNode next, int value) {
        this.next = next;
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
