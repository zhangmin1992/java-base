package com.my.java.suanfa.ListNode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 功能描述: 二叉树的递归遍历方式
 */
public class TestListNode {
    public static void main(String[] args) {
        MyListNode head  = new MyListNode(1);
        MyListNode left = new MyListNode(2);
        MyListNode right = new MyListNode(3);
        head.left = left;
        head.right = right;
        left.left = new MyListNode(4);
        right.right = new MyListNode(5);
        left.left.right = new MyListNode(6);
        left.left.right.left = new MyListNode(7);
        left.left.right.right = new MyListNode(8);
        ArrayList<Integer> result = new ArrayList<>();
        result = preorderTraversal(head);
        System.out.println(JSONObject.toJSONString(result));
    }

    //先序遍历:跟 左 右
    public static void preorderTraversal(MyListNode root, ArrayList<Integer> ret) {
        int rootvalue = root.val;
        ret.add(rootvalue);
        if (root.left != null) {
            preorderTraversal(root.left, ret);
        }
        if (root.right != null) {
            preorderTraversal(root.right, ret);
        }
    }

    //中序遍历：左 跟 右
    public static void inorderTraversal(MyListNode root, ArrayList<Integer> ret) {
        if (root.left != null) {
            inorderTraversal(root.left, ret);
        }
        int rootvalue = root.val;
        ret.add(rootvalue);
        if (root.right != null) {
            inorderTraversal(root.right, ret);
        }
    }

    //后序遍历 左 右 跟
    public static void postorderTraversal(MyListNode root, ArrayList<Integer> ret){
        if(root.left != null){
            inorderTraversal(root.left,ret);
        }
        if(root.right != null){
            inorderTraversal(root.right,ret);
        }
        int rootvalue = root.val;
        ret.add(rootvalue);
    }

    public static ArrayList<Integer> preorderTraversal(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<MyListNode> stack = new Stack<>();
        MyListNode p =  root;
        while (p != null || !stack.empty() ) {
            while (p != null) {
                stack.push(p);
                result.add(p.val);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return  result;
    }
}

class MyListNode {
    int val;
    MyListNode left;
    MyListNode right;
    MyListNode(int val) {
        this.val = val;
    }
    MyListNode(int val,MyListNode left,MyListNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

