package com.my.java.base;

import java.util.ArrayList;
import java.util.List;

public class teee {
    public static void main(String args[]) {
        Long h = 0L;
        name name = new name();
        name.setaLong(0L);
        System.out.println(name.getaLong() == h);
        System.out.println(name.getaLong() == 0);
        System.out.println(name.getaLong() == 0L);
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(2L);
        System.out.println(list.contains(0L));
        System.out.println(list.contains(0));


    }
}

class name {
    private  Long aLong;

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }
}
