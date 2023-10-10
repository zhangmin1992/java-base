package com.my.java.stream;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        List<Entity> list2 = null;
//        List<Integer> age = list2.stream().map(e-> e.getAge()).collect(Collectors.toList());
//        System.out.println(JSONObject.toJSONString(age));

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(5L);
        //[1,3,5]
        System.out.println(JSONObject.toJSONString(list.toArray()));
    }
}
