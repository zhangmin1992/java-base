package com.my.java.suanfa.ListNode;

/**
 * 功能描述: 链表对折
 * 比如1->2->3->4->5->6->7 对折后为:1->7->2->6->3->5->4
 * 1->2->3->4->5->6->7->8  对折后为:1->8->2->7->3->6->4->5
 *
 * 解题思路是找到链表的中节点，4，
 * 然后1->2->3->4当作一个新链表
 * 5->6->7 完全反转7->6>5 作为一个新链表
 * 然后着两个链表合并后为：1->7->2->6->3->5->4
 */
public class duizhe {
    public static void main(String args[]) {
        MyNode eight = new MyNode(null,null,8);
        MyNode seven = new MyNode(null,eight,7);
        MyNode six = new MyNode(null,seven,6);
        MyNode five = new MyNode(null,six,5);
        MyNode four = new MyNode(null,five,4);
        MyNode three = new MyNode(null,four,3);
        MyNode two = new MyNode(null,three,2);
        MyNode one = new MyNode(null,two,1);

        System.out.println(getNumbers(one));

//        System.out.println(getNumbers(merageListNode(one,six)));

        int size = getListNodeSize(one);
        System.out.println(size);

        MyNode newListNode = duizheListNode(one,4);
        System.out.println(getNumbers(newListNode));
    }

    //展示链表
    public static String getNumbers(MyNode node) {
        if (node == null) {
            return  "";
        }
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.getValue()+"->");
            node = node.getNext();
        }
        return sb.toString().substring(0,sb.length()-2);
    }

    //获取链表长度
    public static int getListNodeSize(MyNode node) {
        int count = 0;
        while (node != null) {
            node = node.getNext();
            count ++;
        }
        return count;
    }

    //对折链表，参数K是中间的那个节点位置
    public static MyNode duizheListNode(MyNode node, int k) {
        int count = 0;
        //记录前一个节点
        MyNode tempPre = null;
        MyNode head = node;
        while (node != null) {
            if (count == k) {
                break;
            }
            tempPre = node;
            node = node.getNext();
            count ++;
        }
        tempPre.setNext(null);
        System.out.println(getNumbers(head));

        //K之后的链表全部反转，得到的元素头节点为pre
        System.out.println(node.getValue());
        MyNode pre = null;
        MyNode next = null;
        while (node != null) {
            next = node.getNext();
            node.setNext(pre);
            pre = node;
            node = next;
        }
        System.out.println(getNumbers(pre));

        //两个链表合并
        return merageListNode(head,pre);
    }

    //链表合并
    public static MyNode merageListNode(MyNode node,MyNode newNode) {
        MyNode head = node;
        while (node != null && newNode != null) {
            //把需要递增的链表节点保存下来
            MyNode next = node.getNext();
            MyNode newNodeNext = newNode.getNext();

            //设置链表的前后关系,为了适应长短不一的链表，当链表遍历完的时候这里不设置next
            if (newNode != null) {
                //1->8 链接起来
                node.setNext(newNode);
            }
            System.out.println("--" + getNumbers(node));
            if (next != null) {
                //8->2 链接起来
                newNode.setNext(next);
            }
            System.out.println("---" + getNumbers(node));

            //这里让两个链表都递增
            node = next;
            newNode = newNodeNext;
        }
        return head;
    }
}
