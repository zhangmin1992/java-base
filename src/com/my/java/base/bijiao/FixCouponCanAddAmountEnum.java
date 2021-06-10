package com.my.java.base.bijiao;

import java.util.Arrays;

/**
 * @author jiaoyefei
 * @version 1.0
 * @description: 定价券是否可以补差价
 * @date 2021/3/31 5:47 下午
 */
public enum FixCouponCanAddAmountEnum {

    NOT_ADD(0,"不可以补差价"),
    CAN_ADD(1,"可以补差价"),
    ;

    private int code;
    private String message;

    FixCouponCanAddAmountEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static FixCouponCanAddAmountEnum getByCode(int code){
        return Arrays.stream(FixCouponCanAddAmountEnum.values()).filter(e -> e.getCode() == code).findFirst().orElse(null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
