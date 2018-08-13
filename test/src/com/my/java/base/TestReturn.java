package com.my.java.base;

/*
 * 每一个for循环过来都只是执行TRADE，然后直接return，压根不会执行REFUND和后面的操作
 */
public class TestReturn {

	public static void test() {
		String [] nameStrings={"TRADE","REFUND"};
		for (String string : nameStrings) {
			if(string.equals("TRADE")) {
				System.out.println("你成功了!");
				return;
			}
			System.out.println("继续生成");
		}
	}
	
	public static void main(String[] args) {
		int i=0;
		int k=5;
		while(i<k) {
			System.out.println(i);
			test();
			i++;
		}
		System.out.println("end");
	}

}
