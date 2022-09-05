package com.my.java.suanfa.treeNode;

import java.util.HashSet;

/**
 * 功能描述:
 * lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
 * 力扣第 236 题「二叉树的最近公共祖先」：
 * 给你输入一棵不含重复值的二叉树，以及存在于树中的两个节点p和q，请你计算p和q的最近公共祖先节点。
 *
 * TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes)
 * 力扣第 1676 题「二叉树的最近公共祖先 IV」：
 * 依然给你输入一棵不含重复值的二叉树，但这次不是给你输入p和q两个节点了，
 * 而是给你输入一个包含若干节点的列表nodes（这些节点都存在于二叉树中），让你算这些节点的最近公共祖先
 *
 * 力扣第 1644 题「二叉树的最近公共祖先 II」：
 * 给你输入一棵不含重复值的二叉树的，以及两个节点p和q，
 * 如果p或q不存在于树中，则返回空指针，否则的话返回p和q的最近公共祖先节点。
 *
 * 力扣第 235 题「二叉搜索树的最近公共祖先」：
 * 给你输入一棵不含重复值的二叉搜索树，以及存在于树中的两个节点p和q，请你计算p和q的最近公共祖先节点。
 * 把之前的解法代码复制过来肯定也可以解决这道题，但没有用到 BST「左小右大」的性质，显然效率不是最高的。
 * 在标准的最近公共祖先问题中，我们要在后序位置通过左右子树的搜索结果来判断当前节点是不是LCA
 */
public class lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode six = new TreeNode(6, null, seven);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode two = new TreeNode(2, seven, four);
        TreeNode five = new TreeNode(5, six, two);
        TreeNode one = new TreeNode(1, nine, eight);
        TreeNode root = new TreeNode(3, five, one);

        TreeNode[] nodes = new TreeNode[2];
        nodes[0] = seven;
        nodes[1] = four;
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        System.out.println(lowestCommonAncestor(root,nodes).val);
//        System.out.println(lowestCommonAncestor(root,five,four).val);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    // 在二叉树中寻找 val1 和 val2 的最近公共祖先节点
    static TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        // 前序位置
        if (root.val == val1 || root.val == val2) {
            // 如果遇到目标值，直接返回
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }

        return left != null ? left : right;
    }

    static TreeNode  lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // 将列表转化成哈希集合，便于判断元素是否存在
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }

        return find(root, values);
    }

    // 在二叉树中寻找 values 的最近公共祖先节点
    static TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }
        // 前序位置
        if (values.contains(root.val)){
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);
        // 后序位置，已经知道左右子树是否存在目标值
        if (right == null && left == null) {
            return null;
        }
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }
        return left != null ? left : right;
    }

    //利用二叉搜索数的特性
    static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return findV2(root, val1, val2);
    }

    // 在 BST 中寻找 val1 和 val2 的最近公共祖先节点
    static TreeNode findV2(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val > val2) {
            // 当前节点太大，去左子树找
            return findV2(root.left, val1, val2);
        }
        if (root.val < val1) {
            // 当前节点太小，去右子树找
            return findV2(root.right, val1, val2);
        }
        // val1 <= root.val <= val2
        // 则当前节点就是最近公共祖先
        return root;
    }
}
