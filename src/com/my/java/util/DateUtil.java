package com.my.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class DateUtil {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
    
    public static SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
    
    public static final String FULL_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
    
    public static final String TIME_STRING = "HH:mm:ss";
    
    public static final String DAY_STRING = "yyyy-MM-dd";
    
    public static final String DAY_STRING2 = "yyyy-MM";
    
    /**
     * 任意类型字符串转时间
     * @param thedate
     * @param format
     * @throws java.text.ParseException
     * @return Date
     * @author min.zhang
     * @date: 2017年4月10日 上午11:03:56
     */
	public static Date parseStringToDate(String thedate, String format)
			throws java.text.ParseException {
		DateFormat sdf = new SimpleDateFormat(format);
		Date dd1 = null;
		if (thedate != null && !thedate.equals("")) {
			dd1 = sdf.parse(thedate);
		}
		return dd1;
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
	
	/** 
     * 得到指定日期的前后几天日期字符串，前后几小时，前后几秒的日期字符串
     * @param format  格式 
     * @return  字符串日期 
     */  
	public static Date beforeAfterNDaysDate(Date dt, int type, Integer day) {
		Calendar calendar = Calendar.getInstance();// 得到日历
		calendar.setTime(dt);// 把当前时间赋给日历
		calendar.add(type, day); // 设置为前后N天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * yyyy-MM-dd格式的字符串日期相差几天
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static int daysBetween(String smdate, String bdate)
			throws ParseException, java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_STRING);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 前一个日期和后一个日期比较年月日时分秒的大小，相等返回0，小于返回-1，前日期大于后日期返回1
	 * @param date
	 * @param otherDate
	 * @param withUnit
	 * @return
	 * @return int
	 * @author min.zhang
	 * @date: 2017年4月10日 上午11:51:59
	 */
	public static int compareDate(Date date, Date otherDate, int withUnit) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		
        Calendar otherDateCal = Calendar.getInstance();
        otherDateCal.setTime(otherDate);
        
        switch (withUnit) {
        case Calendar.YEAR:
        	dateCal.clear(Calendar.MONTH);
        	otherDateCal.clear(Calendar.MONTH);
        case Calendar.MONTH:
        	dateCal.set(Calendar.DATE, 1);
        	otherDateCal.set(Calendar.DATE, 1);
        case Calendar.DATE:
        	dateCal.set(Calendar.HOUR_OF_DAY, 0);
        	otherDateCal.set(Calendar.HOUR_OF_DAY, 0);
        case Calendar.HOUR:
        	dateCal.clear(Calendar.MINUTE);
        	otherDateCal.clear(Calendar.MINUTE);
        case Calendar.MINUTE:
        	dateCal.clear(Calendar.SECOND);
        	otherDateCal.clear(Calendar.SECOND);
        case Calendar.SECOND:
        	dateCal.clear(Calendar.MILLISECOND);
        	otherDateCal.clear(Calendar.MILLISECOND);
        case Calendar.MILLISECOND:
			break;
		default: throw new IllegalArgumentException("withUnit 单位字段 " + withUnit + " 不合法！！");
		}
		return dateCal.compareTo(otherDateCal);
	}
	
	 /**
     * 判断这个时间是否在开始时间和结束时间之内,不包括结束和开始时间
     * @param now
     * @param start
     * @param end
     * @param model
     * @return boolean
     * @author min.zhang
     * @date: 2017年4月10日 下午12:04:53
     */
    public static boolean isBetween(Date now, Date start, Date end) {
    	if (now == null || start == null || end == null)
    		throw new IllegalArgumentException("The scale must be a positive integer or zero");
    	if(start.before(end) || start.equals(end)) {
    		if (now.after(start) && now.before(end))
        		return true;
    	}else {
    		if (now.after(end) && now.before(start))
        		return true;
    	}
    	return false;
    }
    
    /**
     * 当前日期是第几季度，分为4个季度
     * @param date
     * @return int
     * @author min.zhang
     * @date: 2017年4月10日 下午12:08:40
     */
    public static int getSeason(Date date) {
		int season = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}
    
    /**
     * 两个日期之间的具体天数，不包含开始和截止，要开始《截止
     * @param start
     * @param end
     * @return
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }
    
    public static List<String> getBetweenDates(String start, String end) {
    	SimpleDateFormat sdf = new SimpleDateFormat(DAY_STRING);
        List<String> result = new ArrayList<String>();
    	try {
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(sdf.parse(start));
            
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(sdf.parse(end));
            while (tempStart.before(tempEnd)) {
                result.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
            result.add(end);
            return result;
		} catch (Exception e) {
			return result;
		}
    }
    
    public static List<String> getBetweenMonths(String start, String end) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> result = new ArrayList<String>();
    	try {
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(sdf.parse(start));
            
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(sdf.parse(end));
            while (tempStart.before(tempEnd)) {
                result.add(sdf.format(tempStart.getTime()));
                tempStart.add(Calendar.MONTH, 1);
            }
            result.add(end);
            return result;
		} catch (Exception e) {
			return result;
		}
    }
    
    public static String beforeAfterNDaysDate(String dt, int type, Integer day) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat(DAY_STRING);
    		Calendar calendar = Calendar.getInstance();// 得到日历
    		calendar.setTime(sdf.parse(dt));// 把当前时间赋给日历
    		calendar.add(type, day); // 设置为前后N天
    		return sdf.format(calendar.getTime());
		} catch (Exception e) {
			return null;
		}
	}
    
    public static int isDayEquals(Date d1,Date d2) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat(DAY_STRING);
    		String day1 = sdf.format(d1);
    		String day2 = sdf.format(d2);
    		if(day1.equals(day2)) {
    			return 1;
    		}else {
    			return 0;
    		}
		} catch (Exception e) {
			return 0;
		}
	}
    
    public static String stampToDate(long lt){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
	public static void main(String[] args) throws ParseException {
//		Date date = parseStringToDate("2018-01-08","yyyy-MM-dd");
//		System.out.println(date);
//		
//		Date date2 =  beforeAfterNDaysDate(new Date(),Calendar.DAY_OF_YEAR,-8);
//		System.out.println("---------"+date2);
//		
//		int days = daysBetween("2018-09-09","2018-09-01");
//		System.out.println(days);
//		
//		int period = compareDate(date,date2, Calendar.DATE);
//		System.out.println(period);
//		
//		Date nowDate = parseStringToDate("2018-01-06","yyyy-MM-dd");
//		boolean result = isBetween(nowDate,date2,date);
//		System.out.println(result);
//		result = isBetween(nowDate,date,date2);
//		System.out.println(result);
//		
//		int jidu = getSeason(date);
//		System.out.println(jidu);
//		
//		List<Date> list = getBetweenDates(date2,date);
//		System.out.println(list);
//		
//		List<String> list2 = getBetweenDates("2019-01-01","2019-01-01");
//		System.out.println(list2);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String startDate = "2019-01-01";
//		String endDate = "2019-01-10";
//		Calendar tempStart = Calendar.getInstance();
//        tempStart.setTime(sdf.parse(startDate));
//        Calendar tempEnd = Calendar.getInstance();
//        tempEnd.setTime(sdf.parse(endDate));
//        tempEnd.add(Calendar.DAY_OF_YEAR, 1);
//		while (tempStart.before(tempEnd)) {
////			System.out.println("--" + sdf.format(tempStart.getTime()));
//			System.out.println("--" + tempStart.getTime());
//            tempStart.add(Calendar.DAY_OF_YEAR, 1);
//		}
//		
//		String date3 =  beforeAfterNDaysDate("2019-01-05",Calendar.MONTH,3);
//		System.out.println(date3);
//		if(DateUtil.beforeAfterNDaysDate("2019-01-15", Calendar.MONTH, 3).compareTo("2019-08-01")<0) {
//			System.out.println("最多3个月");
//		}
//		
//		System.out.println(isDayEquals(new Date(),new Date()));
//		
//		Calendar tempStart2 = Calendar.getInstance();
//		tempStart2.setTime(new Date());
//		System.out.println(tempStart2.get(Calendar.YEAR));
//		System.out.println(tempStart2.get(Calendar.MONTH));
//		System.out.println(tempStart2.get(Calendar.DAY_OF_MONTH));
//		
//		
//		List<String> list33 = getBetweenMonths("2018-11","2019-04");
//		System.out.println(JSONObject.toJSONString(list33));
	 
		System.out.println(stampToDate(1575258746762L));
		 
	}

}
