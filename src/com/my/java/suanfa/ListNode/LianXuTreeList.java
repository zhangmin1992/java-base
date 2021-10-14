package com.my.java.suanfa.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LianXuTreeList {
    public static void main(String args[]) {
        MyListNode head = new MyListNode(3);
        head.left = new MyListNode(9);
        head.left.left = new MyListNode(10);
        head.left.left.right = new MyListNode(11);
        head.right = new MyListNode(4);
        head.right.right = new MyListNode(5);
        head.right.left = new MyListNode(5);
        head.right.left.right = new MyListNode(6);
        head.right.left.right.left = new MyListNode(7);

        //递归求二叉树的最长序列长度
//        System.out.println(longestConsecutive(head));


//        //二叉树的最长序列长度
        List<MyListNode> result = new ArrayList<>();
        List<MyListNode> maxResult = new ArrayList<>();
        Stack<MyListNode> stack = new Stack<>();
        getLianXuTreeList(head, 3, result, stack, maxResult);
        for (MyListNode temp : maxResult) {
            System.out.println(temp.val);
        }
    }

    //记录最大的长度
    static int maxLength = 0;

    public static int longestConsecutive(MyListNode root) {
        dfs(root, null, 0);
        return maxLength;
    }

    public static void dfs(MyListNode p, MyListNode parent, int length) {
        if (p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }

    /**
     * 功能描述:求二叉树的连续序列
     * root 跟节点
     * target 希望下一个连续序列的目标值是多少，调用的时候穿跟节点的值即可
     * list 临时存储每条连续序列链
     * stack 用于获取最左节点的右节点和遍历右边的节点
     */
    public static void getLianXuTreeList(MyListNode root, int target, List<MyListNode> list, Stack<MyListNode> stack, List<MyListNode> maxLianxuResult) {
        if (root == null) {
            return;
        }
        MyListNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                //入stack
                stack.add(p);
                //是目标值，进入临时list，目标值+1
                if (p.val == target) {
                    list.add(p);
                    target = target + 1;
                    //如果本次长度大于最大长度，就重新设置maxLength的值和最长连续序列列表maxLianxuResult
                    if (list.size() > maxLength) {
                        maxLength = list.size();
                        maxLianxuResult.clear();
                        maxLianxuResult.addAll(list);
                    }
                } else {
                    //不连续后，list清空，重新设置list为当前导致不连续的对象，目标值设置为当前导致不连续对象的值+1
                    list.clear();
                    target = p.val + 1;
                    list.add(p);
                }
                p = p.left;
            }
            if (!stack.isEmpty()) {
                //最左部分1，9，10遍历完了，这里弹出10，去看最左节点的右节点
                MyListNode pop = stack.pop();
                if (pop.right != null) {
                    //希望最左节点10的下一个序列值还是10+1
                    target = pop.val + 1;
                    getLianXuTreeList(pop.right, target, list, stack, maxLianxuResult);
                }
            }
        }
    }
}
