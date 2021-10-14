package com.my.java.suanfa;

public class ReverseListNode {

	public static void main(String[] args) {
//		Node n5 = new Node(5);
//		Node n4 = new Node(4,n5);
//		Node n3 = new Node(3,n4);
//		Node n2 = new Node(2,n3);
//		Node n1 = new Node(1,n2);
//		showNode(n1);
//		Node newNode = reverseList(n1);
//		showNode(newNode);
		
		Node n7 = new Node(7);
		Node n6 = new Node(6,n7);
		Node n5 = new Node(5,n6);
		Node n4 = new Node(4,n5);
		Node n3 = new Node(3,n4);
		Node n2 = new Node(2,n3);
		Node n1 = new Node(1,n2);
		showNode(n1);
//		Node newNode = reverseList(n1);
		Node newNode = ReverseList_buzu_k(n1,4);
		showNode(newNode);
	}
	public static String showNode(Node node) {
        if (node == null) {
            return  "";
        }
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.val+"->");
            node = node.next;
        }
        return sb.toString().substring(0,sb.length()-2);
	}

	//链表全部反转
	public static Node reverseList(Node node) {
		  Node pre = null;
		  Node next = null;
		  while (node != null) {
		      next = node.next;
		      node.next = pre;
		      pre = node;
		      node = next;
		  }
		  return pre;
	}

	//链表第K个位置反转，比如1->2->3->4->5->6->7 执行后结果为：1->2->3->5->4->6->7
	public static Node ReverseList_buzu_k(Node head, int k){
		Node ahead = head;
		int temp;
		int count = 0;
		while (ahead.next != null) {
			if (count == k - 1) {
				temp = ahead.val;
				ahead.val = ahead.next.val;
				ahead.next.val = temp;
			}
			count++;
			ahead = ahead.next;
		}
		return head;
	}
    public static int getLength(Node head){
    	Node node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
}

class Node {
	int val;
	Node next = null;
	
	public Node(int Data) {  
        this.val = Data;  
    } 
	
	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}
