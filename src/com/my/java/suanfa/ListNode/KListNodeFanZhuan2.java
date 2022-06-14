package com.my.java.suanfa.ListNode;

import com.alibaba.fastjson.JSONObject;

public class KListNodeFanZhuan2 {

    public static void main(String[] args) {
        Node eight = new Node(null,8);
        Node seven = new Node(eight,7);
        Node six = new Node(seven,6);
        Node five = new Node(six,5);
        Node four = new Node(five,4);
        Node three = new Node(four,3);
        Node two = new Node(three,2);
        Node one = new Node(two,1);


        System.out.println(JSONObject.toJSONString(Node.getNumbers(Kfanzhuan(one,3))));
    }

    public static Node Kfanzhuan(Node head,int k) {
        //之前是否翻转过
        boolean isFanZhuan = false;
        //返回第一次翻转后的头节点，一次赋值后就返回
        Node newHead = null;
        Node cur = head;
        //临时指针，表示123的1，456的4，第一次是头节点，后面是count次数够了之后的next节点
        Node temp = head;
        //表示上一次翻转之后的321的1，654的4
        Node pre = null;
        int count = 1;

        while (cur != null) {
            if (count == k) {
                Node next = cur.getNext();
                count = 1;
                cur.setNext(null);
                Node newNode = fanzhuan(temp);
                if (!isFanZhuan) {
                    //返回第一次翻转后的头节点，一次赋值后就返回
                    newHead = newNode;
                    //设置为翻转过
                    isFanZhuan = true;
                } else {
                    //因为之前翻转过，所以pre不会为空，并且pre表示的是上一次翻转321之后的1，把1的下一个设置为654的6
                    pre.setNext(newNode);
                }

                //给pre记录1,给pre记录4
                while (newNode.getNext() != null) {
                    newNode = newNode.getNext();
                }
                pre = newNode;

                //遍历654，把4的下一个设置为7，这里是为了遍历不完的时候把7->8也带上
                pre.setNext(next);

                //这里并不是表示cur指针向后移动，因为cur为3，结构为321，所以重新设置cur为下一个节点4
                cur = next;
                temp = next;
            } else {
                //指针向后移动，次数++
                Node next = cur.getNext();
                count++;
                cur = next;
            }
        }
        return newHead;
    }

    public static Node fanzhuan(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class Node {
    private Node next;

    private int value;

    //展示链表
    public static String getNumbers(Node node) {
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

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
