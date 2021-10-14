package com.my.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {
    // Hash函数接口
    private final IHashService iHashService;
    // 每个机器节点关联的虚拟节点数量
    private final int  numberOfReplicas;
    // 环形虚拟节点
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

    public ConsistentHash(IHashService iHashService, int numberOfReplicas, Collection<T> nodes) {
        this.iHashService = iHashService;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实机器节点，这里是给hash-真实node的ip节点建立map关联，比如
     * {
     * 	-8915080565495467578: "192.168.0.4",
     * 	-8013623423674078959: "192.168.0.2",
     * 	-7480094344432436657: "192.168.0.3",
     * 	8612405669747965712: "192.168.0.1",
     * 	8905777353324806813: "192.168.0.1",
     * 	9087820709483728251: "192.168.0.3"
     * }
     *circle.firstKey() 表示的是-8915080565495467578
     * @param node T
     */
    public void add(T node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.put(this.iHashService.hash(node.toString() + i), node);
        }
    }

    /**
     * 删除真实机器节点
     *
     * @param node T
     */
    public void remove(T node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.remove(this.iHashService.hash(node.toString() + i));
        }
    }

    public T get(String key) {
        if (circle.isEmpty()) return null;

        long hash = iHashService.hash(key);

        // 沿环的顺时针找到一个虚拟节点
        if (!circle.containsKey(hash)) {
            //circle.tailMap 表示的是从含有虚拟节点的哈希环中获取哈希值大于用户给定key所产生的hash 值的那些个map
            //circle.headMap("C") 示的是从含有虚拟节点的哈希环中获取哈希值小于用户给定key所产生的hash 值的那些个map
            //subMap("B","D")，返回部分集合（键值“
            // B”和“D”之间,包括B不包括D
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}
