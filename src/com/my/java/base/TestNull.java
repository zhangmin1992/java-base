package com.my.java.base;

public class TestNull {

    public static void main(String[] args) {
        tete tete = new tete();
        if (1 == tete.getType().intValue()) {
            System.out.println("ok");
        }
        if (Integer.valueOf("1").equals(tete.getType())) {
            System.out.println("ok");
        }
    }
}
class tete {
    private Integer type;

    private Integer cc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }
}
