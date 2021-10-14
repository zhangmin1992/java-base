package com.my.java.base.bijiao;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testCompare {
    public static void main(String args[]) {
        Model model = new Model(1);
        Model model2 = new Model(7);
        Model model3 = new Model(3);
        List<Model> list = new ArrayList<>();
        list.add(model);
        list.add(model2);
        list.add(model3);
        Collections.sort(list);
        System.out.println(JSONObject.toJSONString(list));
    }
}
