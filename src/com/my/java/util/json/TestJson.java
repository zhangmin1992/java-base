package com.my.java.util.json;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TestJson {

	public static void main(String[] args) {
		/**
		 * json字符串转对象
		 */
//		String s = "{\"id\":\"0375\",\"city\":\"平顶山\"}";
		String s = "{thirdPartyTradeNo=4349800103201912179360930117, totalFee=255, successTime=1576566559000, status=2}";
		Map<String,String> originatorData = new HashMap<String, String>();
		if(!StringUtils.isEmpty(s)) {
			Map<String,Object> jsonMap = JSONObject.parseObject(s);
    		for(Map.Entry<String, Object> a:jsonMap.entrySet()){
    			originatorData.put(a.getKey(), a.getValue().toString());
    		}
		}
		System.out.println(JSONObject.toJSONString(originatorData));
		
		
		
		//		A objA = JSONObject.parseObject(s, A.class);
//		System.out.println(JSONObject.toJSONString(objA));
//		
//		/**
//		 * 对象转json字符串
//		 */
//		String temp = com.alibaba.fastjson.JSONObject.toJSONString(objA);
//		System.out.println(temp);
//		
//		/**
//		 * fastjson  JSONArray转List
//		 */
//		JSONArray array = JSONArray.parseArray("[{'id':'0375','city':22}]");
//		List<A> list = JSONObject.parseArray(array.toJSONString(), A.class);
//		System.out.println(JSONObject.toJSONString(list));
//		
//		/**
//		 * fastjson  List转JSONArray
//		 */
//		JSONArray array2 = JSONArray.parseArray(JSON.toJSONString(list));
//		System.out.println(array2.toJSONString());
//		
//		/**
//		 * fastjson  字符串转List
//		 */
//		List<A> list2 = JSONObject.parseArray("[{'id':'0375','city':22}]", A.class);
//		System.out.println(JSONObject.toJSONString(list2));
//		
//		System.out.println(JSONObject.toJSONString(null));
	}

}
class A{
	private String id;
	
	private String city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
