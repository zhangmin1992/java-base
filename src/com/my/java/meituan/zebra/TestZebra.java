package com.my.java.meituan.zebra;

public class TestZebra {

	public static void main(String[] args) {
		RuleEngineBase ruleEngineBase = new RuleEngineBase();
		/**
		 * Object shardValues, 
		 * String dateFormat, 
		 * String inclusiveStartTime,
	      String inclusiveEndTime, 
	      int monthCountPerTable, 
	      int databaseCount, 
	      int tableCountPerDb, 
	      int defaultDbIndex,
	      int defaultTableIndex
		 */
		ruleEngineBase.shardByMonth("", "yyyy-MM-dd", "2015-01-15", "2016-12-20", 
				1, 0, 1, 0, 0);
	}

}
