package com.chenyue.experiment;


import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/10
 */
public class Test {
    public Map<Integer, Integer> map;
    public List<Integer> list;


    public Test() {
        this.map = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if(this.map.containsKey(val)) {
            return false;
        }
        this.list.add(val);
        this.map.put(val, this.list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }
        int index = this.map.get(val);
        int lastEle = this.list.get(this.list.size() - 1);
        int tmp = this.list.get(index);
        this.list.set(index, lastEle);
        this.list.set(this.list.size() - 1, tmp);
        this.map.remove(Integer.valueOf(val));
        this.list.remove(this.list.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIdx = new Random().nextInt(this.list.size());
        return this.list.get(randomIdx);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.insert(0);
        test.insert(1);
        test.remove(0);
        test.insert(2);
        test.remove(1);
        System.out.println(test.getRandom());
    }
}
