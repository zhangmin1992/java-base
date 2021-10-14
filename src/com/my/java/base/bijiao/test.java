package com.my.java.base.bijiao;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Set<Integer> channelIds = new HashSet<>();
        channelIds.add(1);

        CouponModel model1 = new CouponModel();
        model1.setCardType(MagicCardTypeEnum.VOUCHER.getValue());
        CouponLimitModel limitModel1 = new CouponLimitModel();
        limitModel1.setCardType(1);
        limitModel1.setCityIds(channelIds);
        limitModel1.setMemberCardSet(channelIds);
        limitModel1.setPriceLimit(15);
        model1.setCouponLimitModel(limitModel1);
        model1.setCostType(2);
        model1.setValue(9.9F);

        CouponModel model2 = new CouponModel();
        model2.setCardType(MagicCardTypeEnum.VOUCHER.getValue());
        model2.setCostType(2);
        CouponLimitModel limitModel2 = new CouponLimitModel();
        limitModel2.setCardType(1);
        limitModel2.setCityIds(channelIds);
        limitModel2.setMemberCardSet(channelIds);
        limitModel2.setPriceLimit(10);
        model2.setCouponLimitModel(limitModel2);
        model2.setValue(9.9F);

        CouponModel model3 = new CouponModel();
        model3.setCardType(MagicCardTypeEnum.VOUCHER.getValue());
        model3.setCostType(2);

        CouponModel model4 = new CouponModel();
        model4.setCardType(4);

        List<CouponModel> list = new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
//        list.add(model4);
        Collections.sort(list);
        for (CouponModel couponModel : list) {
            System.out.println(JSONObject.toJSONString(couponModel));
        }
        //System.out.println(JSONObject.toJSONString(list));
    }
}
