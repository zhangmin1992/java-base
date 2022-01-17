package com.my.java.suanfa.treeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述: <br>
 * <p>
 * TreeDepth 求二叉树的深度
 * findDeep2 非递归求二叉树的深度
 * levelOrder 层次遍历二叉树
 * isErChaShu 判断是否是二叉搜索树
 * findValInErChaShu 判断二叉树中是否存在值为6的节点
 * hasPathSum 递归求二叉树的路径和是否为6
 * hasPathSumV2 非递归求二叉树的路径和是否为6
 * getMaxLongPathSum 求叶子节点到根结点的最长路径和
 * getPath 递归求二叉树的最长走的路径，不是和是路径
 *
 * longestZigZag 求二叉树的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 */
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
//        TreeNode four = new TreeNode(6, null, null);
//        TreeNode five = new TreeNode(8, null, null);
//        TreeNode two = new TreeNode(1, null, null);
//        TreeNode three = new TreeNode(7, four, five);
//        TreeNode root = new TreeNode(5, two, three);

//        System.out.println(TreeDepth(root));
//        System.out.println(findDeep2(root));

//        System.out.println(JSONObject.toJSONString(levelOrder(root)));

//        System.out.println(isErChaShu(root));

//        System.out.println(findValInErChaShu(root,6));

//          System.out.println(hasPathSum(root,19));
//          System.out.println(hasPathSumV2(root,18));
//          System.out.println(getMaxLongPathSum(root));

//        List<Integer> list = new ArrayList<>();
//        getPath(root, list, 0);

        TreeNode eight = new TreeNode(1, null, null);
        TreeNode seven = new TreeNode(1, null, eight);
        TreeNode six = new TreeNode(1, null, seven);
        TreeNode four = new TreeNode(1, null, null);
        TreeNode five = new TreeNode(1, null, null);
        TreeNode three = new TreeNode(1, six, five);
        TreeNode two = new TreeNode(1, four, three);
        TreeNode root = new TreeNode(1, null, two);
        System.out.println(longestZigZag(root));
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
    public static int findDeep2(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            //记录本层已经遍历的节点个数
            cur = 0;
            //当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            last = queue.size();

            //当还没有遍历到本层最后一个节点时循环
            while (cur < last) {
                //出队一个元素,已经遍历的节点个数加1
                current = queue.poll();
                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1
        }
        return level;
    }

    //层次遍历
    public static List<List<String>> levelOrder(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur, last;
        while (!queue.isEmpty()) {
            List<String> data = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            cur = 0;
            last = queue.size();
            while (cur < last) {
                TreeNode current = queue.poll();
                cur++;
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
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public static boolean isErChaShu(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> s = new LinkedList<>();
        s.push(root);

        Deque<Long> minS = new LinkedList<>();
        Deque<Long> maxS = new LinkedList<>();
        minS.push(Long.MIN_VALUE);
        maxS.push(Long.MAX_VALUE);

        while (!s.isEmpty()) {
            TreeNode p = s.pop();
            long min = minS.pop();
            long max = maxS.pop();

            if (p.val <= min || p.val >= max) {
                return false;
            }
            if (p.right != null) {
                s.push(p.right);
                minS.push((long) p.val);
                maxS.push(max);
            }
            if (p.left != null) {
                s.push(p.left);
                minS.push(min);
                maxS.push((long) p.val);
            }
        }
        return true;
    }

    //在二叉搜索书中找给定的值
    public static boolean findValInErChaShu(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur, last;
        while (!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while (cur < last) {
                TreeNode current = queue.poll();
                if (current.val == value) {
                    return true;
                }
                cur++;
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

    //hasPathSum 递归求二叉树的路径和是否为6
    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int tmp = sum - root.val;
        if (root.left == null && root.right == null) {
            return tmp == 0 ? true : false;
        }
        return hasPathSum(root.left, tmp) || hasPathSum(root.right, tmp);

    }

    //hasPathSumV2 非递归求二叉树的路径和是否为6
    static boolean hasPathSumV2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                if (sum == cur.val) {
                    return true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                cur.left.val = cur.val + cur.left.val;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                cur.right.val = cur.val + cur.right.val;
            }
        }
        return false;
    }

    //getMaxLongPathSum 求叶子节点到根结点的最长路径和
    static int getMaxLongPathSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                //替换最大值
                if (cur.val > sum) {
                    sum = cur.val;
                }
            }
            //继续遍历，改变后面节点的值，存储的是经过这个节点的链路和的值
            if (cur.left != null) {
                queue.offer(cur.left);
                cur.left.val = cur.val + cur.left.val;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                cur.right.val = cur.val + cur.right.val;
            }
        }
        return sum;
    }

    //getPath 递归求二叉树的最长走的路径，不是和是路径
    public static void getPath(TreeNode root, List<Integer> list, int num) {
        if (root != null) {
            num += root.val;
            list.add(root.val);
        }
        if (root.left == null && root.right == null) {
            System.out.print(num + "=");
            System.out.println(list);
        }
        if (root.left != null)
            getPath(root.left, list, num);
        if (root.right != null)
            getPath(root.right, list, num);
        //这里相当于删除list的尾节点，相当于让list回到叶子节点的跟节点去
        list.remove(list.size() - 1);
    }

    //变量 is_right 标识当前结点是左结点还是右结点，res存储遍历过程中，可能出现的最大深度
    static int find_depth(TreeNode root, boolean is_right, int res) {
        if (root == null) {
            return 0;
        }
        //找出左右子树的交叉深度
        int right_depth = find_depth(root.right, true, res);
        int left_depth = find_depth(root.left, false, res);
        if (is_right) {
            //若当前结点是右结点
            res = Math.max(res, right_depth);//保存当前结点的右子树的最大交叉深度
            return left_depth + 1;//返回父节点的交叉深度，既需要和当前结点的左子树配合
        } else {
            res = Math.max(res, left_depth);
            return right_depth + 1;
        }
    }

    static int longestZigZag(TreeNode root) {
        //处理特殊的情形
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        //左右子树的最大深度
        int res = 0;
        //左右子树的交叉深度
        int left_depth = find_depth(root.left, false, res);
        int right_depth = find_depth(root.right, true, res);
        //返回最大值
        return Math.max(res, Math.max(left_depth, right_depth));
    }
}
