package com.my.java.suanfa.ListNode;

/**
 *   
 *    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 *    并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
      输出：7 -> 0 -> 8
      原因：342 + 465 = 807

	* @author zhangmin 
	* @date Jun 25, 2019 5:41:46 PM
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode p = l1;
	    ListNode q = l2;
	    ListNode head = new ListNode(0);
	    ListNode cur = head;
	    int carry = 0;
	    while(p != null || q != null) {
	    	//获取链表的数据x y
	    	int x = 0;int y = 0;
	    	if(p != null) {
	    		x = p.val; 
	    	}
	    	if(q != null) {
	    		y = q.val; 
	    	}
	    	//x+y+上一次的进位
	    	int sum = carry + x + y;
	    	//下一个进位
	    	carry = sum / 10;
	    	//9+9=18 18%10=8 8表示当前的指针node
	    	cur.next = new ListNode(sum % 10);
	    	cur = cur.next;
	    	//链表下一个
	    	if(p != null) {
	    		p = p.next;
	    	}
	    	if(q != null) {
	    		q = q.next;
	    	}
	    }
	    //计算99+99的最后一个进位，导致的位数增加情况
	    if(carry > 0) {
	    	cur.next = new ListNode(carry);
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
//		ListNode n7 = new ListNode(9);
//		ListNode n6 = new ListNode(9,n7);
////		ListNode n5 = new ListNode(5,n6);
////		ListNode n4 = new ListNode(4,n5);
////		ListNode n3 = new ListNode(3,n4);
////		ListNode n2 = new ListNode(2,n3);
////		ListNode n1 = new ListNode(1,n2);
//		showNode(n6);
//		ListNode nn7 = new ListNode(9);
//		ListNode nn6 = new ListNode(9,nn7);
//		showNode(nn6);
//		ListNode node = addTwoNumbers(n6,nn6);
//		showNode(node);
		
		String[] userIdsArr = "111".split(",");
		for(String id:userIdsArr){
			System.out.println("sss");
		}
		System.out.println();
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val,ListNode next) {
		this.val = val;
		this.next = next;
	}
}
