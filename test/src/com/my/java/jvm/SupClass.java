package com.my.java.jvm;

public class SupClass {

	public static final String a =  "MIGU";
    
    static
    {
        System.out.println("supclass init");
    }
    
    public static void test() {
    	System.out.println("test");
    }
    
}
