package com.my.java.base.bijiao;

import java.util.HashMap;
import java.util.Map;

public enum NewCustomerEnum {
    CUSTOME(-2, "自定义"),
    NOT_SPECIFIED(-1, "不指定"),
    NOT_NEW(0, "非新客"),
    SEAT(1, "选座新客"),
    GROUP(2, "团购新客"),
    ALL(3, "纯新客(美团)"),
    DIANPING(4, "点评新客"),
    DIANPING_AND_SEAT(5, "点评和选座新客"),
    DIANPING_AND_GROUP(6, "点评和团购新客"),
    DIANPING_AND_SEAT_AND_GROUP(7, "新美大新客");

    static Map<Integer, NewCustomerEnum> map = new HashMap();
    private final int value;
    private final String desc;

    private NewCustomerEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public static String getDesc(int value) {
        NewCustomerEnum anEnum = (NewCustomerEnum)map.get(value);
        return null == anEnum ? "" : anEnum.getDesc();
    }

    static {
        NewCustomerEnum[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            NewCustomerEnum anEnum = var0[var2];
            map.put(anEnum.getValue(), anEnum);
        }

    }
}
