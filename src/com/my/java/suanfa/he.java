package com.my.java.suanfa;

public class he {

    //输入一个正数n，输出所有和为n连续正数序列。
    //例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8。
    /**
     * 功能描述: 我们用两个数small和big分别表示序列的最小值和最大值。
     * 首先把small初始化为 1，big初始化为 2。
     * 如果从small到big的序列的和大于n的话，我们向右移动small，相当于从序列中去掉较小的数字。
     * 如果从small到big的序列的和小于n的话，我们向右移动big，相当于向序列中添加big的下一个数字。
     * 一直到small等于(1+n)/2，因为序列至少要有两个数字。
     */
    static void findSubquence(int n) {
        int small = 1;
        int big = 2;
        int sum = small + big;
        int end = (n +1)/2;
        while(small < end) {
            if(sum < n) {
                big++;
                sum += big;
                continue;
            } else if(sum == n) {
                System.out.println(small +"-" +big);
            }
            sum -= small;
            small++;
        }
    }

    public static void main(String[] args) {
        findSubquence(15);
    }
}
