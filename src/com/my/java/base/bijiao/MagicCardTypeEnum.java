package com.my.java.base.bijiao;

import java.util.HashMap;
import java.util.Map;

public enum MagicCardTypeEnum {
    // 1-代金券 2-通兑券
    VOUCHER(1, "代金券"), UEMCARD(2, "通兑券"), VIRTUAL(3, "虚拟礼品"), DISCOUNT(4, "折扣券"), FIXVALUE(5, "定价券");
    private final int value;
    private final String desc;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    private static Map<Integer, MagicCardTypeEnum> varMap = new HashMap<Integer, MagicCardTypeEnum>();

    static {
        MagicCardTypeEnum[] enums = MagicCardTypeEnum.values();
        for (MagicCardTypeEnum e : enums) {
            varMap.put(e.getValue(), e);
        }
    }

    MagicCardTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static boolean isValid(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    public static MagicCardTypeEnum get(int i) {
        switch (i) {
            case 1:
                return VOUCHER;
            case 2:
                return UEMCARD;
            case 3:
                return VIRTUAL;
            case 4:
                return DISCOUNT;
            case 5:
                return FIXVALUE;
        }
        return null;
    }

    public static String getTypeDesc(int value) {
        if (varMap.containsKey(value)) {
            return varMap.get(value).getDesc();
        }
        return "未知";
    }
}
