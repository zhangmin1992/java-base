package com.my.java.base.bijiao;
import java.io.Serializable;

/**
 * @Description
 * @Author: zhangyk
 * @Date: 15/12/28
 * @Time: 下午8:39
 */
public class SelectCode implements Serializable{

    private static final long serialVersionUID = 6080014147035256502L;

    // 来源 @CodeSourceEnum
    private int source;
    // 券码
    private String code;
    // 使用的金额
    private int value;
    //
    private int type;
    // 成本类型
    private int costType;
    // 批次id
    private int batchId;
    // 批次名称
    private String batchName;
    // 是否减穿
    private boolean pierceFlag;
    // 减穿情况下，平台成本
    private int piercePlateFormCost;
    // 减穿情况下，商家成本
    private int pierceMerchantCost;
    // 非减穿情况下，平台成本
    private int unPiercePlateFormCost;
    //非减穿情况下，商家成本
    private int unPierceMerchantCost;


    public SelectCode() {

    }

    public SelectCode(int source, String code) {
        this.source = source;
        this.code = code;
    }

    public SelectCode(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public SelectCode(int source, String code, int value) {
        this.source = source;
        this.code = code;
        this.value = value;
    }

    public SelectCode(int source, String code, int value, int type) {
        this.source = source;
        this.code = code;
        this.value = value;
        this.type = type;
    }

    public SelectCode(int source, String code, int value, int type, int costType, int batchId, String batchName) {
        this.source = source;
        this.code = code;
        this.value = value;
        this.type = type;
        this.costType = costType;
        this.batchId = batchId;
        this.batchName = batchName;
    }

    public SelectCode(int source, String code, int value, int type, int costType, int batchId, String batchName, boolean pierceFlag, int piercePlateFormCost, int pierceMerchantCost, int unPiercePlateFormCost, int unPierceMerchantCost) {
        this.source = source;
        this.code = code;
        this.value = value;
        this.type = type;
        this.costType = costType;
        this.batchId = batchId;
        this.batchName = batchName;
        this.pierceFlag = pierceFlag;
        this.piercePlateFormCost = piercePlateFormCost;
        this.pierceMerchantCost = pierceMerchantCost;
        this.unPiercePlateFormCost = unPiercePlateFormCost;
        this.unPierceMerchantCost = unPierceMerchantCost;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public boolean isPierceFlag() {
        return pierceFlag;
    }

    public void setPierceFlag(boolean pierceFlag) {
        this.pierceFlag = pierceFlag;
    }

    public int getPiercePlateFormCost() {
        return piercePlateFormCost;
    }

    public void setPiercePlateFormCost(int piercePlateFormCost) {
        this.piercePlateFormCost = piercePlateFormCost;
    }

    public int getPierceMerchantCost() {
        return pierceMerchantCost;
    }

    public void setPierceMerchantCost(int pierceMerchantCost) {
        this.pierceMerchantCost = pierceMerchantCost;
    }

    public int getUnPiercePlateFormCost() {
        return unPiercePlateFormCost;
    }

    public void setUnPiercePlateFormCost(int unPiercePlateFormCost) {
        this.unPiercePlateFormCost = unPiercePlateFormCost;
    }

    public int getUnPierceMerchantCost() {
        return unPierceMerchantCost;
    }

    public void setUnPierceMerchantCost(int unPierceMerchantCost) {
        this.unPierceMerchantCost = unPierceMerchantCost;
    }

    @Override
    public String toString() {
        return "SelectCode{" +
                "source=" + source +
                ", code='" + code + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", costType=" + costType +
                ", batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", pierceFlag=" + pierceFlag +
                ", piercePlateFormCost=" + piercePlateFormCost +
                ", pierceMerchantCost=" + pierceMerchantCost +
                ", unPiercePlateFormCost=" + unPiercePlateFormCost +
                ", unPierceMerchantCost=" + unPierceMerchantCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectCode that = (SelectCode) o;

        if (source != that.source) return false;
        return !(code != null ? !code.equals(that.code) : that.code != null);

    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + type;
        return result;
    }
}

