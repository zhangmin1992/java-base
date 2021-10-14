package com.my.java.suanfa.Array;

public class tiaoyueyouxi {
    public static boolean canJump(int[] nums) {
        int lastLocation = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            int needJump = lastLocation - i;
            if(nums[i] >= needJump) lastLocation = i;
            else if(i == 0) return false;
        }
        return true;
    }
    public static void main(String args[]) {
        int[] nums = new int[]{3,0,1,2,4};
        System.out.println(canJump(nums));
    }
}
