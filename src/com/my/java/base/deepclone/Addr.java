package com.my.java.base.deepclone;

/**
 *  深拷贝实现：实体：Addr
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Oct 10, 2019 3:53:28 PM
 */
public class Addr {

	private String city;
	
	private String proviceName;
	
	private DetailAddr detailAddr;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}

	
	public DetailAddr getDetailAddr() {
		return detailAddr;
	}

	public Addr(String city, String proviceName, DetailAddr detailAddr) {
		super();
		this.city = city;
		this.proviceName = proviceName;
		this.detailAddr = detailAddr;
	}

	public void setDetailAddr(DetailAddr detailAddr) {
		this.detailAddr = detailAddr;
	}

	public Addr() {}
}
