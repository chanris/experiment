package com.chenyue.experiment.basic.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description 测试网络阻塞io
 */
public class BioServerTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Server()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Client()).start();
    }

    private static class Server implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("Server started");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                    String message = reader.readLine();
                    System.out.println("Recevied message: " + message);

                    writer.println("Server received message:" + message);

                    reader.close();
                    writer.close();
                    clientSocket.close();
                    clientSocket.close();
                    System.out.println("Client disconnected: " + clientSocket);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Client implements Runnable{
        @Override
        public void run() {
            try {
                Socket socket = new Socket("localhost", 8080);
                System.out.println("Connected to server.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello, Server.");
                String response  = reader.readLine();
                System.out.println("Server response: " + response);

                reader.close();
                writer.close();
                socket.close();

                System.out.println("Disconnected from server.");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
