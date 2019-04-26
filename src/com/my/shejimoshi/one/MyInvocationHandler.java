package com.my.shejimoshi.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
	* @Description: 媒婆--代理对象
	* @author zhangmin 
	* @date Apr 18, 2019 2:44:19 PM
 */
public class MyInvocationHandler implements InvocationHandler {

	//保存的被代理对象
	private Person target;
	
	//person是被代理对象，getInstance方法返回代理对象
	public Object getInstance(Person person) {
		this.target = person;
		/**
		 * ClassLoader loader,类加载器
		 * Class<?>[] interfaces,person接口，不是person本身
		 * InvocationHandler h ,InvocationHandler 这里就是this对象
		 */
		Class<?> classz = person.getClass();
		return Proxy.newProxyInstance(classz.getClassLoader(), classz.getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.target.sayHello("王海兴");
		System.out.println("你的性别是" + this.target.getName() + "我需要给你找一个异性相亲");
		return null;
	}

}
