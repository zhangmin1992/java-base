package com.my.test.listtomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;

public class test {

	public static void main(String[] args) {
		 // 接口返回2个list
		 List<SaasOrderReportCommissionResponse> list1 = new ArrayList<SaasOrderReportCommissionResponse>();
		 List<SaasOrderReportCommissionResponse2> list2 = new ArrayList<SaasOrderReportCommissionResponse2>();
		 SaasOrderReportCommissionResponse saasOrderReportCommissionResponse = new SaasOrderReportCommissionResponse("2019-01-01","1212","1313");
		 SaasOrderReportCommissionResponse saasOrderReportCommissionResponse2 = new SaasOrderReportCommissionResponse("2019-03-01","1212","1313");
		 list1.add(saasOrderReportCommissionResponse);
		 list1.add(saasOrderReportCommissionResponse2);
		 SaasOrderReportCommissionResponse2 model3 = new SaasOrderReportCommissionResponse2("2019-03-01","1000");
		 list2.add(model3);
		 
		 //list 转map
		 Map<String, SaasOrderReportCommissionResponse3> resultMap = new HashMap<String, SaasOrderReportCommissionResponse3>();
		 Map<String, SaasOrderReportCommissionResponse> map1 = list1.stream().collect(  
		            Collectors.toMap(SaasOrderReportCommissionResponse::getPayTime, (p) -> p));  
		 Map<String, SaasOrderReportCommissionResponse2> map2 = list2.stream().collect(  
		            Collectors.toMap(SaasOrderReportCommissionResponse2::getPayTime, (p) -> p));
		 System.out.println(JSONObject.toJSONString(map1));
		 System.out.println(JSONObject.toJSONString(map2));
		 
		 //遍历接口1返回的佣金，结果存入resultMap
		 Iterator<Map.Entry<String, SaasOrderReportCommissionResponse>> entries = map1.entrySet().iterator(); 
		 while (entries.hasNext()) { 
			  Map.Entry<String, SaasOrderReportCommissionResponse> entry = entries.next(); 
			  System.out.println("payTime = " + entry.getKey());
			  SaasOrderReportCommissionResponse3 temp = new SaasOrderReportCommissionResponse3();
			  temp.setBiCommission(entry.getValue().getBiCommission());
			  temp.setCiCommission(entry.getValue().getCiCommission());
			  if(map2.get(entry.getKey()) != null) {
				  temp.setViolationCommission(map2.get(entry.getKey()).getViolationCommission());
				  map2.remove(entry.getKey());
			  }
			  resultMap.put(entry.getKey(), temp);
		 } 
		 
		 //遍历违章佣金map，结果存入resultMap
		 Iterator<Map.Entry<String, SaasOrderReportCommissionResponse2>> entries2 = map2.entrySet().iterator(); 
		 while (entries2.hasNext()) { 
			  Map.Entry<String, SaasOrderReportCommissionResponse2> entry = entries2.next(); 
			  System.out.println("payTime = " + entry.getKey());
			  SaasOrderReportCommissionResponse3 temp = new SaasOrderReportCommissionResponse3();
			  temp.setViolationCommission(entry.getValue().getViolationCommission());
			  resultMap.put(entry.getKey(), temp);
		 }
		 
		 System.out.println(JSONObject.toJSONString(resultMap));
		  
	}

}
