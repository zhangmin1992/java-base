package com.my.java.util.idgen;

import java.util.concurrent.atomic.AtomicLong;

public class IdRange {

	private final long minValue;

	private final long maxValue;

	private AtomicLong currentValue;

	private volatile boolean overflow = false;

	// [minValue, maxValue)
	public IdRange(long minValue, long maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.currentValue = new AtomicLong(minValue);
	}

	public long next() {
		if (this.overflow) {
			return -1;
		}
		long id = this.currentValue.getAndIncrement();
		if (id >= this.maxValue) {
			this.overflow = true;
			return -1;
		}
		return id;
	}

	public int size() {
		return (int) (this.maxValue - this.minValue);
	}

	public int remain() {
		int r = (int) (this.maxValue - this.currentValue.get());
		return r >= 0 ? r : 0;
	}

	public boolean hasNext() {
		return ((this.maxValue - this.currentValue.get()) > 0);
	}

	public boolean isOverflow() {
		return overflow;
	}

	public long getMinValue() {
		return this.minValue;
	}

	public long getMaxValue() {
		return this.maxValue;
	}
}

