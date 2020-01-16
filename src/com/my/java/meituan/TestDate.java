package com.my.java.meituan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Range;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		//显示当天0分 Thu Aug 29 00:00:00 CST 2019
		//System.out.println(DateTime.now().withTimeAtStartOfDay().toDate());
		
		DateTime start2 = DateTime.now().withYear(2019).withMonthOfYear(12).withDayOfMonth(27).withTimeAtStartOfDay();
		System.out.println(start2);
		DateTime end = start2.plusDays(1).withMillisOfDay(0).withMillisOfSecond(0).withSecondOfMinute(0);
		System.out.println(end);
		 
		Range<Date> range = com.google.common.collect.Range.closed(start2.toDate(), end.toDate());
        List<Range<Date>> rangeList = TimeUtils.spiltPayTime(range);
        for (Range<Date> data : rangeList) {
        	
//        	System.out.println(data.lowerEndpoint().getTime() + "--" + data.upperEndpoint().getTime());
        	System.out.println(parseDateToString(data.lowerEndpoint(),"yyyy-MM-dd HH:mm:ss") + "--" + parseDateToString(data.upperEndpoint(),"yyyy-MM-dd HH:mm:ss"));
		  }
//        Long ccc = 1577367515000L;
//        System.out.println(parseDateToString(new Date(ccc),"yyyy-MM-dd HH:mm:ss"));
        
        
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
//		
//		DateTime now = DateTime.now().withDayOfMonth(1).withTimeAtStartOfDay();
////		DateTime now = DateTime.now().withMonthOfYear(7).withDayOfMonth(31).withTimeAtStartOfDay().withSecondOfMinute(0).withMillisOfDay(0).withSecondOfMinute(0);
//		Range<Date> data = com.google.common.collect.Range.closed(now.toDate(), now.plusDays(1).minusMillis(1).toDate());
//		System.out.println(parseDateToString(data.lowerEndpoint(),"yyyy-MM-dd HH:mm:ss") + "--" + parseDateToString(data.upperEndpoint(),"yyyy-MM-dd HH:mm:ss"));
	
		    //退款
//		System.out.println((new Long("21558134976"))% 256);
		System.out.println((new Long("21572163832")/2)% 256);
//		System.out.println((new Long("21543815360")/2)% 256);
//		System.out.println((new Long("21543815858")/2)% 256);
//		System.out.println((new Long("21543815858")/2)% 256);
//		System.out.println((new Long("21543825246")/2)% 256);
//		System.out.println((new Long("21543770209")/2)% 256);
//		System.out.println((new Long("21543837266")/2)% 256);
//		System.out.println((new Long("21543819639")/2)% 256);
//		System.out.println((new Long("21543825246")/2)% 256);
//		System.out.println((new Long("21543885072")/2)% 256);
//		System.out.println((new Long("21543885072")/2)% 256);
//		System.out.println((new Long("21543895132")/2)% 256);
//		System.out.println((new Long("21543895132")/2)% 256);
//		System.out.println((new Long("21543896018")/2)% 256);
//		System.out.println((new Long("21543896896")/2)% 256);
//		System.out.println((new Long("21543896896")/2)% 256);
//		System.out.println((new Long("21543843049")/2)% 256);
//		System.out.println((new Long("21543843049")/2)% 256);
//		System.out.println((new Long("21543846089")/2)% 256);
//		System.out.println((new Long("21543849515")/2)% 256);
//		System.out.println((new Long("21543849515")/2)% 256);
//		System.out.println((new Long("21543912994")/2)% 256);
//		System.out.println((new Long("21543850509")/2)% 256);
//		System.out.println((new Long("21543953168")/2)% 256);
//		System.out.println((new Long("21543953168")/2)% 256);
//		System.out.println((new Long("21543646065")/2)% 256);
//		System.out.println((new Long("21544013426")/2)% 256);
//		System.out.println((new Long("21544013760")/2)% 256);
//		System.out.println((new Long("21543963271")/2)% 256);
//		System.out.println((new Long("21543963271")/2)% 256);
//		System.out.println((new Long("21543985267")/2)% 256);
//		System.out.println((new Long("21543985267")/2)% 256);
//		System.out.println((new Long("21543912994")/2)% 256);
//		System.out.println((new Long("21544008459")/2)% 256);
//		System.out.println((new Long("21544008459")/2)% 256);
//		System.out.println((new Long("21544035977")/2)% 256);
//		System.out.println((new Long("21544099105")/2)% 256);
//		System.out.println((new Long("21544098195")/2)% 256);
//		System.out.println((new Long("21544176902")/2)% 256);
//		System.out.println((new Long("21544035977")/2)% 256);
//		System.out.println((new Long("21538226005")/2)% 256);
//		System.out.println((new Long("21544148545")/2)% 256);
//		System.out.println((new Long("21544148545")/2)% 256);
//		System.out.println((new Long("21544215000")/2)% 256);

//		    System.out.println((new Long("21543646065")/2)% 256);
//		    System.out.println((new Long("21518664467")/2)% 256);
//		   
//		    System.out.println((new Long("21525625820")/2)% 256);
//		    System.out.println((new Long("21525762826")/2)% 256);
//		    System.out.println((new Long("21526391236")/2)% 256);
//		    System.out.println((new Long("21525431670")/2)% 256);
//		    
//		    System.out.println("---------");
//		    
//		    //支付
//		    System.out.println((new Long("21517819029")/2)% 256);
//		    System.out.println((new Long("21518346579")/2)% 256);
//		    System.out.println((new Long("21518432195")/2)% 256);
//		    System.out.println((new Long("21518701303")/2)% 256);
//		    System.out.println((new Long("21518714516")/2)% 256);
			 
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
