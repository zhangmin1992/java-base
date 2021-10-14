package com.my.java.suanfa.ListNode;

public class FirstCommonNodeList {
    static class Node {
        int data;
        Node next;

        public Node(Node next, int data) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node five = new Node(null, 5);
        Node four = new Node(five, 4);
        Node three = new Node(four, 3);
        Node two = new Node(three, 2);
        Node one = new Node(two, 1);
//        five.next = two;


        Node three2 = new Node(null, 5);
        Node two2 = new Node(three2, 4);
        Node one2 = new Node(two2, 6);

        Node node1 = one, node2 = one2;
        Node node = findFirstCommonNode(node1, node2);
        System.out.println(node.data);

        System.out.println(getNumbers(node));

//        System.out.println(hasCycle(one));
    }

    /*
     * 单链表相交的结果为成“Y”形
     */
    private static Node findFirstCommonNode(Node node1, Node node2) {
        // 获取链表的长度
        int nLength1 = GetListLength(node1);
        int nLength2 = GetListLength(node2);
        // 应多走的步数
        int extraLength = nLength1 - nLength2;
        Node pNodeLong = node1, pNodeShort = node2;
        if (nLength1 < nLength2) {
            extraLength = nLength2 - nLength1;
            pNodeLong = node2;
            pNodeShort = node1;
        }
        // 长链表先走extraLength步
        while (extraLength > 0) {
            pNodeLong = pNodeLong.next;
            extraLength--;
        }
        Node pNodeCommon = null;
        // 两个链表同时向后走
        while (pNodeLong != null && pNodeShort != null) {
            if (pNodeLong.data == pNodeShort.data) {
                pNodeCommon = pNodeLong;
                break;
            }
            pNodeLong = pNodeLong.next;
            pNodeShort = pNodeShort.next;
        }
        return pNodeCommon;
    }

    /*
     * 获取链表长度
     */
    private static int GetListLength(Node node1) {
        int length = 0;
        while (node1 != null) {
            length++;
            node1 = node1.next;
        }
        return length;
    }

    public static String getNumbers(Node node) {
        if (node == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.data + "->");
            node = node.next;
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    /**
     * 功能描述:判断链表中是否有环 ----- 有关单链表中环的问题
     */
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(slow.data + "---" + fast.data);
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
