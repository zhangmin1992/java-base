package com.my.java.suanfa.treeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述: <br>
 * isBanlanceTree 判断这棵树是不是平衡二叉树
 *          一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
 * <p>
 * isWanQuanTree 判断这棵树是不是完全二叉树
 * 如果二叉树中除去最后一层节点为满二叉树，且最后一层的结点依次从左到右分布，则此二叉树被称为完全二叉树
 * 1 任何一个结点如果右孩子不为空，左孩子却是空，则一定不是完全二叉树
 * 2 当一个结点出现右孩子为空时候，判断该结点的层次遍历后继结点是否为叶子节点，如果全部都是叶子节点，则是完全二叉树，
 * 如果存在任何一个结点不是叶节点，则一定不是完全二叉树。
 */
public class BanlanceTree {
    //定义树结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String args[]) {
        TreeNode three = new TreeNode(7, null, null);
        TreeNode four = new TreeNode(7, null, null);
        TreeNode five = new TreeNode(15, null, null);
        TreeNode two = new TreeNode(20, five, null);
        TreeNode one = new TreeNode(9, four, null);
        TreeNode root = new TreeNode(3, one, two);

//        System.out.println(isBanlanceTree(root));
        System.out.println(judge(root));
    }

    public static boolean isBanlanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBanlanceTree(root.left) || !isBanlanceTree(root.right)) {
            return false;
        }
        if (getAbs(getMaxDepth(root.left), getMaxDepth(root.right)) > 1) {
            return false;
        }
        return true;
    }

    public static int getAbs(int a, int b) {
        return Math.abs(a - b);
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = getMaxDepth(root.left) + 1;
        }
        if (root.right != null) {
            rightDepth = getMaxDepth(root.right) + 1;
        }
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static boolean judge(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = true;
        while (!queue.isEmpty()) {
            //这里没有直接使用queue.poll()的原因是，如果最后那个节点没有左子树，但是有右子树，那么这个循环也会停止，
            //而且那个节点也会从队列中弹出，如果刚好是那个节点就是问题节点，那最后的结果就是有问题的，所以这里使用peek
            node = queue.peek();
            //遇见为空的直接停止
            if (node.left != null) {
                queue.add(node.left);
            } else {
                break;
            }
            //遇见为空直接停止
            if (node.right != null) {
                queue.add(node.right);
            } else {
                break;
            }
            queue.poll();
        }
        //这里搞这个判断的原因，就是看一下暂停遍历的那个节点是不是有问题，因为上面的循环并没有把这个节点弹出
        if (queue.peek().right == null) {
            queue.poll();
        }
        //这里判断队列中剩余的节点是不是都是叶子节点
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null || node.right != null) {
                flag = false;
            }
        }
        return flag;
    }
}
