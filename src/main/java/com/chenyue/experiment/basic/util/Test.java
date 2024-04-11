package com.chenyue.experiment.basic.util;

import java.io.File;

/**
 * @author: chenyue7@foxmail.com
 * @date: 11/9/2023
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        String resourcePath = "src/main/resources/kafka.properties";

        // 使用File类构建文件对象
        File resourceFile = new File(resourcePath);

        if (resourceFile.exists()) {
            // 文件存在，可以进行操作
        } else {
            System.out.println("无法找到资源文件: " + resourcePath);
        }
    }
}
