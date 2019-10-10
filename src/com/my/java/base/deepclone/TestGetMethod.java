package com.my.java.base.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *   测试反射中的getMethod setMethod方法的作用
	* @author zhangmin 
	* @date Feb 19, 2019 11:01:20 AM
 */
/**
 * 执行结果：
	public void com.my.java.base.deepclone.person.hello()
	public void com.my.java.base.deepclone.person.speak(java.lang.String)
	public void com.my.java.base.deepclone.person.speak(java.lang.String,int)
	public java.lang.String com.my.java.base.deepclone.person.getName()
	jahahha
	jahahha
	444
	444
	Exception in thread "main" java.lang.NoSuchMethodException: 
	* @author zhangmin 
	* @date Oct 10, 2019 4:09:34 PM
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
		person.setName("jahahha");
		person target = new person();
		target = person;
		Method m1 = person.getClass().getMethod("hello", null);
		Method m2= person.getClass().getMethod("speak", String.class);
		Method m3 = person.getClass().getMethod("speak", String.class,int.class);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		/**
		 * 浅拷贝后，target的name属性也是person的name属性值
		 * person对象的mget方法，没有参数
		 */
		Method mget = person.getClass().getMethod("getName", null);
		System.out.println(mget);
		Object returnVal = mget.invoke(person);
		System.out.println(returnVal);
		System.out.println(target.getName());
		
		/**
		 * person对象的属性调用setName方法赋值为444，target对象的属性值也改变了
		 */
		Method mset = person.getClass().getMethod("setName", String.class);
		mset.invoke(person, "444");
		Object returnVal2 = mget.invoke(person);
		System.out.println(returnVal2);
		System.out.println(target.getName());
		
		Method mget2 = person.getClass().getMethod("getmychinesename", null);
		System.out.println(mget2);
	}

}
