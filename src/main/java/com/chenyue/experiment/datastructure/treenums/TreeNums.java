package com.chenyue.experiment.datastructure.treenums;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/9
 * @description
 */
public class TreeNums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 1; i <= nums.length; i++) {
            Tree.add(i, nums[i-1]);
        }
        System.out.println(Tree.query(5));
        Tree.add(1, 7);
        System.out.println(Tree.query(5));
        System.out.println(Tree.query(4) - Tree.query(3));
    }
}
