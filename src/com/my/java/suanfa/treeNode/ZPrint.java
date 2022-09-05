package com.my.java.suanfa.treeNode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZPrint {

    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode six = new TreeNode(6, null, seven);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode two = new TreeNode(2, null, four);
        TreeNode five = new TreeNode(5, six, two);
        TreeNode one = new TreeNode(1, nine, eight);
        TreeNode root = new TreeNode(3, five, one);
        System.out.println(printZTreeNode(root));
        System.out.println(JSONObject.toJSONString(printZTreeNodeV2(root)));
    }


    public static List<List<Integer>> printZTreeNodeV2(TreeNode root) {
        List<List<Integer>> value = new ArrayList<>();//存储到的最终结果
        if (root == null)
            return value;
        int index = 0;//二叉树的深度
        int cur, last;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> va = new ArrayList<>();//临时 用于存储到value中
            //记录本层已经遍历的节点个数
            cur = 0;
            //当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            last = queue.size();

            //当还没有遍历到本层最后一个节点时循环
            while (cur < last) {
                TreeNode node = queue.poll();
                cur++;
                //根据奇偶 选择添加策略
                if (index % 2 == 0)
                    va.add(node.val);
                else
                    //偶数采用尾插法
                    va.add(0, node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            value.add(va);
            index++;
        }
        return value;
    }

    static String printZTreeNode(TreeNode head) {
        StringBuffer result = new StringBuffer("");
        if (head == null) {
            return result.toString();
        }
        int level = 1;
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        oddStack.push(head);

        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (level % 2 == 1) {
                while (!oddStack.isEmpty()) {
                    TreeNode tempTreeNode = oddStack.pop();
                    result.append(tempTreeNode.val);

                    if (tempTreeNode.left != null) {
                        evenStack.push(tempTreeNode.left);
                    }
                    if (tempTreeNode.right != null) {
                        evenStack.push(tempTreeNode.right);
                    }
                }
            } else {
                while (!evenStack.isEmpty()) {
                    TreeNode tempTreeNode = evenStack.pop();
                    result.append(tempTreeNode.val);

                    if (tempTreeNode.right != null) {
                        oddStack.push(tempTreeNode.right);
                    }
                    if (tempTreeNode.left != null) {
                        oddStack.push(tempTreeNode.left);
                    }
                }
            }

            level++;
        }
        return result.toString();
    }

    public static void printTree(TreeNode treeNode) {
        if (treeNode != null) {
            Stack<TreeNode> oddStack = new Stack<TreeNode>();
            Stack<TreeNode> evenStack = new Stack<TreeNode>(); // 偶数栈

            int line = 1; // 表示第一行

            oddStack.push(treeNode); // 根节点算奇数行, 先把根节点入奇数栈

            TreeNode tempTreeNode = null; // 临时节点

            while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
                if (line % 2 == 1) { // 奇数行

                    while (!oddStack.isEmpty()) { // 判断奇数栈是否为空
                        tempTreeNode = oddStack.pop(); // 奇数栈栈顶元素出栈
                        System.out.print(tempTreeNode.val + ", ");

                        if (tempTreeNode.left != null) {
                            evenStack.push(tempTreeNode.left); // 偶数行左子节点先进栈
                        }
                        if (tempTreeNode.right != null) {
                            evenStack.push(tempTreeNode.right); // 偶数行右子节点后进栈
                        }
                    }
                } else { // 偶数行

                    while (!evenStack.isEmpty()) { // 判断偶数栈是否为空
                        tempTreeNode = evenStack.pop(); // 偶数栈栈顶元素出栈
                        System.out.print(tempTreeNode.val + ", ");

                        if (tempTreeNode.right != null) {
                            oddStack.push(tempTreeNode.right); // 奇数行右子节点先进栈
                        }
                        if (tempTreeNode.left != null) {
                            oddStack.push(tempTreeNode.left); // 奇数行左子节点后进栈
                        }
                    }
                }
                line++; // 二叉树行加1
            }
        }
    }
}
