package com.my.java.base;

import java.math.BigDecimal;

public class TestYunSuanFu {

    public static  boolean test1(yunsuanfu yunsuanfu) {
        System.out.println("test1进入");
        return yunsuanfu.getString() != null;
    }

    public static  boolean test2(yunsuanfu yunsuanfu) {
        System.out.println("test2进入");
        return yunsuanfu.getInteger() != null;
    }

    public static  boolean test3(yunsuanfu yunsuanfu) {
        System.out.println("test3进入");
        return yunsuanfu.getBigDecimal() == null;
    }

    public static  boolean test4(yunsuanfu yunsuanfu) {
        System.out.println("test4进入");
        return yunsuanfu.getString() == null;
    }

    public static  void main(String[] args) {
        yunsuanfu yunsuanfu = new yunsuanfu();
        //if(yunsuanfu.getString() != null && yunsuanfu.getInteger() != null)
        if(test1(yunsuanfu) && test2(yunsuanfu)) {
            System.out.println("不为空");
        }
        //if(yunsuanfu.getBigDecimal() == null && yunsuanfu.getInteger() == null)
        if(test3(yunsuanfu) || test4(yunsuanfu)) {
            System.out.println("都为空");
        }
    }
}

class yunsuanfu {

    private String string;

    private Integer integer;

    private BigDecimal bigDecimal;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
