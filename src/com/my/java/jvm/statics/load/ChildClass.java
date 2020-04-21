package com.my.java.jvm.statics.load;

public class ChildClass extends  SupClass{

    public static final String a =  "ChildClass-FINAL";

    public static  String b =  "ChildClass-STATIC";

    public ChildClass(){}

    static
    {
        System.out.println("ChildClass init");
    }

    public static void test()
    {
        System.out.println("ChildClass test");
    }


}
