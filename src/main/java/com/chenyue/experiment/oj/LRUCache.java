package com.chenyue.experiment.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/12/25
 * @description
 */
public class LRUCache {
    private Map<Integer, CacheNode> map;
    private int capacity;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new CacheNode();
        this.tail = new CacheNode();
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            moveToHead(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void moveToHead(int key) {
        CacheNode node = map.get(key);
        CacheNode before = node.prev;
        CacheNode post = node.next;
        before.next = post;
        post.prev = before;
        post = head.next;
        post.prev = node;
        node.next = post;
        node.prev = head;
        head.next = node;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).value = value;
            moveToHead(key);
        }else {
            if(this.capacity == map.size()) {
                CacheNode node = tail.prev;
                CacheNode before = node.prev;
                before.next = tail;
                tail.prev = before;
                map.remove(node.key);
            }
            CacheNode newNode = new CacheNode();
            CacheNode post = head.next;
            head.next = newNode;
            post.prev = newNode;
            newNode.next = post;
            newNode.prev = head;
            map.put(key, newNode);
            newNode.key = key;
            newNode.value = value;
        }

    }

    public static class CacheNode {
        public CacheNode prev;
        public CacheNode next;
        public Integer key;
        public Integer value;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int val = cache.get(1);
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
}
