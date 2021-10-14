package com.my.java.suanfa.ListNode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

public class TreeLuJingHe {

    public static void main(String args[]) {
        MyListNode head = new MyListNode(4);
        head.left = new MyListNode(1);
        head.right = new MyListNode(4);
        head.left.right = new MyListNode(2);
        head.left.right.right = new MyListNode(3);
        head.right.left = new MyListNode(2);

        //递归获取树的叶子节点
        ArrayList<Integer> result = new ArrayList<>();
        getTreeYeZiJieDian(head,result);
        System.out.println(result);

        //递归获取树从跟节点到叶子节点的路径和为某个值的所有路径
        ArrayList<ArrayList<Integer>> heResult = FindPath(head,10);
        for(ArrayList<Integer> temp : heResult) {
            System.out.println(JSONObject.toJSONString(temp));
        }

        //方式二：递归获取树从跟节点到叶子节点的路径和为某个值的所有路径
        ArrayList<ArrayList<Integer>> heResult2 = FindPathV2(head,10);
        for(ArrayList<Integer> temp : heResult2) {
            System.out.println(JSONObject.toJSONString(temp));
        }
    }

    //递归找所有叶子节点，可用于求和
    public static ArrayList<Integer> getTreeYeZiJieDian(MyListNode root, ArrayList<Integer> result) {
        if (root == null) {
            return result;
        }
        //这里是叶子节点
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        if (root.left != null) {
            getTreeYeZiJieDian(root.left,result);
        }
        if (root.right != null) {
            getTreeYeZiJieDian(root.right,result);
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<ArrayList<Integer>> FindPath(MyListNode root, int target) {
        if(root == null) {
            return listAll;
        }
        list.add(root.val);
        //target变量表示期待后面路径的和是多少，比如第一个节点是4，期待后面路径和是10-4
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null) {
            //这里省略了一个变量，栈，list和stack，相当于下面这一段代码，直接listAll.add(list)了
            /**
             * 功能描述:         ArrayList<Integer> list = new ArrayList<Integer>();
             *                 for(int i:stack){
             *                     list.add(new Integer(i));
             *                 }
             *                 list.add(new Integer(root.val));
             *                 listAll.add(list);
             */
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //这里相当于弹出stack元素，每次都是左边的元素，右边的元素，最后弹出stack中的元素
        list.remove(list.size()-1);
        return listAll;
    }

    public static ArrayList<ArrayList<Integer>> FindPathV2(MyListNode root, int target) {
        if (root == null) {
            return listAll;
        }
        Stack<Integer> stack = new Stack<Integer>();
        FindPathV2(root,target,stack,listAll);
        return listAll;
    }

    public static void FindPathV2(MyListNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> listAll) {
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            if(root.val == target){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i:stack){
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                listAll.add(list);
            }
        }
        else{
            stack.push(new Integer(root.val));
            FindPathV2(root.left, target-root.val, stack, listAll);
            FindPathV2(root.right, target-root.val, stack,  listAll);
            stack.pop();
        }
    }
}
