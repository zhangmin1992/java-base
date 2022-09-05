package com.my.java.suanfa.ListNode;

/**
 * 功能描述:
 * hasCycle 判断链表中是否有环 ----- 有关单链表中环的问题
 * hasCycleWithFindFirstCommonNode 判断是否有环，有的话找到环的起始节点
 * findFirstCommonNode 求两个链表相交的节点,
 *         方法一比较繁琐，需要求每个链表的长度，让长的链表走一下固定步数，一起走，相遇的时候就是相交的节点
 * findFirstCommonNodeV2 求两个链表相交的节点,
 *          方法二比较简单，每个链表都开始走，当链表走完的时候交换到另一个链表的头节点开始走，最后相遇的时候就是相交的节点
 */
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
        Node seven = new Node(null, 8);
        Node six = new Node(seven, 7);
        Node five = new Node(six, 6);
        Node four = new Node(five, 4);
        Node three = new Node(four, 3);
        Node two = new Node(three, 2);
        Node one = new Node(two, 1);

        //加上环，判断是否有环，找出环的首个开始节点的位置的测试部分
        /*seven.next = four;
        System.out.println(hasCycle(one));
        Node node = hasCycleWithFindFirstCommonNode(one);
        System.out.println(node.data);*/


        Node one2 = new Node(four, 5);

        Node node1 = one, node2 = one2;
//        Node node = findFirstCommonNode(node1, node2);
//        System.out.println(node.data);
        Node nodeV2 = findFirstCommonNodeV2(node1, node2);
        System.out.println(nodeV2.data);
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

    private static Node findFirstCommonNodeV2(Node headA, Node headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        Node p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
            String left = p1 == null ? "" : p1.data+"";
            String right = p2 == null ? "" : p2.data+"";
            System.out.println(left + "---" + right);
        }
        return p1;
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
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //求单链表是否有环，有的话返回环的开始节点，链表：1->2>3>4>5>6>7>4
    public static Node hasCycleWithFindFirstCommonNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        //fast为空指针说明没有环，否则快慢指针相遇这里有环，并且快指针行走的步数刚好是环的长度
        if (fast == null || fast.next == null) {
            return null;
        }
        //让slow指针重新指向头节点
        slow = head;
        //快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
