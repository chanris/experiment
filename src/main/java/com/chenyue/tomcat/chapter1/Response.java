package com.chenyue.tomcat.chapter1;

import java.io.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/15
 *
 *
 * HTTP/1.1 200 OK
 * Bdpagetype: 1
 * Bdqid: 0xbe330af3000f8343
 * Cache-Control: private
 * Connection: keep-alive
 * Content-Type: text/html;charset=utf-8
 * Server: BWS/1.1
 * X-Ua-Compatible: IE=Edge,chrome=1
 */
public class Response {
    // 接收字节流缓存大小 1024bits即1kb
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;
    BufferedWriter bw;

    public Response(OutputStream output) {
        this.output = output;
        this.bw = new BufferedWriter(new OutputStreamWriter(output));
    }

    /**
     * 输出html file
     *
     * @throws IOException
     */
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                int contentLength = 0;
                String responseHeaderMessage = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n"  +
                        "Content-Length: 301\r\n" +
                        "\r\n";
                output.write(responseHeaderMessage.getBytes());
                fis = new FileInputStream(file);
                // 第一次读file，返回读到的bytes个数
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch!=-1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
                output.flush();
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis!=null) {
                try {
                    fis.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
