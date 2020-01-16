package com.my.java.meituan;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class test2 {

	public static void main(String[] args) {
		List<TBillRecordTypeEnum> recordTypeList = new ArrayList<TBillRecordTypeEnum>();
		recordTypeList.add(TBillRecordTypeEnum.WITHDRAW);
		recordTypeList.add(TBillRecordTypeEnum.WITHDRAW_FAILED);
		System.out.println(JSONObject.toJSONString(recordTypeList));
	}

}
