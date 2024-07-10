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
public class Params <E>{

    private E e;

    public void  add(E e) {
        this.e = e;
    }

    public static void main(String[] args) {
        Params<?> params = new Params<>();
//        params.add("1");

        Params<Object> params2 = new Params<>();
        params2.add("1");


        Params params3 = new Params();
        params3 = params2;
    }

}
