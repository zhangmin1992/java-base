package com.my.java.base;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lamada {

    public static void main(String[] args) {
        List<BankIdentifier> list = new ArrayList<>();
        list.add(new BankIdentifier("1","001","name1"));
        list.add(new BankIdentifier("2","002","name2"));
        list.add(new BankIdentifier("2","003","name3"));
        list.add(new BankIdentifier("1","004","name4"));
        Map<String, List<String>> result =
            list.stream().collect(
                Collectors.groupingBy(BankIdentifier::getBankId,
                    Collectors.mapping(BankIdentifier::getIdentifierValue, Collectors.toList()))
            );

        System.out.println(JSONObject.toJSONString(result));
    }
}
