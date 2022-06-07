package com.my.java.base.bijiao3;

import com.my.java.util.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String args[]) {

        int dealId = 1;

        List<CouponReceiveVO> list = new ArrayList<>();
        CouponReceiveVO mode1 = new CouponReceiveVO();
        mode1.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
        mode1.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        mode1.setEndTime(new Date());
        list.add(mode1);

        CouponReceiveVO mode6 = new CouponReceiveVO();
        mode6.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
        mode6.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        try {
            mode6.setEndTime(DateUtil.parseStringToDate("2025-04-21","yyyy-MM-dd"));
        } catch (Exception e) {

        }
        list.add(mode6);

        CouponReceiveVO mode7 = new CouponReceiveVO();
        mode7.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
        mode7.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        try {
            mode7.setEndTime(DateUtil.parseStringToDate("2024-04-21","yyyy-MM-dd"));
        } catch (Exception e) {

        }
        list.add(mode7);

//        CouponReceiveVO mode2 = new CouponReceiveVO();
//        mode2.setLabelType(LabelTypeEnum.MERCHANT.getValue());
//        mode2.setCardType(MagicCardTypeEnum.UEMCARD.getValue());
//        list.add(mode2);
//
//
//        CouponReceiveVO mode3 = new CouponReceiveVO();
//        mode3.setLabelType(LabelTypeEnum.MEMBER_REWARDS.getValue());
//        mode3.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
//        list.add(mode3);
//
//        CouponReceiveVO mode4 = new CouponReceiveVO();
//        mode4.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
//        mode4.setCardType(MagicCardTypeEnum.DISCOUNT.getValue());
//        list.add(mode4);
//
//        CouponReceiveVO mode5 = new CouponReceiveVO();
//        mode5.setLabelType(LabelTypeEnum.CLOUD_PACK.getValue());
//        mode5.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
//        list.add(mode5);

        Collections.sort(list);

        //云包场→优惠券券码兑换→联合会员→券包→会员奖励
        for(CouponReceiveVO temp : list) {
            System.out.println(temp.getEndTime() + "--"+ LabelTypeEnum.getLabelTypeDesc(temp.getLabelType()) +"--" + MagicCardTypeEnum.getTypeDesc(temp.getCardType()));
        }
    }
}
