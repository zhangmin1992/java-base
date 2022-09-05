package com.my.java.suanfa.ListNode;

import java.util.PriorityQueue;

/**
 * 功能描述: K个已经升序的链表合并
 * [[5>6>9],[1->2>3>4],[1->2>3>4]] 合并为1->1->2->2->3->3->4->4->5->6->9
 */
public class mergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            //p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static void showNode(ListNode head) {
        while(head != null) {
            System.out.print(head.val  + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ListNode[] lists = new ListNode[3];
        //5>6>9
        ListNode n7 = new ListNode(9);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);
        lists[0] = n5;

        //1->2>3>4
        ListNode n4 = new ListNode(4,null);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        lists[1] = n1;

        //1->2>3>4
        ListNode n44 = new ListNode(4,null);
        ListNode n33 = new ListNode(3,n44);
        ListNode n22 = new ListNode(2,n33);
        ListNode n11 = new ListNode(1,n22);
        lists[2] = n11;

        ListNode head = mergeKLists(lists);

        showNode(head);
    }
}
