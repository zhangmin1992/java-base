package com.my.java.jvm.statics.load;

public class SupClass {

	public static final String a =  "FINAL";

	public static  String b =  "STATIC";

    static
    {
        System.out.println("supclass init");
    }
    
    public static void test()
    {
    	System.out.println("test");
    }
    
}
