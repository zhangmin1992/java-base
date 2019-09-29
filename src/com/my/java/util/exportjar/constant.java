package com.my.java.util.exportjar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class constant {

    public static final String FULL_TIME_STRING = "yyyy-MM-dd HH:mm:ss";
    
    public static final String TIME_STRING = "HH:mm:ss";
    
    public static final String DAY_STRING = "yyyy-MM-dd";
    
    public static HashMap<String, SimpleDateFormat> cachedMap = new HashMap<String, SimpleDateFormat>();
    
    public static  volatile SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static SimpleDateFormat getInstance(String format) {
    	SimpleDateFormat simpleDateFormat = cachedMap.get(format);
    	if(simpleDateFormat == null) {
    		synchronized (constant.class) {
				if (simpleDateFormat == null) {
					simpleDateFormat = new SimpleDateFormat(format);
					cachedMap.put(format, simpleDateFormat);
				}
			}
    	}
    	return simpleDateFormat;
    }
    
    public static boolean isPrimitive(Object obj) {
		try {
			return ((Class<?>)obj.getClass().getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}
    
    //测试，无用
    public static void main(String[] args) throws Exception {
    	SimpleDateFormat SimpleDateFormat = constant.getInstance(constant.DAY_STRING);
		Date date = SimpleDateFormat.parse("2019-01-01");
		System.out.println(date);
		SimpleDateFormat = constant.getInstance(constant.FULL_TIME_STRING);
		Date date2 = SimpleDateFormat.parse("2019-01-01 12:12:12");
		System.out.println(date2);
		
		Long along = new Long(22);
		System.out.println(along.getClass().isPrimitive());
		System.out.println(isPrimitive(along));
		System.out.println(isPrimitive(1));
		System.out.println(isPrimitive(1.9));
		System.out.println(isPrimitive('2'));
		System.out.println(isPrimitive(new String("2")));
    }

}
