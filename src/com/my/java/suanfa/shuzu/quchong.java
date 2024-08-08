package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 * maxSumDivThree 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 * 给定一个整数数组，求数组中可被3整除的最大数
 */
public class quchong {

    public static void main(String[] args) {
        int[] d = new int[]{0,1,2,3,6,4,5,7,8,9,3,1};
        System.out.println(solution1(d));

        System.out.println(maxSumDivThree(d));
    }

    public static int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int sum = Arrays.stream(nums).sum();
        int yu = sum % 3;
        if (yu == 0) {
            return sum;
        }
        List<Integer> one = new ArrayList<Integer>();
        List<Integer> two = new ArrayList<Integer>();
        for (int n : nums) {
            if (n % 3 == 1) {
                one.add(n);
            } else if (n % 3 == 2) {
                two.add(n);
            }
            result.add(n);
        }

        System.out.println(JSONObject.toJSONString(result));
        int res = 0;
        //如果余数是1， 则从one中去除一个, 或者2个two的元素相加余数也是1，去除两个two的元素
        if (yu == 1) {
            if (one.size() > 0) {
                res = sum - one.get(0);
                result.remove(one.get(0));
            }
            if (two.size() > 1) {
                res = Math.max(res, sum - two.get(0) - two.get(1));
            }
        }

        //如果余数是2， 则从two中去除一个, 或者2个one的元素相加余数也是2，去除两个one的元素
        if (yu == 2) {
            if (two.size() > 0) {
                res = sum - two.get(0);
                result.remove(two.get(0));
            }
            if (one.size() > 1) {
                res = Math.max(res, sum - one.get(0) - one.get(1));
            }
        }

        for(int i=result.size()-1;i>=0;i--) {
            temp.add(result.get(i));
        }
        System.out.println(JSONObject.toJSONString(temp));
        return res;
    }

    public static Integer[] isRepeat(int[] arr){
        List list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            boolean contains = list.contains(arr[i]);
            if(!contains) {
                //不包含该元素,直接添加到集合中
                list.add(arr[i]);
            }else{
                list.remove((Integer) arr[i]);
                i--;
            }
        }
        Integer[] result = (Integer[]) list.toArray(new Integer[list.size()]);
        return result;
    }

    public static String solution1(int[] d) {
        int[] cnt = new int[10];
        int[] modulo = new int[3];
        int sum = 0;
        for (int t : d) {
            ++cnt[t];
            ++modulo[t % 3];
            sum += t;
        }
        int l; // %3 == l的数 删除 r 个
        int r;
        int mod = sum % 3;
        if (mod == 0) {
            l = r = 0;
        } else {
            if (modulo[mod] >= 1) {
                l = mod;
                r = 1;
            } else {
                l = 2 * mod % 3;
                r = 2;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            char ch = (char) (i + '0');
            for (int j = 0; j < cnt[i]; ++j) {
                if (r > 0 && i % 3 == l) {
                    --r;
                } else {
                    buffer.append(ch);
                }
            }
        }
        // 0000 的情况
        if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '0') {
            buffer = new StringBuffer("0");
        }
        return buffer.reverse().toString();
    }
}
