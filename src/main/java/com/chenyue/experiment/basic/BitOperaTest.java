package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/17
 *
 * '与' '非' '或'  '异或'
 *  &    ~    |      ^
 *
 *  << 左移运算符，在低位补0
 *  >> 根据符号位，在高位补1或者0
 *  >>> 不管符合位，高位都补0
 */
public class BitOperaTest {
    public static void main(String[] args) {
        long num = 2L >>> 1;   // 无符号右移相当于除/2
        System.out.println(num);
        num = num << 1;        // 左移相当于乘2
        System.out.println(num);
        num = -2L;
        num = num >>> 1;
        System.out.println(num);
        num = -1L;
        num = num >>> 63;
        System.out.println(num);
        num = num << 63;
        System.out.println(num);
    }
}
