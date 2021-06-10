package com.my.java.base;

public class TestSharingJobStatusEnum {

	public static void main(String[] args) {
		SharingJobStatusEnum aEnum = SharingJobStatusEnum.FAILED;
		SharingJobStatusEnum bEnum = SharingJobStatusEnum.FAILED;
		System.out.println(bEnum == aEnum);
		System.out.println(bEnum.equals(aEnum));
	}

}
