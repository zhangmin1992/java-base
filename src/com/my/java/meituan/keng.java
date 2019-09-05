package com.my.java.meituan;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

public class keng {

	public static void main(String[] args) {
		Map<String, String> info = Maps.newHashMap();
        info.put("REFUND_FEE", String.valueOf(null));
        System.out.println(JSONObject.toJSONString(info));
        
        
        
	}
	
	private List<student> convertIcbcRefund(List<student> refundRecordList) {
        return refundRecordList.stream().map(refundRecord -> {
        	student dataModel = new student(1, 1, "3");
            return dataModel;
        }).collect(Collectors.toList());
    }

}
