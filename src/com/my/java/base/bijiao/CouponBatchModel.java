package com.my.java.base.bijiao;

import java.io.Serializable;

/**
 * Created by zhangpeng on 2018/7/5.
 */
public class CouponBatchModel implements Serializable {

    // 券来源
    private int source;
    // 批次号
    private int batchId;

    public CouponBatchModel(int source, int batchId) {
        this.source = source;
        this.batchId = batchId;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouponBatchModel that = (CouponBatchModel) o;

        if (source != that.source) return false;
        return batchId == that.batchId;

    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + batchId;
        return result;
    }

    @Override
    public String toString() {
        return "CouponBatchModel{" +
                "source=" + source +
                ", batchId=" + batchId +
                '}';
    }
}
