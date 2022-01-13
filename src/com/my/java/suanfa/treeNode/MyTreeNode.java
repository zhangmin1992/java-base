package com.my.java.suanfa.treeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MyTreeNode {

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

    public static void main(String[] args) {
        TreeNode four = new TreeNode(6,null,null);
        TreeNode five = new TreeNode(8,null,null);
        TreeNode two = new TreeNode(1,null,null);
        TreeNode three = new TreeNode(7,four,five);
        TreeNode root = new TreeNode(5,two,three);

//        System.out.println(TreeDepth(root));
//        System.out.println(findDeep2(root));

//        System.out.println(JSONObject.toJSONString(levelOrder(root)));

        System.out.println(isErChaShu(root));

        System.out.println(findValInErChaShu(root,6));
    }

    //求二叉树的深度
    public static int TreeDepth(TreeNode pRoot) {
        if (pRoot == null)
            return 0;
        int left = TreeDepth(pRoot.left) + 1;
        int right = TreeDepth(pRoot.right) + 1;
        return left > right ? left : right;
    }

    //非递归求二叉树的深度
    public static int findDeep2(TreeNode root)
    {
        if(root == null)
            return 0;

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur,last;
        int level = 0;
        while(!queue.isEmpty()) {
            //记录本层已经遍历的节点个数
            cur = 0;
            //当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            last = queue.size();

            //当还没有遍历到本层最后一个节点时循环
            while(cur < last)
            {
                //出队一个元素,已经遍历的节点个数加1
                current = queue.poll();
                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1
        }
        return level;
    }

    //层次遍历
    public static List<List<String>> levelOrder(TreeNode root){
        List<List<String>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur,last;
        while(!queue.isEmpty()) {
            List<String> data = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            cur = 0;
            last = queue.size();
            while(cur < last) {
                TreeNode current = queue.poll();
                cur ++;
                temp.append(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            System.out.println(Integer.valueOf(temp.toString()));
            data.add(temp.toString());
            result.add(data);
        }
        return result;
    }

    //判断是否是二叉搜索树
    /**
     * 功能描述: 假设一个二叉搜索树具有如下特征：
           节点的左子树只包含小于当前节点的数。
     *     节点的右子树只包含大于当前节点的数。
     *     所有左子树和右子树自身必须也是二叉搜索树。
     */
    public static boolean isErChaShu(TreeNode root){
        if(root == null){
            return true;
        }

        Deque<TreeNode> s = new LinkedList<>();
        s.push(root);

        Deque<Long> minS = new LinkedList<>();
        Deque<Long> maxS = new LinkedList<>();
        minS.push(Long.MIN_VALUE);
        maxS.push(Long.MAX_VALUE);

        while(!s.isEmpty()){
            TreeNode p = s.pop();
            long min = minS.pop();
            long max = maxS.pop();

            if(p.val <= min || p.val >= max){
                return false;
            }
            if(p.right != null){
                s.push(p.right);
                minS.push((long)p.val);
                maxS.push(max);
            }
            if(p.left != null){
                s.push(p.left);
                minS.push(min);
                maxS.push((long)p.val);
            }
        }
        return true;
    }

    //在二叉搜索书中找给定的值
    public static boolean findValInErChaShu(TreeNode root,int value){
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur,last;
        while(!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while(cur < last) {
                TreeNode current = queue.poll();
                if (current.val == value) {
                    return true;
                }
                cur ++;
                if (current.left != null) {
                    //注意这里不是按照左右子树的值和value进行比较，而是按照根结点的值和value进行比较，大于value就查找左边树，小于就查右边树
                    if (current.val > value) {
                        queue.offer(current.left);
                    }
                }
                if (current.right != null) {
                    if (current.val < value) {
                        queue.offer(current.right);
                    }
                }
            }
        }
        return false;
    }

}
