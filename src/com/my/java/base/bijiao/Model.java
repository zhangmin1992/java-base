package com.my.java.base.bijiao;

import java.io.Serializable;

public class Model implements Serializable, Comparable<Model> {

    public Model(int limitNum) {
        this.limitNum = limitNum;
    }

    int limitNum;

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    @Override
    public int compareTo(Model o) {
        return  o.getLimitNum() - this.getLimitNum();
    }
}
