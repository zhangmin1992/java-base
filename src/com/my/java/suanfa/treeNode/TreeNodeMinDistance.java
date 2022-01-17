package com.my.java.suanfa.treeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 功能描述:    求二叉树的根结点到叶子节点的最小距离
 */
public class TreeNodeMinDistance {

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
        TreeNode three = new TreeNode(22, null, null);
        TreeNode four = new TreeNode(7, null, null);
        TreeNode five = new TreeNode(15, null, null);
        TreeNode two = new TreeNode(20, null, three);
        TreeNode one = new TreeNode(9, four, five);
        TreeNode root = new TreeNode(3, one, two);

        System.out.println(getMinDistance(root));
    }

    public static int getMinDistance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left == null && cur.right == null) {
                System.out.println("找到叶子节点" + cur.val);
                int curDepth = getMinDistance(root,cur);
                if (curDepth > depth) {
                    depth = curDepth;
                }
            }
        }
        return depth == Integer.MIN_VALUE ? -1 : depth;
    }

    public static int getMinDistance(TreeNode root,TreeNode target) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            /*这里必须有这个for循环，sz表示下一层节点的个数，必须巴下一层节点弹完了才算做深度加一，否则就是弹出一个深度加1个*/
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == target.val) {
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return -1;
    }
}
