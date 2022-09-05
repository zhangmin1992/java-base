package com.my.java.suanfa.ListNode;

/**
 * 功能描述:链表翻转。给出一个链表和一个数k，
 * 比如链表1→2→3→4→5→6，k=2，翻转后2→1→4→3→6→5，
 * 若k=3,翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→5→6
 */
public class KListNodeFanZhuan {
    public static void main(String args[]) {
        MyNode eight = new MyNode(null,null,8);
        MyNode seven = new MyNode(null,eight,7);
        MyNode six = new MyNode(null,seven,6);
        MyNode five = new MyNode(null,six,5);
        MyNode four = new MyNode(null,five,4);
        MyNode three = new MyNode(null,four,3);
        MyNode two = new MyNode(null,three,2);
        MyNode one = new MyNode(null,two,1);

//        System.out.println(getNumbers(one));

//        System.out.println(getNumbers(fanzhuan(one)));

        System.out.println(getNumbers(KListNodeFanZhuan(one,3)));
//        System.out.println(getNumbers(KListNodeFanZhuanV2(one,3,8)));


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


    public static MyNode KListNodeFanZhuan(MyNode node,int k) {
        int count = 1;
        //标记返回的head节点，只赋值一次，就是第一次翻转之后的返回值3
        MyNode head = null;
        //表示需要翻转的一段链表的头节点，比如123的1，456的4，刚开始赋值为头节点
        MyNode temp = node;
        //翻转后的一段链表的头节点
        MyNode tempNodeList = null;
        while (node != null) {
            if (count == k) {
                count = 1;
                //临时保存下一个节点
                MyNode nextNode = node.getNext();
                System.out.println( temp.getValue() + "到" + node.getValue() + "的节点将执行翻转");
                //截断123，设置3的下一个为null，否则翻转的时候不对
                node.setNext(null);
                if (tempNodeList == null) {
                    //翻转123变成321，tempNodeList的节点为3
                    tempNodeList = fanzhuan(temp);
                    //此处只次一次赋值，表示返回值
                    head = tempNodeList;
                    System.out.println("---"+getNumbers(tempNodeList));

                    //遍历321，把1的下一个设置为4，这里是为了遍历不完的时候把7->8也带上
                    while (tempNodeList.getNext() != null) {
                        tempNodeList = tempNodeList.getNext();
                    }
                    tempNodeList.setNext(nextNode);
                } else {
                    //重新把1的下一个设置为6->5>4的一段链表
                    tempNodeList.setNext(fanzhuan(temp));
                    System.out.println("---"+getNumbers(tempNodeList));

                    //和上面一样，遍历654，把4的下一个设置为7，这里是为了遍历不完的时候把7->8也带上
                    while (tempNodeList.getNext() != null) {
                        tempNodeList = tempNodeList.getNext();
                    }
                    tempNodeList.setNext(nextNode);
                }
                //temp的值为4
                temp = nextNode;
                node = nextNode;
            } else {
                node = node.getNext();
                count ++;
            }
        }
        return head;
    }

    public static int getLength(MyNode head){
        MyNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.getNext();
        }
        return count;
    }

    public static MyNode KListNodeFanZhuanV2(MyNode node,int k,int n) {
        int count = 1;
        //num表示可以逆转几组，1→2→3→4→5→6-7>8 k=3的时候，可以逆转2组，78不会逆转
        int num = n /k;
        //标记返回的head节点，只赋值一次作为结果返回值，也就是第一次翻转之后的返回值3
        MyNode head = null;
        //表示需要翻转的一段链表的头节点，比如123的1，456的4，刚开始赋值为头节点
        MyNode temp = node;
        //表示上一段翻转链表的尾部节点，比如翻转后的321的1，翻转后654的4
        MyNode preTemp = node;
        //翻转后的一段链表的头节点
        MyNode tempNodeList = null;
        while (node != null) {
            if (count == k) {
                count = 1;
                num --;
                //临时保存下一个节点4，7
                MyNode nextNode = node.getNext();
                System.out.println( temp.getValue() + "到" + node.getValue() + "的节点将执行翻转");
                //截断123，设置3的下一个为null，否则翻转的时候会被全部翻转掉就不对了
                node.setNext(null);

                if (tempNodeList == null) {
                    //翻转123变成321，tempNodeList的节点为翻转后的节点3
                    tempNodeList = fanzhuan(temp);
                    //此处只次一次赋值，表示返回值
                    head = tempNodeList;
                    System.out.println("---"+getNumbers(tempNodeList));
                } else {
                    //重新把1的下一个设置为6->5>4的一段链表,需要找到1这个节点，preTemp存储的值就是上一个翻转后链表的尾元素
                    preTemp.setNext(fanzhuan(temp));
                    System.out.println("---"+getNumbers(preTemp));
                }
                if (num == 0) {
                    //逆转结束了需要把4和7->8相连接
                    temp.setNext(nextNode);
                }
                //preTemp存储翻转后上一段的尾节点1，存储翻转后上一段的尾节点6
                preTemp = temp;
                //设置temp的值为4
                temp = nextNode;
                //这里node继续往下走，但是不能是node = node.getNext();，因为上面设置了node.setNext(null);，需要设置为临时保存的nexrnode节点
                node = nextNode;
            } else {
                node = node.getNext();
                count ++;
            }
        }
        return head;
    }

    //全翻转链表
    public static MyNode fanzhuan(MyNode head) {
        //向下遍历的指针cur
        MyNode cur = head;
        //前一个指针
        MyNode pre = null;
        while (cur != null) {
            MyNode next = cur.getNext();
            //下面这两句话不能反了，必须先设置当前头指针的下一个
            cur.setNext(pre);
            //再设置下一个的pre节点为当前节点
            pre = cur;
            //遍历指针后移
            cur = next;
        }
        return pre;
    }
}
