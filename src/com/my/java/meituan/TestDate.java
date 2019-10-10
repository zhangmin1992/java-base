package com.my.java.meituan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.util.TempFile;
import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Range;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		//显示当天0分 Thu Aug 29 00:00:00 CST 2019
		//System.out.println(DateTime.now().withTimeAtStartOfDay().toDate());
		
		
		DateTime start = DateTime.now().withMonthOfYear(9).withDayOfMonth(29).withTimeAtStartOfDay();
		System.out.println(start);
        DateTime end = start.plusDays(1).minusMillis(1);
        System.out.println(end);
        Range<Date> range = Range.closed(start.toDate(), end.toDate());
        List<Range<Date>> rangeList = TimeUtils.spiltPayTime(range);
        rangeList.stream().forEach(data -> {
        	try {
        		System.out.println(data.lowerEndpoint().toString() + "--" + data.upperEndpoint().toString());
        		if("Sun Sep 29 12:30:00 CST 2019".equals(data.lowerEndpoint().toString())) {
        			System.out.println("---------");
        		}
				//System.out.println(parseDateToString(data.lowerEndpoint(),"yyyy-MM-dd HH:mm:ss") + "--" + parseDateToString(data.upperEndpoint(),"yyyy-MM-dd HH:mm:ss"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
//        for (Range<Date> data : rangeList) {
//        	System.out.println(parseDateToString(data.lowerEndpoint(),"yyyy-MM-dd HH:mm:ss") + "--" + parseDateToString(data.upperEndpoint(),"yyyy-MM-dd HH:mm:ss"));
//		}
        
        
		//System.out.println(DateTime.now().toString());
//		System.out.println(DateTime.now().withFieldAdded(DurationFieldType.days(), -1)
//				.withHourOfDay(0)
//				.withSecondOfMinute(0)
//				.withMillisOfDay(0)
//				.withSecondOfMinute(0));
		
		//8月19号到8月31号的数据
		/**DateTime now = DateTime.now().withMonthOfYear(8).withDayOfMonth(18).withTimeAtStartOfDay();
		DateTime end = DateTime.now().withMonthOfYear(8).withDayOfMonth(31).withTimeAtStartOfDay();
		System.out.println(now);
		while(now.getDayOfMonth() < end.getDayOfMonth()) {
			now = now.withFieldAdded(DurationFieldType.days(), 1);
			System.out.println(com.google.common.collect.Range.closed(now.toDate(), now.plusDays(1).minusMillis(1).toDate()));
		}**/
		
		//解析字符串转日期
		/**DateTime startDate = DateTime.parse("2019-09-03");
		System.out.println(startDate);**/
		
//		//打印指定日期：2019-07-31T00:00:00  2019-07-31T23:59:59
//		DateTime start = DateTime.now().withMonthOfYear(7).withDayOfMonth(31)
//    			.withHourOfDay(0)
//    			.withSecondOfMinute(0)
//    			.withMillisOfDay(0)
//    			.withSecondOfMinute(0);
//        DateTime end = start.plusDays(1).minusMillis(1);
//		System.out.println(start);
//		System.out.println(end);
		
//		DateTime now = DateTime.now().withDayOfMonth(1).withTimeAtStartOfDay();
////		DateTime now = DateTime.now().withMonthOfYear(7).withDayOfMonth(31).withTimeAtStartOfDay().withSecondOfMinute(0).withMillisOfDay(0).withSecondOfMinute(0);
//		Range<Date> data = com.google.common.collect.Range.closed(now.toDate(), now.plusDays(1).minusMillis(1).toDate());
//		System.out.println(parseDateToString(data.lowerEndpoint(),"yyyy-MM-dd HH:mm:ss") + "--" + parseDateToString(data.upperEndpoint(),"yyyy-MM-dd HH:mm:ss"));
	}
	
	public static String parseDateToString(Date thedate, String format)
			throws java.text.ParseException {
		DateFormat sdf = new SimpleDateFormat(format);
		String dd1 = "";
		if (thedate != null && !thedate.equals("")) {
			dd1 = sdf.format(thedate);
		}
		return dd1;
	}

}
