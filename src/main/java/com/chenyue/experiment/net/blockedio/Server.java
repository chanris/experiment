package com.chenyue.experiment.net.blockedio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
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
