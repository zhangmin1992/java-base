package com.my.java.base;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiangdongyu
 * Date: 2019-10-24
 * Time: 3:45 下午
 */
public enum SharingJobStatusEnum {
    WAIT(0, "待提交"),
    PROCESSING(1, "处理中"),
    SUCCESS(2, "成功"),
    FAILED(-1, "失败");

    private int status;
    private String desc;

    SharingJobStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static SharingJobStatusEnum fetchByStatus(int status) {
        for (SharingJobStatusEnum value : values()) {
            if (value.getStatus() == status) {
                return value;
            }
        }
        throw new RuntimeException("SharingJobStatusEnum error " + status);
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}

