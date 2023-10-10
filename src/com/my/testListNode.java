package com.my;

import java.util.LinkedList;
import java.util.Queue;

public class testListNode {

    public static void main(String[] args) {

        MyNode four = new MyNode(6, null, null);
        MyNode five = new MyNode(8, null, null);
        MyNode two = new MyNode(1, null, null);
        MyNode three = new MyNode(3, four, five);
        MyNode root = new MyNode(5, two, three);
        System.out.println(test(root));
    }

    static String test(MyNode head) {
        if (head == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(head);
        int size = 1;
        int level = 1;
        int cur = 0;

        while (!queue.isEmpty()) {
            cur = 0;
            size = queue.size();

            while (cur < size) {
                MyNode node = ((LinkedList<MyNode>) queue).pop();
                cur++;
                result.append(node.getValue());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            level++;
        }
        System.out.println(level);
        return result.toString();
    }
}

class MyNode {

    private int value;

    private MyNode left;

    private MyNode right;

    public MyNode(int value, MyNode left, MyNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }
}
