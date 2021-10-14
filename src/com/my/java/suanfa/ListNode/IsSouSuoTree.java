package com.my.java.suanfa.ListNode;

public class IsSouSuoTree {
    public static void main(String[] args) {
        MyListNode head = new MyListNode(5);
        head.left = new MyListNode(4);
        head.right = new MyListNode(6);
        head.left.left = new MyListNode(3);
        head.left.right = new MyListNode(8);
        head.right.left = new MyListNode(7);

        System.out.println(isSouSuoTree(head));
    }

    public static  boolean isSouSuoTree(MyListNode root) {
        MyListNode left = root.left;
        MyListNode right = root.right;
        if (root == null) {
            return true;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            if (left != null && left.val > root.val) {
                return false;
            }
            if (right != null && right.val < root.val) {
                return false;
            }
        }
        if (left.val > root.val || right.val < root.val) {
            return false;
        }
        return isSouSuoTree(left) && isSouSuoTree(right);
    }
}
