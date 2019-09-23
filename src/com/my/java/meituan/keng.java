package com.my.java.meituan;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

public class keng {

	public static void main(String[] args) {
		//string。valueof参数为null，空指针
		/**Map<String, String> info = Maps.newHashMap();
        info.put("REFUND_FEE", String.valueOf(null));
        System.out.println(JSONObject.toJSONString(info));**/
        
		int diffType = 1 == 1 ? 2 : 1;  
        System.out.println(diffType);
        
	}
	
	private List<student> convertIcbcRefund(List<student> refundRecordList) {
        return refundRecordList.stream().map(refundRecord -> {
        	student dataModel = new student(1, 1, "3");
            return dataModel;
        }).collect(Collectors.toList());
    }

}
