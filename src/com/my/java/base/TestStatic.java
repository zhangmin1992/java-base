package com.my.java.base;

/**
 * 设计到面试题的加载顺序是、
 * 静态变量
 * 静态初始化块
 * 变量
 * 初始化块
 * 构造器

 * 找 main方法在的类，发现他继承了Parent，触发了Parent类的加载
 * 父类--静态变量
   父类--静态初始化块
   然后加载自己的类，static代码块或者变量加载的时候按照在类中的顺序，static getName
   子类--静态变量
   子类--静态初始化块
   执行main方法
   然后父类的初始化块+构造方法，子类的初始化块+构造方法
 * @author yp-tc-m-7129
 *
 */
public class TestStatic extends Parent {

  public static String s_StaticField = "子类--静态变量";
  public String s_Field = "子类--变量";
  public static String nameString = getName();
  public String name2 = getName2();
  public com.my.java.base.myClass myClass = new myClass();

  /* 静态初始化块 */
  static {
      System.out.println( s_StaticField );
      System.out.println( "子类--静态初始化块" );
  }
  
  /* 初始化块 */
  {
      System.out.println( s_Field );
      System.out.println( "子类--初始化块" );
  }
  
  public static String getName() {
	  System.out.println("static getName");
	  return "static getName";
  }
  
  public String getName2() {
	  System.out.println("getName");
	  return "getName";
  }
  
  /* 构造器 */
  public TestStatic()
  {
      System.out.println( "子类--构造器" );
      System.out.println( "i=" + i + ",j=" + j );
  }
  
	public static void main(String[] args) {
		 System.out.println( "子类main方法" );
		 new TestStatic();
	}

}

class Parent{
   public static String p_StaticField = "父类--静态变量";
   public String  p_Field = "父类--变量";
   protected int    i    = 9;
   protected int    j    = 0;
   
   /* 静态初始化块 */
   static {
       System.out.println( p_StaticField );
       System.out.println( "父类--静态初始化块" );
   }
   
   /* 初始化块 */
   {
       System.out.println( p_Field );
       System.out.println( "父类--初始化块" );
   }
  
   /* 构造器 */
   public Parent()
   {
       System.out.println( "父类--构造器" );
       System.out.println( "i=" + i + ", j=" + j );
       j = 20;
   }
}

class myClass{
	static {
	    System.out.println( "myClass--静态初始化块" );
	}
	public myClass() {
		System.out.println("---myClass--构造器");
	}
}
