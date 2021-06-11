package com.my.java.suanfa.ListNode;

/**
 * 功能描述: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 */
public class isSameTree {
    public static void main(String[] args) {
        MyListNode head = new MyListNode(4);
        TestListNode.insert(head,1);
        TestListNode.insert(head,6);
        TestListNode.insert(head,2);
        TestListNode.insert(head,3);
        TestListNode.insert(head,8);
        TestListNode.insert(head,5);

        MyListNode head2 = new MyListNode(4);
        TestListNode.insert(head2,1);
        TestListNode.insert(head2,6);
        TestListNode.insert(head2,2);
        TestListNode.insert(head2,3);
        TestListNode.insert(head2,8);
        TestListNode.insert(head2,5);

        System.out.println(isSame(head,head2));
    }

    public static boolean isSame(MyListNode p,MyListNode q) {
        if (p != null && q != null && p.val == q.val) {
            return isSame(p.left,q.left) && isSame(p.right,q.right);
        }
        if(p == null && q == null) {
            return true;
        }else {
            return false;
        }
    }
}
