package com.chenyue.experiment.basic.generic;

/**
 * @author chenyue7@foxmail.com
 * @date 2020/08/24
 *
 * 测试当实例为 Params<?> 时, add方法不可用
 *
 * 当使用<?>通配对象是, 实例的添加元素不可用
 *
 */
public class GenericWildcardProblem<E>{

    static class Param<E> {
        private E e;

        public void  add(E e) {
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Param<?> params = new Param<>();
//        params.add("1");

        Param<Object> params2 = new Param<>();
        params2.add("1");

        Param params3 = new Param();
        params3 = params2;
    }

}
