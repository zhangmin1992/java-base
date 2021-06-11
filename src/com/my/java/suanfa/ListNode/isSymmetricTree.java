package com.my.java.suanfa.ListNode;

public class isSymmetricTree {
    public static void main(String[] args) {
        MyListNode head = new MyListNode(1);
        head.left = new MyListNode(2);
        head.right = new MyListNode(2);
//        head.left.left = new MyListNode(3);
//        head.right.right = new MyListNode(3);
        head.left.right = new MyListNode(4);
        head.right.left = new MyListNode(4);
        System.out.println(isSymmetricTree(head));
    }

    public static boolean isSymmetricTree(MyListNode root) {
        if (root == null) {
            return true;
        }
        return  isSymmetricTree(root.left,root.right);
    }

    public static boolean isSymmetricTree(MyListNode left,MyListNode right) {
        //两个都为空，返回true
        if (left == null && right == null) {
            return true;
        }
        //上面没返回，说明两个不会都为空，下面判断出了有一个为空，就返回false
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
    }
}

