package com.my.java.suanfa.ListNode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述:非递归方式的话是求这颗树的镜像树，然后判断两颗树是否是一样的，一样就是对称的
 */
public class isDuiChenTree {

    public static void main(String[] args) {
        MyListNode head = new MyListNode(1);
        head.left = new MyListNode(2);
        head.right = new MyListNode(2);
        head.left.left = new MyListNode(3);
        head.right.right = new MyListNode(5);
        head.left.right = new MyListNode(4);
        head.right.left = new MyListNode(6);

        ArrayList<Integer> headList = cengci(head);
        System.out.println(JSONObject.toJSONString(headList));

        MyListNode head2 = jingxiangTree(head);
        ArrayList<Integer> headList2 = cengci(head2);
        System.out.println(JSONObject.toJSONString(headList2));
        System.out.println(JSONObject.toJSONString(cengci(head)));

        MyListNode head3 = new MyListNode(1);
        head3.left = new MyListNode(2);
        head3.right = new MyListNode(2);
        head3.left.left = new MyListNode(3);
        head3.right.left = new MyListNode(6);
        System.out.println(isSame(head,head2));
    }

    public static ArrayList<Integer> cengci(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<MyListNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            MyListNode pop =  ((LinkedList<MyListNode>) queue).pop();
            result.add(pop.val);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
        return result;
    }

    public static  void swap(MyListNode pop) {
        MyListNode temp;
        temp = pop.right;
        pop.right = pop.left;
        pop.left = temp;
    }

    public static MyListNode jingxiangTree(MyListNode root) {
        Queue<MyListNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            MyListNode pop =  ((LinkedList<MyListNode>) queue).pop();
            //交换pop节点的左孩子数据和右孩子数据
            swap(pop);
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
        return root;
    }

    public static boolean isSame(MyListNode p, MyListNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
