package com.my.java.base.bijiao;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
        CouponModel model1 = new CouponModel();
//        model1.setStatus(1);
//        model1.setCostType(3);
        model1.setEndTime(null);
//        model1.setCardType(4);

        CouponModel model2 = new CouponModel();
//        model2.setStatus(3);
//        model2.setCostType(2);
//        model2.setCardType(1);

        CouponModel model3 = new CouponModel();
//        model3.setStatus(2);
//        model3.setCostType(1);
//        model3.setCardType(2);

        CouponModel model4 = new CouponModel();
//        model4.setStatus(4);
//        model4.setCostType(3);
        model4.setEndTime(new Date());
//        model4.setCardType(5);

        List<CouponModel> list = new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        Collections.sort(list);
        System.out.println(JSONObject.toJSONString(list));
    }
}
