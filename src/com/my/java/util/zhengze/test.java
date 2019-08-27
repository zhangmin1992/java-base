package com.my.java.util.zhengze;

public class test {

	public static void main(String[] args) {
		//String cString = "鄂EN29981";
		//String cString = "鄂EK102S1";
		//String cString = "鄂E687441";
		//String cString = "粤Z1234港";
		//String cString = "川AD123456";
		  String cString = "WJ1812345";
		//String cString = "鄂EES7181";
		//String cString = "鄂E6G1831";
		//String dString = "^([WJ]|[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼军空海北沈兰济南广成WVKHBSLJNGC使领]{1}([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{4,5}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
		String dString ="^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼军空海北沈兰济南广成VKHBSLJNGCW使领][A-Z](([0-9]{5}[A-HJ-NP-Z0-9])|([A-HJ-NP-Z0-9]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼军空海北沈兰济南广成VKHBSLJNGCW使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
		if(cString.matches(dString)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	
	}

}
