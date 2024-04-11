package com.chenyue.experiment.oj.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 31/3/2024
 * @description
 */
public class lc146 {
    public static void main(String[] args) {

    }

    public static class LRUCache extends LinkedHashMap<Integer, Integer>{

        private static int MAX_ENTRIES;
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true); // accessOrder: 按照读写方式进行维护双向链表
            MAX_ENTRIES = capacity;
        }

        public int get(int key) {
            return super.get(key);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > MAX_ENTRIES;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }


}
