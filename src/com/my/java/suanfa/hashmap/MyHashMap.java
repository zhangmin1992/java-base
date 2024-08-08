package com.my.java.suanfa.hashmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    Entry<K, V>[] table = null;

    int size = 0;

    public MyHashMap() {
        table = new Entry[16];
    }

    private int hash(K k) {
        int index = k.hashCode() % 16;
        return index >= 0 ? index : Math.abs(index);
    }

    @Override public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, index, entry);
            size++;
        }
        return table[index].getValue();
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        Entry<K, V> entry = findValue(table[index], k);
        return entry == null ? null : entry.getValue();
    }

    public Entry<K, V> findValue(Entry<K, V> entry, K k) {
        if (k.equals(entry.getKey()) || k == entry.getKey()) {
            return entry;
        } else {
            if (entry.next != null) {
                return findValue(entry.next, k);
            }
            return null;
        }
    }

    @Override public int size() {
        return size;
    }

    class Entry<K, V> implements MyMap.Entry<K, V> {
        K k;
        V v;
        int index;
        Entry<K, V> next;

        public Entry(K k, V v, int index, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.index = index;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
