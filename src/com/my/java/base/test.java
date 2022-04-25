package com.my.java.base;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {

	public static void main(String[] args) {
//		int taskNum = 13;
//		int pageNum = MessageConstants.PAGE_COUNT;
//		int pageTotal = taskNum / pageNum;
//		for (int page = 0; page <= pageTotal; page++) {
//			int pageStart = page * pageNum;
//			if (page == pageTotal) {
//				pageNum = taskNum % pageNum;
//			}
//			System.out.println(pageStart + "--" + pageNum);
//		}
//		int a = 5060001;
//		int b = 5060001;
//		System.out.print(a == b);

//        List<CinemalDetailVO> result = new ArrayList<>();
//        result.add(new CinemalDetailVO(14.4444));
//        result.add(new CinemalDetailVO(3.33));
//        result.add(new CinemalDetailVO(5.55));
//        Collections.sort(result);
//        System.out.println(JSONObject.toJSONString(result));

        String temp = new BigDecimal("90").divide(new BigDecimal("10")).setScale(1, RoundingMode.HALF_DOWN).toString();
        if ("0".equals(temp.indexOf(temp.length())-1)) {
            temp = temp.substring(0,temp.length() -2);
        }
        System.out.println(temp);
	}

	private class MessageConstants {

		public static final int PAGE_COUNT = 3;

	}
}
