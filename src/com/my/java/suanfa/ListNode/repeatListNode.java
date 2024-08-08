package com.my.java.suanfa.ListNode;

/**
 * 功能描述: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class repeatListNode {

    static MyNode repeateListNode(MyNode node) {
        if (node == null) {
            return null;
        }
        //虚拟节点
        MyNode dummpy = new MyNode(node, -1);
        //定义当前指针
        MyNode cur = dummpy;
        while (cur.getNext() != null && cur.getNext().getNext() != null) {
            //后面的两个节点相同
            if (cur.getNext().getValue() == cur.getNext().getNext().getValue()) {
                //一直删除后面相同的节点
                int x = (int) cur.getNext().getValue();
                while (cur.getNext() != null && x == (int) cur.getNext().getValue()) {
                    cur.setNext(cur.getNext().getNext());
                }
            } else {
                cur = cur.getNext();
            }
        }
        //返回虚拟节点的下一个
        return dummpy.getNext();
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

    public static void main(String[] args) {
        MyNode four = new MyNode(null, 1);
        MyNode three = new MyNode(four, 2);
        MyNode two = new MyNode(three, 2);
        MyNode head = new MyNode(two, 4);
        MyNode result = repeateListNode(head);
        System.out.println(getNumbers(result));

    }
}
