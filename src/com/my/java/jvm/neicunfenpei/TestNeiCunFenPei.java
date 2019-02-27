package com.my.java.jvm.neicunfenpei;

public class TestNeiCunFenPei {

	/**
	 * 内存设置参数是：-XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param args
		* @return void    返回类型 
		* @throws
	 */
	private static int size = 1024 * 1024;
	
	public static void main(String[] args) {
		/**
		 * 空间分配担保
		 */
		byte[] one = new byte[3 * size];
		byte[] two = new byte[3 * size];
		byte[] four = new byte[7 * size];
	}

}
