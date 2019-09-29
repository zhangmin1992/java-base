package com.my.java.util.idgen;

public class DefaultIdTimeService implements IdTimeService {

	@Override
	public long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
}
