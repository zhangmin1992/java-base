package com.my.java.meituan;

public enum TBillRecordTypeEnum {
    TRADE(0, "交易"),
    REFUND(1, "退款"),
    SHARING(2, "分账"),
    SHARING_CANCEL(3, "分账回退"),
    TRANSFER(4, "售后服务分账"),
    WITHDRAW(5, "提现"),
    WITHDRAW_FAILED(6, "提现失败退款");

    private int type;
    private String desc;

    TBillRecordTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }


    public static TBillRecordTypeEnum fetchByType(int type) {
        for (TBillRecordTypeEnum value : values()) {
            if (value.getType() == type) {
                return value;
            }
        }
        throw new RuntimeException("TBillRecordTypeEnum fetchByType error " + type);
    }

    public static TBillRecordTypeEnum fetchByDesc(String desc) {
        for (TBillRecordTypeEnum value : values()) {
            if (value.getDesc().equals(desc)) {
                return value;
            }
        }
        throw new RuntimeException("TBillRecordTypeEnum fetchByDesc error " + desc);
    }

}
