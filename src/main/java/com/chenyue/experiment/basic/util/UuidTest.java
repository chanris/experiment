package com.chenyue.experiment.basic.util;

import java.util.UUID;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/28
 */
public class UuidTest {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
        System.out.println("uuid size: "+uuid.length());
    }
}
