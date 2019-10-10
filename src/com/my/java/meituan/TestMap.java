package com.my.java.meituan;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TestMap {

	public static void main(String[] args) {
		 Map<Integer, student> map = Maps.newHashMap();
		 List<student> list = Lists.newArrayList();
		 map.put(1, new student(1, 1, "1111"));
		 map.put(2, new student(1, 1, "2222"));
		 System.out.println(map.values());
		 list.addAll(map.values());
		 System.out.println(JSONObject.toJSONString(list));
	}

}
