package com.my.java.suanfa;

/**
 * 功能描述:给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 */
public class zhongweishu {

    /**
     * 功能描述: 效率低，不考虑
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // 实现 m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i 太小，需要增大
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i 太大，需要减小
            } else { // i 为合适值，根据不同情况返回不同值
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static float getMedian(int[] a, int[] b) {
        if (a == null || b == null || (a.length + b.length) == 0)
            return Float.MIN_VALUE;
        //数组a的指针
        int pa = 0;
        //数组B的移动指针
        int pb = 0;
        //奇数个数的中位数
        float median = 0;
        //pa + pb表示从ab数组中共取的元素个数
        while (pa + pb != (a.length + b.length + 1) / 2) {
            //数组移动越界之后取最大值
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
        //总个数为奇数，直接返回median
        if ((a.length + b.length) % 2 == 1) {
            return median;
        } else {
            //总个数为偶数，获取pa 或者 pb 的下一个元素的最小值median2，这两个值的中间数为中位数
            int Ai = (pa == a.length) ? Integer.MAX_VALUE : a[pa];
            int Bj = (pb == b.length) ? Integer.MAX_VALUE : b[pb];
            int median2 = (Ai < Bj) ? Ai : Bj;
            return (float) (median + median2) / 2;
        }
    }

    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]) {
                c[k++] = b[j++];
            } else {
                c[k++] = a[i++];
            }
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        return c;

    }

    public static void main(String[] args) {
        int[] b = {2, 3, 4, 6};
        int[] a = {5, 6, 8, 10};
//        System.out.println(JSONObject.toJSONString(sort(a, b)));
//        System.out.println(findMedianSortedArrays(a, b));
        System.out.println(getMedianV2(a, b));
    }

    public static float getMedianV2(int[] a, int[] b) {
        if (a == null || b == null || (a.length + b.length) == 0) {
            return Float.MIN_VALUE;
        }
        int pa = 0;
        int pb = 0;
        int len = (a.length + b.length + 1) / 2;
        int median = 0;
        while (pa + pb < len) {
            int Ai = pa < a.length ? a[pa] : Integer.MAX_VALUE;
            int Bj = pb < b.length ? b[pb] : Integer.MAX_VALUE;
            if (Ai < Bj) {
                median = Ai;
                pa++;
            } else {
                median = Bj;
                pb++;
            }
        }
        if ((a.length + b.length) % 2 == 1) {
            return median;
        } else {
            int Ai = pa < a.length ? a[pa] : Integer.MAX_VALUE;
            int Bj = pb < b.length ? b[pb] : Integer.MAX_VALUE;
            int median2 = Math.min(Ai, Bj);
            return (float) (median + median2) / 2;
        }
    }

}
