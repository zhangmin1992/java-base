package com.my.java.util.json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		/**
		 * json字符串转对象
		 */
		String s = "{\"id\":\"0375\",\"city\":\"平顶山\"}";
		A objA = JSONObject.parseObject(s, A.class);
		System.out.println(JSONObject.toJSONString(objA));
		
		/**
		 * 对象转json字符串
		 */
		String temp = com.alibaba.fastjson.JSONObject.toJSONString(objA);
		System.out.println(temp);
		
		/**
		 * fastjson  JSONArray转List
		 */
		JSONArray array = JSONArray.parseArray("[{'id':'0375','city':22}]");
		List<A> list = JSONObject.parseArray(array.toJSONString(), A.class);
		System.out.println(JSONObject.toJSONString(list));
		
		/**
		 * fastjson  List转JSONArray
		 */
		JSONArray array2 = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println(array2.toJSONString());
		
		/**
		 * fastjson  字符串转List
		 */
		List<A> list2 = JSONObject.parseArray("[{'id':'0375','city':22}]", A.class);
		System.out.println(JSONObject.toJSONString(list2));
		
		System.out.println(JSONObject.toJSONString(null));
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
