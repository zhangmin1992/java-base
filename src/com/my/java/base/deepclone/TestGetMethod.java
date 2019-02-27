package com.my.java.base.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试反射中的getMethod方法的作用
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Feb 19, 2019 11:01:20 AM
 */
class person {

	private String name;
	
	private String myChineseName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMyChineseName() {
		return myChineseName;
	}
	public void setMyChineseName(String myChineseName) {
		this.myChineseName = myChineseName;
	}
	public void speak(String name) {
		System.out.println("----"+name);
	}
	public void speak(String name,int age) {
		System.out.println("----"+name + "----"+age);
	}
	public void hello() {
		System.out.println("hello");
	}
	public person() {}
}
public class TestGetMethod {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		person person = new person();
		person target = new person();
		person.setName("jahahha");
		Method m1 = person.getClass().getMethod("hello", null);
		Method m2= person.getClass().getMethod("speak", String.class);
		Method m3 = person.getClass().getMethod("speak", String.class,int.class);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		Method mget = person.getClass().getMethod("getName", null);
		Object returnVal = mget.invoke(person);
		System.out.println(returnVal);
		
		Method mset = person.getClass().getMethod("setName", String.class);
		mset.invoke(target, returnVal);
		System.out.println(target.getName());
		
		Method mget2 = person.getClass().getMethod("getmychinesename", null);
		System.out.println(mget2);
	}

}
