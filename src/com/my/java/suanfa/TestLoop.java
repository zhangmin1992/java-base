package com.my.java.suanfa;

import java.util.ArrayList;
import java.util.List;

public class TestLoop {

	public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        int k = 0;
        while(start.size()>0) {
        	k = k + countNum;
        	k = k % (start.size()) - 1;
        	if(k > 0) {
        		System.out.println(start.get(k));
        		start.remove(k);
        	}else {
        		System.out.println(start.get(start.size()-1));
        		start.remove(start.size()-1);
        		k = 0;
        	}
        }
	} 

	public static void main(String[] args) {
		yuesefu(10,3);
	}

}
