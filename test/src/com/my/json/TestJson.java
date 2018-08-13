package com.my.json;

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
