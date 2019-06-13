package com.my.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.security.action.GetBooleanAction;

public class test2 {

	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = sdf.parse("2019-06-27 23:59:59");
//		System.out.println(getAccountCloseDate());
//		Date date2 = getLastMonthDate();
//		System.out.println(date2);
//		if(date.before(getAccountCloseDate()) && date.after(date2)) {
//			System.out.println("oooo");
//		}
		String aString="2019-02-09";
		System.out.println(aString.split("-")[0]);
		System.out.println(aString.split("-")[1]);
		System.out.println(aString.split("-")[2]);
   }
	
	public static Date getAccountCloseDate() {
		Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(new Date());
        tempStart.set(Calendar.DAY_OF_MONTH, 26);
        tempStart.set(Calendar.HOUR_OF_DAY, 23);
        tempStart.set(Calendar.MINUTE, 59);
        tempStart.set(Calendar.SECOND, 59);
        return tempStart.getTime();
	}
	
	public static Date getLastMonthDate() {
		Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(new Date());
        tempStart.set(Calendar.DAY_OF_MONTH, 1);
        tempStart.add(Calendar.MONTH, -1);
        tempStart.set(Calendar.HOUR_OF_DAY, 0);
        tempStart.set(Calendar.MINUTE, 0);
        tempStart.set(Calendar.SECOND, 0);
        return tempStart.getTime();
	}

}
