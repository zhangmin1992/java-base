package com.my.java.base.bijiao2;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {

        BalanceAccountModel model1 = new BalanceAccountModel();
        model1.setAmount(99);
        model1.setCreateTime(33);

        BalanceAccountModel model2 = new BalanceAccountModel();
        model2.setAmount(99);
        model2.setCreateTime(44);

        BalanceAccountModel model3 = new BalanceAccountModel();
        model3.setAmount(100);

        List<BalanceAccountModel> list = new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        Collections.sort(list);

        for (BalanceAccountModel couponModel : list) {
            System.out.println(JSONObject.toJSONString(couponModel));
        }
    }
}
