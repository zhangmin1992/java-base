package com.my.java.suanfa.hashmap;

public class HashMapDemo {

    public static void main(String[] args) {
        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("通话","cc");
        map.put("重地","cc2");
        map.put("key3","cc3");
        System.out.println(map.get("通话"));
    }
}
