package com.chenyue.tomcat.chapter2;

import java.io.IOException;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/16
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
