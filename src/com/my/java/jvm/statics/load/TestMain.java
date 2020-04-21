package com.my.java.jvm.statics.load;

/**
 * 功能描述: <br>
 * @Param: 测试SupClass类是否被加载，什么情况下触发类加载
 * @Return: 
 * @Author: zhangmin
 * @Date: 2020/4/10 3:37 PM
 */
public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
	    //类的final变量不可再次赋值
//      SupClass.a="3";

        //1。访问类的final 静态变量不会触发类加载
//		System.out.println(SupClass.a);

        //2。访问类的静态变量非final 或者对静态变量赋值 才会触发类加载
//        System.out.println(SupClass.b);
        SupClass.b = "3";

        //3。访问类的静态方法触发类加载
//    	SupClass.test();

        //4。显示使用Class.forName触发加载
//		Class.forName(SupClass.class.getName());
//		TestMain.class.getClassLoader().loadClass(SupClass.class.getName());

        //5。初始化一个类的子类
//        new ChildClass();

        //6。访问子类的静态变量也会触发父的加载，但是final变量就不行
//        System.out.println(ChildClass.a);
//        System.out.println(ChildClass.b);
	}
	
}
