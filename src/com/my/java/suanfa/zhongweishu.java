package com.my.java.suanfa;

import com.alibaba.fastjson.JSONObject;

public class zhongweishu {

	public static double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length;
	    int n = B.length;
	    if (m > n) { // 实现 m<=n
	        int[] temp = A; A = B; B = temp;
	        int tmp = m; m = n; n = tmp;
	    }
	    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
	    while (iMin <= iMax) {
	        int i = (iMin + iMax) / 2;
	        int j = halfLen - i;
	        if (i < iMax && B[j-1] > A[i]){
	            iMin = i + 1; // i 太小，需要增大
	        }
	        else if (i > iMin && A[i-1] > B[j]) {
	            iMax = i - 1; // i 太大，需要减小
	        }
	        else { // i 为合适值，根据不同情况返回不同值
	            int maxLeft = 0;
	            if (i == 0) { maxLeft = B[j-1]; }
	            else if (j == 0) { maxLeft = A[i-1]; }
	            else { maxLeft = Math.max(A[i-1], B[j-1]); }
	            if ( (m + n) % 2 == 1 ) { return maxLeft; }

	            int minRight = 0;
	            if (i == m) { minRight = B[j]; }
	            else if (j == n) { minRight = A[i]; }
	            else { minRight = Math.min(B[j], A[i]); }

	            return (maxLeft + minRight) / 2.0;
	        }
	    }
	    return 0.0;
	}
	
	public static float getMedian(int[] a, int[] b) {
		if (a == null || b == null || (a.length + b.length) == 0) return Float.MIN_VALUE;
		int pa = 0;
		int pb = 0;
		float median = 0;
		while (pa + pb != (a.length + b.length + 1) / 2) {
			int Ai = (pa == a.length) ? Integer.MAX_VALUE : a[pa];  
	        int Bj = (pb == b.length) ? Integer.MAX_VALUE : b[pb]; 
	        if (Ai < Bj) {
	        	median = a[pa];
	        	pa++;
 
	        } else {
	        	median = b[pb];
	        	pb++;
	        }
		}
		if ((a.length + b.length) % 2 == 1) {
			return median;	
		} else {
			int Ai = (pa == a.length) ? Integer.MAX_VALUE : a[pa];  
	        int Bj = (pb == b.length) ? Integer.MAX_VALUE : b[pb]; 
			int median2 = (Ai < Bj) ? Ai : Bj;			
			return (float)(median + median2) / 2;
		}
	}
	
	public static int[] sort(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int i=0,j=0,k = 0;
        while (i<a.length && j<b.length){
            if(a[i]>=b[j]){
                c[k++] = b[j++];
            }else {
                c[k++] = a[i++];
            }
        }
     
        while (j<b.length){
            c[k++] = b[j++];
        }
        while (i<a.length){
            c[k++] = a[i++];
        }
        return c;

    }
	
	public static void main(String[] args) {
		int[] b = {2,4};  
        int[] a = {5,6,8}; 
        System.out.println(JSONObject.toJSONString(sort(a,b)));
		System.out.println(getMedian(a,b));
	}

}
