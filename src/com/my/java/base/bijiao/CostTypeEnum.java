package com.my.java.base.bijiao;

public enum CostTypeEnum {

    PLATFORM(1, "平台券"), MERCHANT(2, "商家券"),BOTH_SHARE(3,"成本分摊");

    private int value;
    private String desc;

    CostTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

