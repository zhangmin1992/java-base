package com.my.java.base.deepclone;

/**
 * 深拷贝实现：实体：DetailAddr
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Oct 10, 2019 3:54:01 PM
 */
public class DetailAddr {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public DetailAddr() {}

	public DetailAddr(String name) {
		super();
		this.name = name;
	}
	
}
