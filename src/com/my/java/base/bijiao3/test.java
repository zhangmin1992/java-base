package com.my.java.base.bijiao3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String args[]) {

        int dealId = 1;

        List<CouponReceiveVO> list = new ArrayList<>();
        CouponReceiveVO mode1 = new CouponReceiveVO();
        mode1.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
        mode1.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        list.add(mode1);


        CouponReceiveVO mode7 = new CouponReceiveVO();
        mode7.setLabelType(LabelTypeEnum.MEMBER_REWARDS.getValue());
        mode7.setCardType(MagicCardTypeEnum.VOUCHER.getValue());
        list.add(mode7);

        CouponReceiveVO mode2 = new CouponReceiveVO();
        mode2.setLabelType(LabelTypeEnum.MERCHANT.getValue());
        mode2.setCardType(MagicCardTypeEnum.UEMCARD.getValue());
        list.add(mode2);


        CouponReceiveVO mode3 = new CouponReceiveVO();
        mode3.setLabelType(LabelTypeEnum.MEMBER_REWARDS.getValue());
        mode3.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        list.add(mode3);

        CouponReceiveVO mode4 = new CouponReceiveVO();
        mode4.setLabelType(LabelTypeEnum.ASSIST_BONUS.getValue());
        mode4.setCardType(MagicCardTypeEnum.DISCOUNT.getValue());
        list.add(mode4);

        CouponReceiveVO mode5 = new CouponReceiveVO();
        mode5.setLabelType(LabelTypeEnum.CLOUD_PACK.getValue());
        mode5.setCardType(MagicCardTypeEnum.FIXVALUE.getValue());
        list.add(mode5);

        Collections.sort(list);

        //云包场→优惠券券码兑换→联合会员→券包→会员奖励
        for(CouponReceiveVO temp : list) {
            System.out.println("--"+ LabelTypeEnum.getLabelTypeDesc(temp.getLabelType()) +"--" + MagicCardTypeEnum.getTypeDesc(temp.getCardType()));
        }
    }
}
