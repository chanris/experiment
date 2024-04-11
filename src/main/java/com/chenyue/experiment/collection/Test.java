package com.chenyue.experiment.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 */
public class Test implements Cloneable {

    private List<Integer> ids;

    public static void main(String[] args) {
        int i = 4;
        int a;
        a = i >> 1;
        System.out.println(i);
        System.out.println(a);
        Test test = new Test();
        test.ids.add(2);
        Arrays.toString(test.ids.toArray());
        Test copytest = test.clone();
    }


    public Test clone() {
        Test test  = new Test();
        test.ids = new ArrayList<>();
        test.ids.add(1);
        return test;
    }
}
