package com.my.java.suanfa.lru;

import java.util.HashMap;

public class LRUCache<K, V> {

    private HashMap<K, CacheNode> caches = new HashMap<K, CacheNode>();

    //队列的容量
    private int capacity;

    private CacheNode first, last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K k, V v) {
        CacheNode node = caches.get(k);
        if (node == null) {
            if (caches.size() >= capacity) {
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
            node.value = v;
        }
        moveToFirst(node);
        caches.put(k, node);
    }

    public Object get(K k) {
        CacheNode node = caches.get(k);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    public Object remove(K k) {
        CacheNode node = caches.get(k);
        if (node != null) {
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            //头节点替换下一个
            if (node == first) {
                first = node.next;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            //尾节点替换上一个
            if (node == last) {
                last = node.pre;
            }
        }
        return caches.remove(k);
    }

    public void clear() {
        first = null;
        last = null;
        caches.clear();
    }


    private void moveToFirst(CacheNode node) {
        //node 已经是头节点
        if (first == node) {
            return;
        }
        //先把node节点删除
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node == last) {
            last = last.pre;
        }
        if (first == null || last == null) {
            first = last = node;
            return;
        }

        //node 设置为当前first 节点的头节点
        node.next = first;
        first.pre = node;
        first = node;
        //这一句是为了删除
        first.pre = null;

    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        LRUCache<Integer, String> lru = new LRUCache<Integer, String>(3);

        lru.put(1, "a");    // 1:a
        System.out.println(lru.toString());
        lru.put(2, "b");    // 2:b 1:a
        System.out.println(lru.toString());
        lru.put(3, "c");    // 3:c 2:b 1:a
        System.out.println(lru.toString());
        lru.put(4, "d");    // 4:d 3:c 2:b
        System.out.println(lru.toString());
        lru.put(1, "aa");   // 1:aa 4:d 3:c
        System.out.println(lru.toString());
        lru.put(2, "bb");   // 2:bb 1:aa 4:d
        System.out.println(lru.toString());
        lru.put(5, "e");    // 5:e 2:bb 1:aa
        System.out.println(lru.toString());
        lru.get(1);         // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(11);     // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(1);      //5:e 2:bb
        System.out.println(lru.toString());
        lru.put(1, "aaa");  //1:aaa 5:e 2:bb
        System.out.println(lru.toString());
    }

}
