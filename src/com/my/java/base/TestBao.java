package com.my.java.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 *  当变量作为作为类成员使用时，java才确保给定其初始值
 *  
 *   如果一边是包装类，一边是基本类型时；或者使用了<、>、<=等比较符，都会进行值比较；
 *   如果发现==两边都是对象，它就直接比较引用，而不是值
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 24, 2019 8:39:54 PM
 */
public class TestBao {

	public static void main(String[] args) {
//		System.out.println(new bao().a);
//		System.out.println(new bao().a1);
//		
//		int a = 128;
//		Integer b = 128;
//		System.out.println(a==b);
//		
//		
//		
//		System.out.println(new bao().cc + "--" + new bao().bb);
		
//		int n=32;
//		System.out.println( n - (n >>> 2));
//		System.out.println(n >>> 3);
//		System.out.println((n << 1) - (n >>> 1));
		getServiceCount("普通洗车-小车;普通洗车-小车;普通洗车-小车;普通洗车-大车;普通洗车-大车;");
	}
	
//	static class bao {
//		private int a;
//		private Integer a1;
//		
//		private Boolean cc;
//		
//		private boolean bb;
//	}
	
	public static class OrderServiceItem {

        private String serviceName;

        private Integer serviceCount;

		public String getServiceName() {
			return serviceName;
		}

		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		public Integer getServiceCount() {
			return serviceCount;
		}

		public void setServiceCount(Integer serviceCount) {
			this.serviceCount = serviceCount;
		}
        
	}
	 
	public static void getServiceCount(String servicesitems) {
		String[] servicesArray = servicesitems.split(";");
		Map<String,OrderServiceItem> consumeServiceMap = new HashMap<>();
		for (String name : servicesArray) {
			if (consumeServiceMap.get(name) == null) {
				OrderServiceItem orderServiceItem = new OrderServiceItem();
				orderServiceItem.setServiceCount(1);
				orderServiceItem.setServiceName(name);
				consumeServiceMap.put(name, orderServiceItem);
			} else {
				OrderServiceItem temp = consumeServiceMap.get(name);
				int count = temp.getServiceCount();
				temp.setServiceCount(count + 1);
			}
		}
		System.out.println(JSONObject.toJSONString(consumeServiceMap));
	}

}
