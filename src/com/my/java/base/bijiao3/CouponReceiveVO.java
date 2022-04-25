package com.my.java.base.bijiao3;

import com.my.java.base.bijiao.MagicCardTypeEnum;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class CouponReceiveVO implements Serializable, Comparable<CouponReceiveVO> {

    //券标签
    private int labelType;

    //券类型
    private int cardType;

    //业务类型
    private int bizType;

    //展示行数
    private int showType;

    //到期/到账
    private int type;

    //图片
    private String imageUrl;

    //详情页跳转地址
    private String jumpUrl;

    //主语
    private String body;

    //金额
    private String value;

    //已到账/已过期描述
    private String describe;

    // 结束时间
    private Date endTime;

    //领取时间
    private Date addTime;

    //券优惠金额
    private Integer couponValue;

    //是否是兑换券
    private Integer generateMethod;

    public Integer getGenerateMethod() {
        return generateMethod;
    }

    public void setGenerateMethod(Integer generateMethod) {
        this.generateMethod = generateMethod;
    }

    public Integer getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Integer couponValue) {
        this.couponValue = couponValue;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getLabelType() {
        return labelType;
    }

    public void setLabelType(int labelType) {
        this.labelType = labelType;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    @Override
    public int compareTo(CouponReceiveVO o) {
        return COMPARATOR.compare(this, o);
    }

    public static Comparator<CouponReceiveVO> COMPARATOR = (o1, o2) -> {
        //券标签排序：云包场→优惠券券码兑换→联合会员→券包→会员奖励  优先级依次降低排序，优先推荐优先级高的劵
        if (o1.labelType != o2.getLabelType()) {
            if (o1.labelType == LabelTypeEnum.ASSIST_BONUS.getValue()) {
                return -1;
            } else if (o2.getLabelType() == LabelTypeEnum.ASSIST_BONUS.getValue()) {
                return 1;
            } else if (o1.getLabelType() == LabelTypeEnum.CULTURAL.getValue()) {
                return -1;
            } else if (o2.getLabelType() == LabelTypeEnum.CULTURAL.getValue()) {
                return 1;
            } else if (o1.getLabelType() == LabelTypeEnum.CLOUD_PACK.getValue()) {
                return -1;
            } else if (o2.getLabelType() == LabelTypeEnum.CLOUD_PACK.getValue()) {
                return 1;
            } else if (o1.getGenerateMethod() != o2.getGenerateMethod()) {
                if (o1.getGenerateMethod() == 2) {
                    return -1;
                }
                if (o2.getGenerateMethod() == 2) {
                    return 1;
                }
            } else if (o1.getLabelType() == LabelTypeEnum.MEMBER.getValue()) {
                return -1;
            } else if (o2.getLabelType() == LabelTypeEnum.MEMBER.getValue()) {
                return 1;
            } else if (o1.getLabelType() == LabelTypeEnum.COUPON_PACKAGE.getValue()) {
                return -1;
            } else if (o2.getCardType() == LabelTypeEnum.COUPON_PACKAGE.getValue()) {
                return 1;
            } else {
                if (o1.getLabelType() == LabelTypeEnum.MEMBER_REWARDS.getValue()) {
                    return 1;
                } else if (o2.getLabelType() == LabelTypeEnum.MEMBER_REWARDS.getValue()) {
                    return -1;
                }
            }
        }

        //券领取时间
        if (o1.getAddTime() != null || o2.getAddTime() != null) {
            if (!o1.getAddTime().equals(o2.getAddTime())) {
                return o2.addTime.compareTo(o1.getAddTime());
            }
        }

        //截止时间比较
        if (o2.getEndTime() != null || o1.endTime != null) {
            if (null == o1.endTime) {
                return 1;
            }
            if (null == o2.getEndTime()) {
                return -1;
            }
            if (!o1.endTime.equals(o2.getEndTime())) {
                return o2.endTime.compareTo(o1.getEndTime());
            }
        }

        //券优惠金额
        if (o1.getCouponValue() != null && o2.getCouponValue() != null) {
            if (!o1.getCouponValue().equals(o2.getCouponValue())) {
                return o2.couponValue.compareTo(o1.getCouponValue());
            }
        }

        // 通兑券排序靠前
        if (o1.cardType != o2.getCardType()) {
            if (o1.cardType == MagicCardTypeEnum.UEMCARD.getValue()) {
                return -1;
            } else if (o2.getCardType() == MagicCardTypeEnum.UEMCARD.getValue()) {
                return 1;
            } else if (o1.getCardType() == MagicCardTypeEnum.FIXVALUE.getValue()) {
                return -1;
            } else if (o2.getCardType() == MagicCardTypeEnum.FIXVALUE.getValue()) {
                return 1;
            } else if (o1.getCardType() == MagicCardTypeEnum.VOUCHER.getValue()) {
                return -1;
            } else if (o2.getCardType() == MagicCardTypeEnum.VOUCHER.getValue()) {
                return 1;
            } else {
                if (o1.cardType == MagicCardTypeEnum.DISCOUNT.getValue()) {
                    return -1;
                } else if (o2.getCardType() == MagicCardTypeEnum.DISCOUNT.getValue()) {
                    return 1;
                }
            }
        }
        return 1;
    };
}
