package com.my.java.base.bijiao3;

import java.util.HashMap;
import java.util.Map;

public enum LabelTypeEnum {

    MERCHANT(1, "商家券"),
    MEMBER(2, "联合会员"),
    CLOUD_PACK(3, "云包场"),
    ASSIST_BONUS(4,"助力主创"),
    COUPON_PACKAGE(5, "券包"),
    MEMBER_REWARDS(6, "会员奖励"),
    CULTURAL(7, "文慧券"),
    PARTNER_VOUCHER(8, "其他平台");

    private int value;
    private String desc;

    private static Map<Integer, LabelTypeEnum> varMap = new HashMap<Integer, LabelTypeEnum>();

    static {
        LabelTypeEnum[] enums = LabelTypeEnum.values();
        for (LabelTypeEnum e : enums) {
            varMap.put(e.getValue(), e);
        }
    }

    LabelTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String getLabelTypeDesc(int value) {
        if (varMap.containsKey(value)) {
            return varMap.get(value).getDesc();
        }
        return "";
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
