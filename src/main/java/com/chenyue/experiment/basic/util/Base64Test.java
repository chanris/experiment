package com.chenyue.experiment.basic.util;

import java.util.Base64;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/6
 *
 * Base64编码
 * 字符串(字节码)-->加密后的字符串(字节码)
 * Base64操作的都是二进制的字节码
 * Base64加密规则是规定的，所以可以通过反操作来解密
 * 规则: 每三字节(3*8bit)转成四字节(4*6bit)高位补零
 *
 */
public class Base64Test {
    public static void main(String[] args) {
        String str = "Hello, World. 你好世界。";
        String cipher = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(cipher);
        System.out.println(new String(Base64.getDecoder().decode(cipher.getBytes())));
    }
}
