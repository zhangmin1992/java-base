package com.my.java.jvm.neicunfenpei;

/**
 * 功能描述: 空间分配担保
 * @Author: zhangmin
 * @Date: 2020/4/17 10:18 AM
 */
public class TestNeiCunFenPei {

	/**
	 * 内存设置参数是： -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
		* @Description: TODO(这里用一句话描述这个方法的作用)
		* @param @param args
		* @return void    返回类型 
		* @throws
	 */
	private static int size = 1024 * 1024;
	
	public static void main(String[] args) {
		/**
		 * 空间分配担保，新生eden 8M，存放3+3 新来的7M放不下
         * 回收3+3，但是幸存区1M放不下
         * 因此向老年代借内存，3+3放入老年代，7M放下eden区域
         * 6/10 老年代60%  7/8 eden代 91%
		 */
		byte[] one = new byte[3 * size];
		byte[] two = new byte[3 * size];
		byte[] four = new byte[7 * size];
	}

}
