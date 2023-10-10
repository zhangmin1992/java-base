package com.my;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 功能描述:
 *
 * 给定一个List<Integer>,包含100个 值，请移除被3整除的元素。
 * public void test(List<Integer> list) {
 *
 * }
 */
public class testList {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(3);
        test(list);
        System.out.println(JSONObject.toJSONString(list));
    }

    public static  void test(List<Integer> list) {
        if (list == null || list.size()==0) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (((Iterator) it).hasNext()) {
            if (it.next() != null && it.next() % 3 == 0) {
                it.remove();
            }
        }

    }
}
