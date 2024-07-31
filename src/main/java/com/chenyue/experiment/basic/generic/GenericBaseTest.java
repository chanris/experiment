package com.chenyue.experiment.basic.generic;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/29
 * @description 基本类型不能作为泛型实例，但基本类型的数组类型可以,绝了
 */
public class GenericBaseTest {

    public static void main(String[] args) {
        G<int[]> g = new G<int[]>();
        g.gm(new int[]{1, 2, 3});

        // sort用法+1 -_-
        Arrays.sort(new int[][]{{2,3}, {4,5}, {1, 10}}, (o1, o2) -> o1[0] - o2[0]);
    }

    static class G<T> {
        static <C> void  gm(C params) {}
    }
}
