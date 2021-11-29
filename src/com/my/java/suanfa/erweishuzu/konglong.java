package com.my.java.suanfa.erweishuzu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class konglong {
    public static void main(String args[]) {
        List<Item> list = new ArrayList<>();
//        list.add(new Item(1990,1995));
        list.add(new Item(1997, 1998));
        list.add(new Item(1990, 1993));
        list.add(new Item(1994, 1996));
        list.add(new Item(1990, 1995));
        System.out.println(getKonglongCount(list));
    }

    static int getKonglongCount(List<Item> list) {
        int max = 0;
        HashMap<Item, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 1; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                Item temp = list.get(j);
                //temp的值完全在list内：3-5 完全包含在2-8
                if (temp.getStart() >= list.get(i).getStart() && temp.getEnd() <= list.get(i).getEnd()) {
                    count++;
                }
                //0-3 0-1是否 跨越了2-8
                else if (temp.getStart() <= list.get(i).getStart() && temp.getEnd() >= list.get(i).getStart()) {
                    count++;
                }
                //5-9 11-19 跨越了2-8
                else if (temp.getStart() >= list.get(i).getStart() && temp.getStart() <= list.get(i).getEnd()) {
                    count++;
                }
            }
            max = count > max ? count : max;
        }
        return max;
    }
}

class Item {
    private int start;
    private int end;

    public Item(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
