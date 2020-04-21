package com.my.java.jvm.statics.loadshunxu;

public class test {

	public static void main(String[] args) {
		
		/**
		 * static 的执行是有顺序的 static 写在前面的先执行，
		 * private static TestStatic instance = new TestStatic();
         * 执行后就会去执行TestStatic 对静态变量做赋值操作，显示1-1
		 * 但是之后继续执行类的加载，static继续执行，
         * public static int age = 0; age重新赋值为0，num没有变化
		 */
		System.out.println(TestStatic.getInstance().num);
		System.out.println(TestStatic.getInstance().age);
		
	}

}
