package com.my.java.base.deepclone;

import com.alibaba.fastjson.JSONObject;

/**
 *  测试实现深拷贝了没有
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin
	* @date Feb 19, 2019 11:30:38 AM
 */
public class Test {

	public static void main(String[] args) {
		DetailAddr detailAddr = new DetailAddr("xiangxidizhi");
		Addr addr = new Addr("city", "dizhi",detailAddr);
		Student student = new Student("name", 11, addr);
		Student target = (Student) ObjectCopy.copy(student);
		System.out.println(JSONObject.toJSONString(target));
		
		/**
		 * 属性2次依赖 Student-》Addr
		 */
		target.getAddr().setCity("cccccc");
		System.out.println(JSONObject.toJSONString(target));
		System.out.println(JSONObject.toJSONString(student));
		
		/**
		 * 属性3次依赖 Student-》Addr-》DetailAddr
		 */
		DetailAddr detailAddr2 = new DetailAddr("222222");
		target.getAddr().setDetailAddr(detailAddr2);
		System.out.println(JSONObject.toJSONString(target));
		System.out.println(JSONObject.toJSONString(student));
	}

}
