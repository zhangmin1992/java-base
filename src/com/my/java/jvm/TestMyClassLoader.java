package com.my.java.jvm;


public class TestMyClassLoader {

	public static void main(String[] args) throws Exception
    {
		/**
		 * 测试自己定义的类加载器
		 */
		MyClassLoader mcl = new MyClassLoader();
		//关于forname的参数:类的全路径限定名，必须和加载的class所在的包名完全一致;是否必须加载;指定的类加载器
        Class cls2 = Class.forName("day00ForImportBean.MyBean", true, mcl);       
        Object obj = cls2.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
        
        /**
         * 测试这个类是由那个加载器加载的
         */
        System.out.println(MyClassLoader.class.getClassLoader());
    }
}
