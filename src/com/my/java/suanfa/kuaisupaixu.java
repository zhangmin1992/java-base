package com.my.java.suanfa;

import com.alibaba.fastjson.JSONObject;

public class kuaisupaixu {

	public static void main(String[] args) {
		int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
	}
	
	public static void quickSort(int[] arr,int low,int high) {
        int i = low;
        int j = high;
        if (low > high) {
            return;
        }
        int temp = arr[low];
        while (i < j) {
            //先看右边，依次往左递增=减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //交换i和j不符合的数据
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //此时i==j,替换遍历一次结束后的为止和刚开始的标记位
		arr[low] = arr[i];
		arr[i] = temp;
		System.out.println("结束一次" + i + "-" + j + JSONObject.toJSONString(arr));
		quickSort(arr, low, j-1);
		quickSort(arr, j+1, high);  
	}
}
