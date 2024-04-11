package com.chenyue.tomcat.chapter1;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/15
 *
 * 一个经典的请求报文
 * POST /examples/default.jsp HTTP/1.1
 * Accept: text/plain; text/html
 * Accept-Language: en-gb
 * Connection: Keep-Alive
 * Host: localhost
 * User-Agent: Mozilla/4.0 (compatible; MSIE 4.01; Windows 98)
 * Content-Length: 33
 * Content-Type: application/x-www-form-urlencoded
 * Accept-Encoding: gzip, deflate
 * lastName=Franks&firstName=Michael
 */
public class Request {
    private InputStream input;
    private String uri;
    public Request(InputStream input) {
        this.input = input;
    }

    public String getUri() {
        return this.uri;
    }

    public void parse() {
        // Read a set of characters from the socket
        // StringBuffer(capacity) 单位字符 ascii码！
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j=0; j<i; j++) {
            request.append((char) buffer[j]);
        }
//        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    /**
     * 获得请求报文里面的uri地址
     * @param requestString request
     * @return uri
     */
    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }
}
