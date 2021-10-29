package com.my.java.suanfa.ListNode;

/**
 * 功能描述: 要求一次遍历链表，求链表中的中节点
 * 如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：
 *
 * 我们让两个指针slow和fast分别指向链表头结点head。
 * 每当慢指针slow前进一步，快指针fast就前进两步，
 * 这样，当fast走到链表末尾时，slow就指向了链表中点。
 */
public class middleNode {
   public static ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
