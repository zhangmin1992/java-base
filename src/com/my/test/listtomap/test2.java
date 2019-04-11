package com.my.test.listtomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;

public class test2 {

	public static void main(String[] args) {
		 // 接口返回2个list
		 List<SaasOrderReportCommissionResponse> list1 = new ArrayList<SaasOrderReportCommissionResponse>();
		 List<SaasOrderReportCommissionResponse2> list2 = new ArrayList<SaasOrderReportCommissionResponse2>();
		 SaasOrderReportCommissionResponse saasOrderReportCommissionResponse = new SaasOrderReportCommissionResponse("2019-01-01",1212L,222L);
		 SaasOrderReportCommissionResponse saasOrderReportCommissionResponse2 = new SaasOrderReportCommissionResponse("2019-03-01",1212L,882L);
		 list1.add(saasOrderReportCommissionResponse);
		 list1.add(saasOrderReportCommissionResponse2);
		 SaasOrderReportCommissionResponse2 model3 = new SaasOrderReportCommissionResponse2("2019-03-01",6400L);
		 list2.add(model3);
		 System.out.println(JSONObject.toJSONString(list1));
		 System.out.println(JSONObject.toJSONString(list2));
		 
		 //list 转map
//		 Map<String, SaasOrderReportCommissionResponse3> resultMap = new HashMap<String, SaasOrderReportCommissionResponse3>();
//		 Map<String, SaasOrderReportCommissionResponse> map1 = list1.stream().collect(  
//		            Collectors.toMap(SaasOrderReportCommissionResponse::getPayTime, (p) -> p));  
//		 Map<String, SaasOrderReportCommissionResponse2> map2 = list2.stream().collect(  
//		            Collectors.toMap(SaasOrderReportCommissionResponse2::getPayTime, (p) -> p));
//		 System.out.println(JSONObject.toJSONString(map1));
//		 System.out.println(JSONObject.toJSONString(map2));
		 
		 Map<String, SaasOrderReportCommissionResponse3> resultMap = new HashMap<String, SaasOrderReportCommissionResponse3>();
		 Map<String, SaasOrderReportCommissionResponse> map1 = new HashMap<String, SaasOrderReportCommissionResponse>();
		 for (SaasOrderReportCommissionResponse temp : list1) {
			 map1.put(temp.getPayTime(), temp);
		 }
		 Map<String, SaasOrderReportCommissionResponse2> map2 = new HashMap<String, SaasOrderReportCommissionResponse2>();
		 for (SaasOrderReportCommissionResponse2 temp : list2) {
			 map2.put(temp.getPayTime(), temp);
		 }
		 System.out.println(JSONObject.toJSONString(map1));
		 System.out.println(JSONObject.toJSONString(map2));
	}

}
