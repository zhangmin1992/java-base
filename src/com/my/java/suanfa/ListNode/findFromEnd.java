package com.my.java.suanfa.ListNode;

/**
 * 功能描述: 要求一次遍历链表找到链表的倒数第K个节点
 */
public class findFromEnd {
    // 返回链表的倒数第 k 个节点
    public  static  ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }

    // 返回链表的倒数第 k 个节点
    public  static  ListNode deleteFromEnd(ListNode head, int k) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode p1 = fake;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = fake;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        p2.next = p2.next.next;
        return fake.next;
    }

    public static void main(String args[]) {
        ListNode n7 = new ListNode(9);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);

        ListNode node = findFromEnd(n1,6);
        ListNode node2 = deleteFromEnd(n1,6);
        System.out.println(node.val);
    }
}
