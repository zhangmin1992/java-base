package com.my.java.suanfa;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class NBaoshu {

    public static void main(String[] args) {
        System.out.println(getNBaoShuTaoTai(8));
    }

    public static int cycle(int total,int k){
        List<Integer> dataList = new LinkedList<Integer>();
        //添加数据成员
        for (int i = 0; i < total; i++) {
            dataList.add(new Integer(i + 1));
        }
        int index = -1;
        //循环
        while (dataList.size() > 1) {
            index = (index + k) % dataList.size();//以(index+k)对size()取余
            dataList.remove(index--);
        }
        return ((Integer) dataList.get(0).intValue());//返回它的值
    }

    public static Integer getNBaoShuTaoTai(Integer n) {
        List<Integer> group = Lists.newArrayList();
        for(int i=1;i<=n;i++) {
            group.add(i);
        }
        int number = 0;
        for(int i=1;i<=n;i++) {
            if(number == 2) {
                System.out.println("即将被淘汰的人是"+i + "--"+n);
                group.remove(Integer.valueOf(i));
                System.out.println("淘汰后剩下的人是" + JSONObject.toJSONString(group));
                //被淘汰总人数-1
                n--;
                i--;
            }
            number++;
            //报完一圈了,让i从0开始
            if(i == n-1) {
                System.out.println("报完一圈剩下的人是" + JSONObject.toJSONString(group));
                i=-1;
            }
            if(n ==1) {
                System.out.println("最后剩下的人是" + n);
                break;
            }
        }
        return n;
    }
}
