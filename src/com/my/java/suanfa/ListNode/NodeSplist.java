package com.my.java.suanfa.ListNode;

/**
 * 功能描述:  以newhead为头的链表就是比x小的在左边,比x大的在右边 最后返回newhead即可
 */
public class NodeSplist {

    public static void main(String[] args) {
        MyNode four = new MyNode(null, 1);
        MyNode three = new MyNode(four, 2);
        MyNode two = new MyNode(three, 2);
        MyNode head = new MyNode(two, 4);
        System.out.println(getNumbers(head));
        MyNode result = getNode(head, 3);
        System.out.println(getNumbers(result));
    }

    //展示链表
    public static String getNumbers(MyNode node) {
        if (node == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.getValue() + "->");
            node = node.getNext();
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    public static MyNode getNode(MyNode head, int x) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //首先建立一个小于x的链表，然后建立一个大于等于x的链表,然后把链表串接起来
        MyNode dummySmall = new MyNode(0);
        MyNode dummyBig = new MyNode(0);
        MyNode small = dummySmall;
        MyNode big = dummyBig;
        while (head != null) {
            if (head.getValue() < x) {
                small.setNext(head);
                small = small.getNext();
            } else {
                big.setNext(head);
                big = big.getNext();
            }
            MyNode preHead = head;
            head = head.getNext();
            preHead.setNext(null);
        }
        small.setNext(dummyBig.getNext());
        return dummySmall.getNext();
    }
}


