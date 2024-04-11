package com.chenyue.experiment.other;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private ServerSocket serverSocket;

    public SimpleServer(int port) throws Exception {
        // 创建服务器端的Socket
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
    }

    public void startListening() {
        // 循环监听连接请求
        while (true) {
            try {
                System.out.println("Waiting for client connections...");
                // 服务器端接受客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                // 处理客户端连接
                handleClientConnection(clientSocket);

                // 在这里我们不关闭serverSocket，因为想要继续监听其他的连接
                // 但在实际应用中，我们可能会有更复杂的逻辑来决定何时关闭服务器
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClientConnection(Socket clientSocket) {
        // 这里可以开启一个新线程来处理客户端的请求
        // 或者使用线程池来管理多个客户端
        // 这个例子里我们只是简单地关闭了客户端的连接
        try {
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            int port = 1234; // 监听的端口号
            SimpleServer server = new SimpleServer(port);
            server.startListening();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}