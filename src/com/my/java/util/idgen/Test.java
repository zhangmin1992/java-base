package com.my.java.util.idgen;

/**
 * 1.为什么不能使用uuid当作分库分表的订单号？
 *    因为1.uuid占用空间大，订单号不具有可读性
 *       2.uuid当作辅助索引的时候，因为是无序的，在查询页（4k）上的命中率很低
 *       
 *  2.雪花算法的优点？
 *  SnowFlake的优点是，效率高，整体上按照时间自增排序，提高了序列号的可读性,整个分布式系统内不会产生ID碰撞    
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Sep 25, 2019 7:09:10 PM
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
