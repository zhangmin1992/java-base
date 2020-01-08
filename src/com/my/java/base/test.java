package com.my.java.base;


public class test {

	public static void main(String[] args) {
		int taskNum = 13;
		int pageNum = MessageConstants.PAGE_COUNT;
		int pageTotal = taskNum / pageNum;
		for (int page = 0; page <= pageTotal; page++) {
			int pageStart = page * pageNum;
			if (page == pageTotal) {
				pageNum = taskNum % pageNum;
			}
			System.out.println(pageStart + "--" + pageNum);
		}

	}

	private class MessageConstants {

		public static final int PAGE_COUNT = 3;

	}
}
