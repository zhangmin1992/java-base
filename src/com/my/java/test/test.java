package com.my.java.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        SeatObject seatObject = new SeatObject("1&2","0");
        SeatObject seatObject2 = new SeatObject("1&12","0");
        SeatObject seatObject3 = new SeatObject("1&21","0");
        List<SeatObject> list = new ArrayList<>();
        list.add(seatObject);
        list.add(seatObject2);
        list.add(seatObject3);
        System.out.println(JSONObject.toJSONString(list));

        List<String> list2 = new ArrayList<>();
        list2.add("1&2");
        list2.add("1&12");
        list2.add("1&21");
        System.out.println(JSONObject.toJSONString(list2));


        String seatDetail = "[{\"key\":\"1&2\",\"value\":\"0\"},{\"key\":\"1&12\",\"value\":\"0\"},{\"key\":\"1&21\",\"value\":\"0\"}]";
        List<SeatObject> seatList = JSON.parseArray(seatDetail, SeatObject.class);
        Map<String,String> map = seatList.stream().collect(Collectors.toMap(SeatObject::getKey,SeatObject::getValue));
        System.out.println(JSONObject.toJSONString(map));

        map.put("1&2","1");
    }
}
