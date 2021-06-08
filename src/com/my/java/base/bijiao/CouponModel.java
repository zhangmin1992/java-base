package com.my.java.base.bijiao;


import com.meituan.mobile.movie.common.money.Money;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 优惠券码Model, 描述一张优惠券最原始的属性
 * @Author: zhangyk
 * @Date: 15/11/6
 * @Time: 下午6:10
 */
public class CouponModel implements Serializable, Comparable<CouponModel> {

    private static final long serialVersionUID = 1437035815889397018L;

    // 券码
    private String code;
    // 券的面值
    private float value;
    // 批次号
    private int batchNo;
    // 券的标题
    private String title;
    // 过期限制描述
    private String leftDesc;
    // 使用限制描述
    private String limitDesc;
    // 券类型: 1为代金券，2为通兑券，4为折扣券，5为定价券
    /**
     *
     **/
    private int cardType;
    // 通兑券类型
//    private String subCardType;
    private SubCardTypeEnum subCardType;
    // 最低使用金额
    private float minMoney;
    // 限制平台
    // 1网页版(web) 2移动版(m) 4触屏版(i) 8客户端(app)
    // 可使用平台的叠加，如platform=5代表支持可在网页版和触屏版使用
    private int platform;
    // 业务限制
    private int business;
    // 是否与优惠活动共用
    private boolean activityUseful;
    // 不与活动共用时的提示文案
    private String activityConflictText;
    // 添加时间
    private Date addTime;
    // 券生效时间
    private Date beginTime;
    // 结束时间
    private Date endTime;
    // 使用时间
    private Date useTime;
    // 状态 0 未使用 ，128 已经使用，144 已经删除
    private int status;
    // 使用规则限制
    private CouponLimitModel couponLimitModel;
    // 用户id
    private long userId;
    // 对应的优惠券活动id
    private int activeId;
    // 主站返回的codeType
    private int codeType;
    // 来源 0 主站代金券 4猫眼代金券
    private int source;
    // 可用产品
    private Set<Integer> productTypes;
    // 成本类型（一级成本类型，1-平台，2-商家）
    private int costType;
    // 创建人
    private String createUser;
    // 是否特殊限制：不可与其他券共用
    private boolean specialUseLimit = false;
    // 优惠券名称
    private String name;

    public CouponModel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeftDesc() {
        return leftDesc;
    }

    public void setLeftDesc(String leftDesc) {
        this.leftDesc = leftDesc;
    }

    public String getLimitDesc() {
        return limitDesc;
    }

    public void setLimitDesc(String limitDesc) {
        this.limitDesc = limitDesc;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public SubCardTypeEnum getSubCardType() {
        return subCardType;
    }

    public String getSubCardTypeDesc() {
        return subCardType == null ? "" : subCardType.getDesc();
    }

    public void setSubCardType(SubCardTypeEnum subCardType) {
        this.subCardType = subCardType;
    }

    public float getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(float minMoney) {
        this.minMoney = minMoney;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public boolean isActivityUseful() {
        return activityUseful;
    }

    public void setActivityUseful(boolean activityUseful) {
        this.activityUseful = activityUseful;
    }

    public String getActivityConflictText() {
        return activityConflictText;
    }

    public void setActivityConflictText(String activityConflictText) {
        this.activityConflictText = activityConflictText;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getActiveId() {
        return activeId;
    }

    public void setActiveId(int activeId) {
        this.activeId = activeId;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public CouponLimitModel getCouponLimitModel() {
        return couponLimitModel;
    }

    public void setCouponLimitModel(CouponLimitModel couponLimitModel) {
        this.couponLimitModel = couponLimitModel;
    }

    public boolean newUserLimit() {
        return couponLimitModel.getUserType() != NewCustomerEnum.NOT_NEW.getValue();
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Set<Integer> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Set<Integer> productTypes) {
        this.productTypes = productTypes;
    }

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public boolean canUse() {
        return status == 0;
    }

    public boolean used() {
        return this.getStatus() == 128;
    }

    public boolean canNotUse() {
        return !canUse();
    }

    public CouponBatchModel getCouponBatch() {
        return new CouponBatchModel(source, batchNo);
    }

    public boolean isSpecialUseLimit() {
        return specialUseLimit;
    }

    public void setSpecialUseLimit(boolean specialUseLimit) {
        this.specialUseLimit = specialUseLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(CouponModel o) {
        // 未使用的排序靠前
        if (status != o.getStatus()) {
            return status - o.getStatus();
        }
        // 通兑券排序靠前
        if (cardType != o.getCardType()) {
            if (this.cardType == MagicCardTypeEnum.UEMCARD.getValue()) {
                return -1;
            } else if (o.getCardType() == MagicCardTypeEnum.UEMCARD.getValue()) {
                return 1;
            } else if (this.getCardType() == MagicCardTypeEnum.FIXVALUE.getValue()) {
                return -1;
            } else if (o.getCardType() == MagicCardTypeEnum.FIXVALUE.getValue()) {
                return 1;
            } else {
                if (this.cardType == MagicCardTypeEnum.DISCOUNT.getValue()) {
                    return -1;
                } else if (o.getCardType() == MagicCardTypeEnum.DISCOUNT.getValue()) {
                    return 1;
                }
            }
        }
        // 券值大的排序靠前
        if (this.cardType == MagicCardTypeEnum.VOUCHER.getValue()) {
            if (!Money.create(o.getValue()).equals(Money.create(this.getValue()))) {
                return Money.create(o.getValue()).compareTo(Money.create(this.getValue()));
            }
        } else if (this.cardType == MagicCardTypeEnum.DISCOUNT.getValue()) {
            if (!Money.create(o.getValue()).equals(Money.create(this.getValue()))) {
                return Money.create(this.getValue()).compareTo(Money.create(o.getValue()));
            }
        }
        if (this.cardType == MagicCardTypeEnum.FIXVALUE.getValue()) {
            //先不可补差价，后可补差价排序
            if (Objects.nonNull(this.getCouponLimitModel()) && Objects.nonNull(o.getCouponLimitModel())) {
                if (this.getCouponLimitModel().getFixCouponCanAddAmount() != o.getCouponLimitModel().getFixCouponCanAddAmount()) {
                    return this.getCouponLimitModel().getFixCouponCanAddAmount() - o.getCouponLimitModel().getFixCouponCanAddAmount();
                }
            }
            // 定价券按定价金额从小到大排序
            if (!Money.create(o.getValue()).equals(Money.create(this.getValue()))) {
                return Money.create(this.getValue()).compareTo(Money.create(o.getValue()));
            }
        }
        if (null != couponLimitModel && null != o.getCouponLimitModel()) {
            if (couponLimitModel.getPriceLimit() != o.getCouponLimitModel().getPriceLimit()) {
                if (cardType == MagicCardTypeEnum.UEMCARD.getValue()) {
                    // 同为通兑券
                    return couponLimitModel.getPriceLimit() - o.getCouponLimitModel().getPriceLimit();
                } else if (cardType == MagicCardTypeEnum.VOUCHER.getValue()) {
                    // 同为代金券
                    return o.getCouponLimitModel().getPriceLimit() - couponLimitModel.getPriceLimit();
                } else if (cardType == MagicCardTypeEnum.DISCOUNT.getValue() || cardType == MagicCardTypeEnum.FIXVALUE.getValue()) {
                    // 同为折扣券

                    //可以补差价定价券
                    if(cardType == MagicCardTypeEnum.FIXVALUE.getValue()
                            && FixCouponCanAddAmountEnum.CAN_ADD.getCode() == this.getCouponLimitModel().getFixCouponCanAddAmount()
                            && FixCouponCanAddAmountEnum.CAN_ADD.getCode() == o.getCouponLimitModel().getFixCouponCanAddAmount()){
                        return o.getCouponLimitModel().getPriceLimit() - couponLimitModel.getPriceLimit();
                    }

                    if (couponLimitModel.getPriceLimitLow() == o.getCouponLimitModel().getPriceLimitLow()
                            && couponLimitModel.getPriceLimit() != o.getCouponLimitModel().getPriceLimit()) {
                        // 下限相同，上限不同
                        return couponLimitModel.getPriceLimit() - o.getCouponLimitModel().getPriceLimit();
                    } else if (couponLimitModel.getPriceLimitLow() != o.getCouponLimitModel().getPriceLimitLow()
                            && couponLimitModel.getPriceLimit() != o.getCouponLimitModel().getPriceLimit()) {
                        // 下限不同，上限不同
                        return couponLimitModel.getPriceLimit() - o.getCouponLimitModel().getPriceLimit();
                    }
                }
            } else {
                if ((cardType == MagicCardTypeEnum.DISCOUNT.getValue() || cardType == MagicCardTypeEnum.FIXVALUE.getValue())
                        && couponLimitModel.getPriceLimitLow() != o.getCouponLimitModel().getPriceLimitLow()) {
                    // 下限不同，上限相同
                    return o.getCouponLimitModel().getPriceLimitLow() - couponLimitModel.getPriceLimitLow();
                }
            }
        }
        //截止时间比较
        if(o.getEndTime() != null || endTime != null) {
            if (null == endTime) {
                return -1;
            }
            if (null == o.getEndTime()) {
                return 1;
            }
            if (!endTime.equals(o.getEndTime())) {
                return endTime.compareTo(o.getEndTime());
            }
        }
        // 商家券排序靠前
        if (costType != o.getCostType()) {
            if(costType == CostTypeEnum.MERCHANT.getValue()) {
                return -1;
            }
            else if(costType == CostTypeEnum.PLATFORM.getValue()) {
                return 1;
            }else {
                if(o.getCostType() == CostTypeEnum.PLATFORM.getValue()) {
                    return -1;
                }
                if(o.getCostType() == CostTypeEnum.MERCHANT.getValue()) {
                    return 1;
                }
            }
        }
        return o.getSource() - source;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponModel that = (CouponModel) o;
        return Float.compare(that.value, value) == 0 &&
                batchNo == that.batchNo &&
                cardType == that.cardType &&
                Float.compare(that.minMoney, minMoney) == 0 &&
                platform == that.platform &&
                business == that.business &&
                activityUseful == that.activityUseful &&
                status == that.status &&
                userId == that.userId &&
                activeId == that.activeId &&
                codeType == that.codeType &&
                source == that.source &&
                costType == that.costType &&
                Objects.equals(code, that.code) &&
                Objects.equals(title, that.title) &&
                Objects.equals(leftDesc, that.leftDesc) &&
                Objects.equals(limitDesc, that.limitDesc) &&
                subCardType == that.subCardType &&
                Objects.equals(activityConflictText, that.activityConflictText) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(useTime, that.useTime) &&
                Objects.equals(couponLimitModel, that.couponLimitModel) &&
                Objects.equals(productTypes, that.productTypes) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(specialUseLimit, that.specialUseLimit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, value, batchNo, title, leftDesc, limitDesc, cardType, subCardType, minMoney, platform, business, activityUseful, activityConflictText, addTime, beginTime, endTime, useTime, status, couponLimitModel, userId, activeId, codeType, source, productTypes, costType, createUser, specialUseLimit);
    }

    @Override
    public String toString() {
        return "CouponModel{" +
                "code='" + code + '\'' +
                ", value=" + value +
                ", batchNo=" + batchNo +
                ", title='" + title + '\'' +
                ", leftDesc='" + leftDesc + '\'' +
                ", limitDesc='" + limitDesc + '\'' +
                ", cardType=" + cardType +
                ", subCardType=" + subCardType +
                ", minMoney=" + minMoney +
                ", platform=" + platform +
                ", business=" + business +
                ", activityUseful=" + activityUseful +
                ", activityConflictText='" + activityConflictText + '\'' +
                ", addTime=" + addTime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", useTime=" + useTime +
                ", status=" + status +
                ", couponLimitModel=" + couponLimitModel +
                ", userId=" + userId +
                ", activeId=" + activeId +
                ", codeType=" + codeType +
                ", source=" + source +
                ", productTypes=" + productTypes +
                ", costType=" + costType +
                ", createUser='" + createUser + '\'' +
                ", specialUseLimit=" + specialUseLimit +
                '}';
    }
}
