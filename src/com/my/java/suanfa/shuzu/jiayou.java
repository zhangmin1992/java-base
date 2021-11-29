package com.my.java.suanfa.shuzu;

import java.util.HashMap;

/**
 * 功能描述: 加油站有i个，每个加油站到下一个加油站需要消耗cost[i]的油
 * 请问用户从哪个加油站开始出发，可以转一圈之后恰好用完油。
 */
public class jiayou {
    public static void main(String args[]) {
//        int[] nums = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        System.out.println(canCompleteCircuit(nums,cost));

        int[] nums = {5,5,5,5,5};
        int[] cost = {5,5,5,10,20};
        System.out.println(canCompleteCircuitV3(nums,cost));
    }

    public static boolean canCompleteCircuitV3(int[] gas, int[] cost) {
        boolean result = true;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < gas.length; i++){
            map.put(cost[i],map.getOrDefault(cost[i],0)+1);
            //需要找零钱的情况
            if (cost[i] > gas[i]) {
                //没有零钱可以找他
                int remain = cost[i] - gas[i];
                if (remain < 15) {
                    //找零10元或者5元
                    if (map.getOrDefault(remain,0) == 0) {
                        result = false;
                        break;
                    }
                    map.put(remain,map.get(cost[i] - gas[i]) -1);
                }else {
                    //找零15元
                    if (map.getOrDefault(10,0) == 0 || map.getOrDefault(5,0) == 0) {
                        result = false;
                        break;
                    }
                    map.put(10,map.get(10) -1);
                    map.put(5,map.get(5) -1);
                }
            }
        }
        return result;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        for(int i = 0; i < gas.length; i++){
            if(gas[i] >= cost[i]){
                int sum = 0;
                int j = 0;
                for(; j < gas.length; j++){
                    sum += gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
                    if(sum < 0){
                        break;
                    }
                }
                if(j >= gas.length){
                    start = i;
                    break;
                }
            }
        }
        return start;
    }

    public static int canCompleteCircuitV2(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;  //gas所有元素和-cost所有元素和
        int sum = 0;    //从start位置开始，gas中元素和-cost中元素和

        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(sum < 0){
                sum = gas[i] - cost[i];
                start = i;
            }else{
                sum += gas[i] - cost[i];
            }
        }
        if(total < 0){
            return -1;
        }
        return start;
    }
}
