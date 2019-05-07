//package com.my.shejimoshi.one;
//
//import java.io.FileOutputStream;
//
//import sun.misc.ProxyGenerator;
//
///**
// * 代理模式的原理：
// * 1.拿到被代理对象的接口，classz.getInterfaces()
// * 2.创建代理对象并返回，Proxy.newProxyInstance(classz.getClassLoader(), classz.getInterfaces(), this);
//	* @Description: TODO(这里用一句话描述这个类的作用) 
//	* @author zhangmin 
//	* @date Apr 18, 2019 3:09:09 PM
// */
//public class Main{
//
//	public static void main(String[] args) throws Exception {
//		Person person = (Person) new MyInvocationHandler().getInstance(new PersonOne("男"));
//		person.sayHello("22");
//		
//		//获取字节码文件
//		byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{person.getClass()});
//		//字节码内容写入文件-/Users/min.zhang/workspace/jar/$Proxy0.class
//		FileOutputStream os = new FileOutputStream("/Users/min.zhang/workspace/jar/$Proxy0.class");
//		os.write(data);
//		os.close();
//		//在线反编译可以看到java jdk代理自动帮我们生成的类
//	}
//
//}
