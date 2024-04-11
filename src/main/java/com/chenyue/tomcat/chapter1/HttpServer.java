package com.chenyue.tomcat.chapter1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/15
 */
public class HttpServer {
    /** WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the
     * working directory.
     * The working directory is the location in the file system
     * from where the java command was invoked.
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    // the shutdown command received
    private boolean shutdown = false;
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
//        System.out.println(System.getProperty("user.dir"));
    }

    //为什么加await() 因为Object有个wait()方法，不能重名
    public void await() {
        ServerSocket serverSocket = null;
        // 服务器端口
        int port = 8080;
        try {
            // 创建一个serverSocket 因为会抛出IOException 使用try-catch捕获处理一下
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            // exit直接回到程序最上层 关闭程序
            System.exit(1);
        }
        // Loop waiting for a request
        // 没有接收到shutdown命令，一直接收请求和响应请求
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                // 阻塞式接收请求
                socket = serverSocket.accept();
                // 接收到一个请求
                input = socket.getInputStream();
                output = socket.getOutputStream();
                // create Request object and parse
                Request request = new Request(input);
                request.parse();
                // create Response object
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
                // Close the socket
                socket.close();
                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
}
