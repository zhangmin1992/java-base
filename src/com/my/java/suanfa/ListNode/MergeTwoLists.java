package com.my.java.suanfa.ListNode;

/**
 *    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
      示例：
      输入：1->2->4, 1->3->4
      输出：1->1->2->3->4->4
	* @author zhangmin 
	* @date Jun 25, 2019 6:58:21 PM
 */
public class MergeTwoLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(p != null && q != null) {
			if(p.val < q.val) {
				cur.next = new ListNode(p.val);
				cur = cur.next;
				p=p.next;
			}else {
				cur.next = new ListNode(q.val);
				cur = cur.next;
				q = q.next;
			}
		}
		if(p != null) {
			cur.next = p;
		}else {
			cur.next = q;
		}
		return head.next;
	}
	
	public static void showNode(ListNode head) {
		while(head != null) {
			System.out.print(head.val  + "->");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode n7 = new ListNode(9);
		ListNode n6 = new ListNode(6,n7);
		ListNode n5 = new ListNode(5,n6);
		ListNode n4 = new ListNode(4,n5);
		ListNode n3 = new ListNode(3,n4);
		ListNode n2 = new ListNode(2,n3);
		ListNode n1 = new ListNode(1,n2);
		showNode(n1);
		ListNode nn7 = new ListNode(9);
		ListNode nn6 = new ListNode(3,nn7);
		showNode(nn6);
		ListNode node = mergeTwoLists(n1,nn6);
		showNode(node);
		 
	}

}

