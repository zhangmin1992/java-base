package com.my.java.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class testlst2 {

	public static void main(String[] args) {
		List<Integer> poiList = new ArrayList<Integer>();
        poiList.add(40470614);
        List<Integer> poiList2 = Arrays.asList(40470614);
        System.out.println(JSONObject.toJSONString(poiList2));
	}

}
