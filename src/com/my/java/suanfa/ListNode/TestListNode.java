package com.my.java.suanfa.ListNode;

import java.util.*;

/**
 * 功能描述:
 * 二叉树的插入
 * 二叉树的递归遍历方式-先序 中序 后序
 * 二叉树的非递归方式-先序 中序 后序
 * 二叉树的层次遍历
 * 二叉树的垂直遍历
 * 二叉树的深度
 *
 */
public class TestListNode {
    public static void main(String[] args) {
        //二叉树的插入
//        MyListNode head = new MyListNode(4);
//        insert(head,1);
//        insert(head,6);
//        insert(head,2);
//        insert(head,3);
//        insert(head,8);
//        insert(head,5);

        MyListNode head = new MyListNode(4);
        head.left = new MyListNode(1);
        head.left.right = new MyListNode(7);
        head.right = new MyListNode(4);
        head.left.left = new MyListNode(5);
        head.left.left.right = new MyListNode(2);
        head.left.left.right.left = new MyListNode(3);
        head.right.left = new MyListNode(2);

        //递归先序
        ArrayList<Integer> result = new ArrayList();
        preorderTraversal(head,result);
        System.out.println(result);

        //递归中序
        result = new ArrayList();
        inorderTraversal(head,result);
        System.out.println(result);

        //递归后序
        result = new ArrayList();
        postorderTraversal(head,result);
        System.out.println(result);

        //非递归先序
        result = new ArrayList();
        System.out.println(preorderTraversal(head));

        //非递归中序
        result = new ArrayList();
        System.out.println(inorderTraversal(head));

        //非递归后序
        result = new ArrayList();
        System.out.println(postorderTraversal(head));

        //层次遍历
        result = new ArrayList();
        System.out.println(cengciTraversal(head));

        //垂直遍历
        Map<Integer,List<MyListNode>> resultMap = chuizhiTraversal(head);
        Iterator iterator = resultMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,List<MyListNode>> entry =(Map.Entry<Integer,List<MyListNode>>)iterator.next();
            System.out.println(entry.getKey()+"---");
            for(MyListNode temp : entry.getValue()) {
                System.out.println(temp.val);
            }
        }

        //递归求二叉树深度
        System.out.println(depeth(head));
        //利用层次遍历非递归求二叉树深度
        System.out.println(depethv2(head));
    }

    //二叉树的插入
    public static void insert(MyListNode root,int value) {
        if (root == null) {
            return;
        } else {
            MyListNode newNode = new MyListNode(value);
            MyListNode currentNode = root;
            MyListNode parentNode;
            // 有孩子继续循环，一直循环到最后一个节点 和插入的节点比较 大的放到右节点，小于放到左节点
            while (currentNode != null) {
                parentNode = currentNode;
                // 往右放
                if (newNode.val > currentNode.val) {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parentNode.right =  newNode;
                    }
                } else {
                    // 往左放
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parentNode.left =  newNode;
                    }
                }
            }
        }
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
            postorderTraversal(root.left,ret);
        }
        if(root.right != null){
            postorderTraversal(root.right,ret);
        }
        int rootvalue = root.val;
        ret.add(rootvalue);
    }

    //非递归先序排序
    public static ArrayList<Integer> preorderTraversal(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<MyListNode> stack = new Stack<>();
        MyListNode p =  root;
        while (p != null || !stack.empty() ) {
            while (p != null) {
                //入栈2，入栈1
                stack.push(p);
                result.add(p.val);
                p = p.left;
            }
            //左边的节点遍历结束了，弹出栈中的一个元素，直到弹完
            MyListNode pop = stack.pop();
            //弹完元素之后准备遍历右边的元素
            p = pop.right;
        }
        return  result;
    }

    //非递归中序遍历
    public static  ArrayList<Integer> inorderTraversal(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        MyListNode p = root;
        Stack<MyListNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            MyListNode pop = stack.pop();
            result.add(pop.val);
            p = pop.right;
        }
        return result;
    }

    //非递归后序遍历
    public static ArrayList<Integer> postorderTraversal(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        MyListNode p = root;
        Stack<MyListNode> stack = new Stack<>();
        //listNode，记录的是访问过的有右节点的跟节点，最后弹光
        ArrayList<MyListNode> listNode = new ArrayList<>();
        while (p != null || stack.size() >0) {
            //先找最左节点们，入stack
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (stack.size() >0) {
                MyListNode peak = stack.peek();
                //最左边结点有右节点的时候
                if (peak.right != null) {
                    boolean contain = listNode.contains(peak);
                    if (contain) {
                        MyListNode pop = stack.pop();
                        result.add(pop.val);
                    } else {
                        listNode.add(peak);
                        p = peak.right;
                    }
                } else {
                    //最左边结点没有右节点的时候，直接弹出最左边节点，加入result列表
                    MyListNode pop = stack.pop();
                    result.add(pop.val);
                }
            }
        }
        return result;
    }

    //非递归层次遍历
    public static ArrayList<Integer> cengciTraversal(MyListNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //这里不能再用stack，因为stack是先进后出，需要用队列先进先出
        Queue<MyListNode> stack = new LinkedList<MyListNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            MyListNode pop = stack.poll();
            result.add(pop.val);
            if (pop.left != null) {
                stack.offer(pop.left);
            }
            if (pop.right != null) {
                stack.offer(pop.right);
            }
        }
        return result;
    }

    //垂直遍历二叉树，返回各个等级的列表
    public static Map<Integer,List<MyListNode>> chuizhiTraversal(MyListNode root) {
        if (root == null) {
            return null;
        }
        //result 按照等级纬度，存储各个等级下的元素节点，跟节点初始化为0
        HashMap<Integer,List<MyListNode>> result = new HashMap<>();
        List<MyListNode> list = new ArrayList<>();
        list.add(root);
        result.put(0,list);

        //queue采用层次遍历，先进先出
        Queue<MyListNode> queue = new LinkedList<>();
        queue.offer(root);

        //nodeMap存储各个节点是第几等级，跟节点是0等级
        HashMap<MyListNode,Integer> nodeMap = new HashMap<>();
        nodeMap.put(root,0);

        while (!queue.isEmpty()) {
            MyListNode node = queue.poll();
            int index = nodeMap.get(node);
            if (node.left != null) {
                //入栈，先进的会先出
                queue.offer(node.left);
                //左边节点的等级-1，此处index的值不能变
                nodeMap.put(node.left,index-1);
                //找到返回结果中这个等级的元素们，插入进去
                List<MyListNode> leafList = result.get(index-1);
                if (leafList == null) {
                    leafList = new ArrayList<>();
                    leafList.add(node.left);
                    result.put(index-1,leafList);
                } else {
                    leafList.add(node.left);
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                //右边节点的等级+1，此处index的值不能变
                nodeMap.put(node.right,index+1);
                List<MyListNode> leafList = result.get(index+1);
                if (leafList == null) {
                    leafList = new ArrayList<>();
                    leafList.add(node.right);
                    result.put(index+1,leafList);
                } else {
                    leafList.add(node.right);
                }
            }
        }
        return result;
    }

    //递归求二叉树深度
    public static int depeth(MyListNode root) {
        if (root == null) {
            return 0;
        }
        int left = depeth(root.left);
        int right = depeth(root.right);
        return left>right?left+1:right+1;
    }

    //利用层次遍历非递归求二叉树深度
    public static int depethv2(MyListNode root) {
        if (root == null) {
            return 0;
        }
        Queue<MyListNode> queue = new LinkedList<MyListNode>();
        queue.offer(root);
        int depth = 0;
        int count = 0;
        int nextCount = 1;
        while (!queue.isEmpty()) {
            MyListNode pop = ((LinkedList<MyListNode>) queue).pop();
            count ++;
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
            //已经弹出来的数量 == 下一个等级的节点数量，说明当前层次遍历完了
            if (count == nextCount) {
                count = 0;
                nextCount = queue.size();
                depth++;
            }
        }
        return depth;
    }
}


