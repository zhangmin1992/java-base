package com.my.java.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *  当变量作为类成员使用时，java才确保给定其初始值
 *  
 *   如果一边是包装类，一边是基本类型时；或者使用了<、>、<=等比较符，都会进行值比较；
 *   如果发现==两边都是对象，它就直接比较引用，而不是值
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 24, 2019 8:39:54 PM
 */
public class TestBao {

	public static void main(String[] args) {
		/**
		 * 实体中int初始值0 Integer初始值null
		 * boolean 初始值false Boolean初始值null
		 * 
		 *  System.out.println(new bao().a);
			System.out.println(new bao().a1);
			System.out.println(new bao().cc);
			System.out.println(new bao().bb);
		 */
		
		int a = 128;
		Integer b = 128;
		System.out.println(a==b);
		
		bao aa = new bao();
		aa.setA(12);
		bao bb = new bao();
		bb.setA1(12);
		System.out.println(aa.getA() == bb.getA1());
 
	}
	
	static class bao {
		private int a;
		
		private Integer a1;
		
		private boolean bb;
		
		private Boolean cc;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public Integer getA1() {
			return a1;
		}

		public void setA1(Integer a1) {
			this.a1 = a1;
		}

		public boolean isBb() {
			return bb;
		}

		public void setBb(boolean bb) {
			this.bb = bb;
		}

		public Boolean getCc() {
			return cc;
		}

		public void setCc(Boolean cc) {
			this.cc = cc;
		}
		
	}
	
}
