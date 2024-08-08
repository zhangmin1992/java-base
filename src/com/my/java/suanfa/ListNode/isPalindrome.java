package com.my.java.suanfa.ListNode;

public class isPalindrome {

    static class Node {
        int data;
        Node next;

        public Node(Node next, int data) {
            this.data = data;
            this.next = next;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null) {
            Node temp = slow.next;//3
            if (pre != null) {//1->2>3>4>2>1
                slow.next = pre;//2->1->2>3>4>2>1
            }
            pre = slow;//1 2
            slow = temp;;//2->3>4>2>1 3
            fast = fast.next.next;//3
        }
        if (fast != null) {
            slow = slow.next; // 偶数节点
        }
        //System.out.println(getNumbers(slow)+"--"+getNumbers(pre));
        while (slow != null) {
            if (pre.data != slow.data) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    //1->2->3->4  4->3->2->1
    public static Node fanzhuan(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;//1->null 2->1->null
            pre = cur;//pre =1 pre = 2
            cur = next;//cur =2 cur = 2
        }
        return pre;
    }

    //展示链表
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

    public static void main(String[] args) {
        Node six = new Node(null, 1);
        Node five = new Node(six, 2);
        Node four = new Node(five, 4);
        Node three = new Node(four, 3);
        Node two = new Node(three, 2);
        Node one = new Node(two, 1);

        //System.out.println(getNumbers(fanzhuan(one)));

        System.out.println(isPalindrome(one));

    }
}
